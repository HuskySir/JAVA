package huskysir.controller;

import huskysir.entity.Answer;
import huskysir.entity.Comment;
import huskysir.entity.Question;
import huskysir.entity.User;
import huskysir.service.AnswerService;
import huskysir.service.CommentService;
import huskysir.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 表现层 回答
 */
@Controller
@RequestMapping(value = "/Answer")
public class AnswerController {

    /**
     * 回答service对象
     */
    @Autowired
    @Qualifier("answerService")
    private AnswerService answerService;

    /**
     * 评论service对象
     */
    @Autowired
    @Qualifier("commentService")
    private CommentService commentService;

    /**
     * 问题service对象
     */
    @Autowired
    @Qualifier("questionService")
    private QuestionService questionService;

    /**
     * 进入做出回答页面
     * @param question_id
     * @param model
     * @return
     */
    @RequestMapping(value = "/MakeAnswer")
    public String MakeAnswer(String question_id,Model model) {
        //保存该回答对应的问题编号
        model.addAttribute("question_id",question_id);
        return "Answer/makeAnswer";
    }

    /**
     * 进入回答及评论页面
     * @param answer_id
     * @param model
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/DisplayAnswerAndComment")
    public String DisplayAnswerAndComment(Integer answer_id, Model model,HttpSession httpSession ) {

        //根据回答编号返回回答信息
        Answer answer = answerService.findAnswerById(answer_id);
        //查询做出该回答的用户信息
        User make_answer_user = answerService.findUserByAnswerId(answer_id);
        //查询该回答下所有一级评论信息
        List<Comment> comments = commentService.findFirstCommentByAnswerId(answer_id);
        //每条一级评论对应的评论者用户信息
        List<User> make_comment_users = new ArrayList<>();
        for (int i=0;i<comments.size();i++) {
            User make_comment_user = commentService.findUserByCommentId(comments.get(i).getComment_id()); //每条一级评论对应的评论者用户信息\
            make_comment_users.add(make_comment_user);
        }

        //将当前登录者编号返回给前端
        Integer login_user_id = (Integer) httpSession.getAttribute("login_user_id");
        model.addAttribute("login_user_id",login_user_id);
        //返回该回答的信息
        model.addAttribute("answer",answer);
        //返回该回答的用户信息
        model.addAttribute("make_answer_user",make_answer_user);
        //返回该回答下所有一级评论信息
        model.addAttribute("comments",comments);
        //返回该回答下所有一级评论对应的评论者用户信息
        model.addAttribute("make_comment_users",make_comment_users);

        return "Answer/answerAndComment";
    }

    /**
     * 进入回答详情信息页面
     * @param answer_id
     * @param model
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/DisplayAnswerInfo")
    public String DisplayAnswerInfo(Integer answer_id,Model model,HttpSession httpSession) {
        //根据回答编号获取回答信息
        Answer answer = answerService.findAnswerById(answer_id);
        //登录者用户编号
        Integer user_id = (Integer) httpSession.getAttribute("login_user_id");
        //判断该回答是否是登录者用户做出
        Boolean MakeByMyself;
        if (user_id == answer.getAnswer_user_id()) {
            MakeByMyself = true;
        } else {
            MakeByMyself = false;
        }

        //将回答信息传给前端
        model.addAttribute("answer",answer);
        //将该回答是否由登录者做出信息传给前端
        model.addAttribute("MakeByMyself",MakeByMyself);

        return "Answer/answerInfo";
    }

    /**
     * 进入更新回答页面
     * @param answer_id
     * @param model
     * @return
     */
    @RequestMapping(value = "/DisplayUpdateAnswer")
    public String DisplayUpdateAnswer(Integer answer_id,Model model) {

        //根据回答编号查询回答信息
        Answer answer = answerService.findAnswerById(answer_id);

        //将回答信息传给前端
        model.addAttribute("answer",answer);
        return "Answer/updateAnswer";
    }

    /**
     * 更新回答
     * @param answer_id
     * @param answer_content
     * @return
     */
    @RequestMapping(value = "/UpdateAnswer")
    public String UpdateAnswer(Integer answer_id,String answer_content) {

        //根据回答编号查询数据库中的回答
        Answer database_answer = answerService.findAnswerById(answer_id);
        //更改内容
        database_answer.setAnswer_content(answer_content);
        //更改更新时间
        Date date = new Date();
        database_answer.setAnswer_update_time(date);

        //在数据库中更新回答
        answerService.updateAnswer(database_answer);

        return "Answer/updateAnswerSuccess";
    }

    /**
     * 新增回答
     * @param question_id
     * @param answer_content
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/SaveAnswer")
    public String SaveAnswer(Integer question_id, String answer_content, HttpSession httpSession) {
        Integer answer_user_id = (Integer) httpSession.getAttribute("login_user_id");  //登陆者（进行回答）的用户编号
        //创建一个回答对象
        Answer answer = new Answer();
        answer.setAnswer_user_id(answer_user_id);       //回答者用户编号
        answer.setAnswer_question_id(question_id);      //回答对应的问题编号
        answer.setAnswer_content(answer_content);       //回答内容
        answer.setAnswer_view_count(0);                 //回答浏览量
        answer.setAnswer_agree_count(0);                //回答赞同量
        Date date = new Date();
        answer.setAnswer_update_time(date);             //回答更新时间
        answer.setAnswer_create_time(date);             //回答创建时间
        answer.setAnswer_status(1);                     //回答状态

        //更新该回答对应的问题的回答数
        Question question = questionService.findQuestionById(question_id);
        Integer question_answer_count = questionService.findTotalOfAnswer(question_id);
        question.setQuestion_answer_count(question_answer_count+1);     //回答量+1
        questionService.updateQuestion(question);       //更新问题信息

        System.out.println("问题的回答数"+question_answer_count);
        System.out.println("更新后问题"+question);

        //将回答存入数据库
        answerService.saveAnswer(answer);

        return "Answer/makeAnswerSuccess";              //进入回答成功页面
    }

    /**
     * 删除回答
     * @param map
     * @return
     */
    @RequestMapping("/DeleteAnswer")
    public @ResponseBody Boolean DeleteAnswer(@RequestBody Map<String,String> map) {

        //要删除的回答编号
        Integer answer_id = Integer.parseInt(map.get("answer_id"));
        //查找该回答对应的问题
        Question question = answerService.findQuestionByAnswerId(answer_id);
        //更新该回答对应的问题的回答数
        Integer question_answer_count = questionService.findTotalOfAnswer(question.getQuestion_id());
        question.setQuestion_answer_count(question_answer_count-1);     //回答量-1
        questionService.updateQuestion(question);       //更新问题信息

        //在数据库中删除回答
        answerService.deleteAnswer(answer_id);

        return true;
    }

}
