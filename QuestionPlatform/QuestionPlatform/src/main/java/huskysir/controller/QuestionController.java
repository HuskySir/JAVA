package huskysir.controller;

import huskysir.entity.Answer;
import huskysir.entity.Question;
import huskysir.entity.User;
import huskysir.service.AnswerService;
import huskysir.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 表现层 问题
 */
@Controller
@RequestMapping(value = "/Question")
public class QuestionController {

    /**
     * 问题service对象
     */
    @Autowired
    @Qualifier("questionService")
    private QuestionService questionService;

    /**
     * 回答service对象
     */
    @Autowired
    @Qualifier("answerService")
    private AnswerService answerService;

    /**
     * 进入进行提问页面（新增问题）
     * @return
     */
    @RequestMapping(value = "/AskQuestion")
    public String AskQuestion() {
        return "Question/askQuestion";
    }

    /**
     * 进入所有问题列表页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/DisplayAllQuestionList")
    public String DisplayAllQuestionList(Model model) {

        List<Question> questions = questionService.findAll(); //所有问题

        //查询提出该问题的用户信息
        List<User> users = new ArrayList<>();       //初始化用户列表
        for (int i=0;i<questions.size();i++) {
            User user = questionService.findUserByQuestionId(questions.get(i).getQuestion_id());  //得到提出该问题的用户信息
            users.add(user);        //将用户信息存入用户列表
        }
        Integer count = questionService.findTotal();    //总问题数
        String method = "DisplayAllQuestionList";       //判断由哪个控制器方法返回的jsp页面

        model.addAttribute("questions",questions);  //存入问题信息，等待前端使用
        model.addAttribute("users",users);          //存入用户信息，等待前端使用
        model.addAttribute("count",count);          //存入总问题数信息，等待前端使用
        model.addAttribute("method",method);        //存入跳转的该方法名，等待前端使用
        return "Question/questionList";                //返回问题列表页面
    }

    /**
     * 进入根据查询进入的问题列表页面
     * @param input_question_title
     * @param model
     * @return
     */
    @RequestMapping(value = "/DisplayQuestionListByCondition",method = {RequestMethod.POST})
    public String DisplayQuestionListByCondition(String input_question_title,Model model) {

        //创建一个新的问题对象，将问题标题设为前端传来的关键字
        Question input_question = new Question();
        input_question.setQuestion_title(input_question_title);
        List<Question> questions = questionService.findQuestionByCondition(input_question); //得到满足条件的问题列表

        //查询提出该问题的用户信息
        List<User> users = new ArrayList<>();       //初始化用户列表
        for (int i=0;i<questions.size();i++) {
            User user = questionService.findUserByQuestionId(questions.get(i).getQuestion_id());  //得到提出该问题的用户信息
            users.add(user);        //将用户信息存入用户列表
        }
        Integer count = questions.size();    //符合条件的问题数
        String method = "DisplayQuestionListByCondition";       //判断由哪个控制器方法返回的jsp页面

        model.addAttribute("questions",questions);  //存入问题信息，等待前端使用
        model.addAttribute("users",users);          //存入用户信息，等待前端使用
        model.addAttribute("count",count);          //存入总问题数信息，等待前端使用
        model.addAttribute("method",method);        //存入跳转的该方法名，等待前端使用
        return "Question/questionList";                //返回问题列表页面
    }

    /**
     * 进入问题及回答页面
     * @param question_id
     * @param model
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/DisplayQuestionAndAnswer")
    public String DisplayQuestionAndAnswer(Integer question_id,Model model,HttpSession httpSession) {

        //根据问题编号查询问题
        Question question = questionService.findQuestionById(question_id);
        //查询提出该问题的用户信息
        User ask_question_user = questionService.findUserByQuestionId(question_id);
        //查询该问题下的所有回答
        List<Answer> answers = answerService.findAnswerByQuestionId(question_id);
        //该问题下每条回答的回答者用户信息
        List<User> make_answer_users = new ArrayList<>();

        //每条回答的一级评论数及对应的回答者用户信息，以及对回答的内容做处理
        List<Integer> first_comment_counts = new ArrayList<>();
        for (int i=0;i<answers.size();i++) {
            //回答内容长度大于100对其进行处理
            //每条回答的内容
            String answer_content = answers.get(i).getAnswer_content();
            if(answer_content.length()>100) {
                answer_content = answer_content.substring(0,100)+"......"; //截取前100个字符并加上省略号
                answers.get(i).setAnswer_content(answer_content);
            }
            Integer first_comment_count = answerService.findTotalOfFirstComment(answers.get(i).getAnswer_id()); //该条回答下的一级评论数
            first_comment_counts.add(first_comment_count);
            User make_answer_user = answerService.findUserByAnswerId(answers.get(i).getAnswer_id());            //该条回答的回答者用户信息
            make_answer_users.add(make_answer_user);
        }

        //将当前登录者编号返回给前端
        Integer login_user_id = (Integer) httpSession.getAttribute("login_user_id");
        model.addAttribute("login_user_id",login_user_id);
        //将问题信息返回给前端
        model.addAttribute("question",question);
        //将提出该问题的用户信息返回给前端
        model.addAttribute("ask_question_user",ask_question_user);
        //将该问题下的所有回答返回给前端
        model.addAttribute("answers",answers);
        //将每条回答的一级评论数返回给前端
        model.addAttribute("first_comment_counts",first_comment_counts);
        //将每条回答对应的回答者用户信息返回给前端
        model.addAttribute("make_answer_users",make_answer_users);
        return "Question/questionAndAnswer";
    }

    /**
     * 进入问题详情信息页面
     * @param question_id
     * @param model
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/DisplayQuestionInfo")
    public String DisplayQuestionInfo(Integer question_id,Model model,HttpSession httpSession) {
        //根据问题编号获得问题信息
        Question question = questionService.findQuestionById(question_id);
        //登录者用户编号
        Integer user_id = (Integer) httpSession.getAttribute("login_user_id");
        //判断该问题是否是登录者用户提出
        Boolean AskByMyself;
        if (user_id == question.getQuestion_user_id()) {
            AskByMyself = true;
        } else {
            AskByMyself = false;
        }

        //将问题信息传给前端
        model.addAttribute("question",question);
        //将该问题是否由登录者提出信息传给前端
        model.addAttribute("AskByMyself",AskByMyself);

        return "Question/questionInfo";
    }

    /**
     * 进入更新问题页面
     * @param question_id
     * @param model
     * @return
     */
    @RequestMapping("/DisplayUpdateQuestion")
    public String DisplayUpdateQuestion(Integer question_id,Model model) {

        //根据问题编号查询问题信息
        Question question = questionService.findQuestionById(question_id);

        //将问题信息传给前端
        model.addAttribute("question",question);
        return "Question/updateQuestion";
    }

    /**
     * 更新问题
     * @param question_id
     * @param question_title
     * @param question_content
     * @return
     */
    @RequestMapping(value = "/UpdateQuestion")
    public String UpdateQuestion(Integer question_id,String question_title,String question_content) {

        //根据问题编号查询数据库中的问题
        Question database_question = questionService.findQuestionById(question_id);
        //更改标题
        database_question.setQuestion_title(question_title);
        //更改内容
        database_question.setQuestion_content(question_content);
        //更改更新时间
        Date date = new Date();
        database_question.setQuestion_update_time(date);

        //在数据库中更新问题
        questionService.updateQuestion(database_question);

        return "Question/updateQuestionSuccess";
    }

    /**
     * 新增问题
     * @param question_title
     * @param question_content
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/SaveQuestion")
    public String SaveQuestion(String question_title,String question_content, HttpSession httpSession) {
        //提出者用户编号
        Integer user_id = (Integer) httpSession.getAttribute("login_user_id");
        //创建一个问题对象
        Question question = new Question();
        question.setQuestion_user_id(user_id);              //问题的提出者用户编号
        question.setQuestion_title(question_title);         //问题的标题
        question.setQuestion_content(question_content);     //问题的内容
        question.setQuestion_view_count(0);                 //问题的浏览量
        question.setQuestion_follow_count(0);               //问题的关注量
        question.setQuestion_answer_count(0);               //问题的回答量
        Date date = new Date();
        question.setQuestion_update_time(date);             //问题更新时间
        question.setQuestion_create_time(date);             //问题创建时间
        question.setQuestion_status(1);                     //问题的状态

        questionService.saveQuestion(question);             //将问题存入数据库

        return "Question/saveQuestionSuccess";               //提问成功提示页面
    }

    /**
     * 删除问题
     * @param map
     * @return
     */
    @RequestMapping("/DeleteQuestion")
    public @ResponseBody Boolean DeleteQuestion(@RequestBody Map<String,String> map) {

        //要删除的问题编号
        Integer question_id = Integer.parseInt(map.get("question_id"));
        //在数据库中删除问题
        questionService.deleteQuestion(question_id);

        return true;
    }

}
