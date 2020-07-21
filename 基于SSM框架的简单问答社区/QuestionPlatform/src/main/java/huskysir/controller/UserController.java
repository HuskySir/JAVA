package huskysir.controller;

import huskysir.entity.*;
import huskysir.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * 表现层 用户
 */
@Controller
@RequestMapping(value = "/User")
public class UserController {

    /**
     * 用户service对象
     */
    @Autowired
    @Qualifier("userService")
    private UserService userService;

    /**
     * 用户关系service对象
     */
    @Autowired
    @Qualifier("userRelationService")
    private UserRelationService userRelationService;

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
     * 评论service对象
     */
    @Autowired
    @Qualifier("commentService")
    private CommentService commentService;

    /**
     * 返回用户详细信息
     * @param user_id
     * @param model
     * @return
     */
    @RequestMapping(value = "/DisplayUserInfo")
    public String DisplayUserInfo(Integer user_id,Model model) {

        //根据用户编号得到用户信息
        User user = userService.findUserById(user_id);
        //用户关系类
        UserRelation userRelation = new UserRelation();
        userRelation.setTo_user_count(userRelationService.findTotalOfToUser(user_id));      //关注用户数
        userRelation.setFrom_user_count(userRelationService.findTotalOfFromUser(user_id));  //粉丝数
        userRelation.setAsk_question_count(userService.findTotalOfAskQuestion(user_id));    //提出问题数
        userRelation.setMake_answer_count(userService.findTotalOfMakeAnswer(user_id));      //做出回答数
        userRelation.setMake_comment_count(userService.findTotalOfMakeComment(user_id));    //做出评论数

        model.addAttribute("user",user);                     //存入用户信息
        model.addAttribute("userRelation",userRelation);     //存入用户关系信息
        return "User/userInfo";
    }

    /**
     * 查询关注的所有用户及用户数
     * @param httpSession
     * @param model
     * @return
     */
    @RequestMapping(value = "/FindOfToUser")
    public String FindOfToUser(HttpSession httpSession, Model model) {
        Integer user_id = (Integer) httpSession.getAttribute("login_user_id");      //登录用户的编号
        List<User> users = userRelationService.findAllOfToUser(user_id);               //关注的用户列表
        List<UserRelation> userRelations = new ArrayList<>();                          //用户关系列表
        //获取关注的用户的用户关系信息
        for (int i = 0;i<users.size();i++) {
            UserRelation userRelation = new UserRelation();
            userRelation.setFrom_user_count(userRelationService.findTotalOfFromUser(users.get(i).getUser_id())); //该用户的被关注数
            userRelation.setAsk_question_count(userService.findTotalOfAskQuestion(users.get(i).getUser_id()));   //该用户的提出问题数
            userRelation.setMake_answer_count(userService.findTotalOfMakeAnswer(users.get(i).getUser_id()));     //该用户的做出回答数
            userRelations.add(userRelation);
        }
        Integer count = userRelationService.findTotalOfToUser(user_id);                //关注的用户数
        model.addAttribute("users",users);                                          //向用户信息页面返回信息：关注的用户列表
        model.addAttribute("userRelations",userRelations);                          //向用户信息页面返回信息：关注的用户的用户关系列表
        model.addAttribute("count",count);                                          //向用户信息页面返回信息：关注的用户数
        String method = "FindOfToUser";                                                //判断由哪个控制器方法返回Jsp页面
        model.addAttribute("method",method);                                        //向用户信息页面返回信息：由FindOfToUser方法跳转
        return "User/userListUser";
    }

    /**
     * 查询关注该用户的所有用户及用户数
     * @param httpSession
     * @param model
     * @return
     */
    @RequestMapping(value = "/FindOfFromUser")
    public String FindOfFromUser(HttpSession httpSession,Model model) {
        Integer user_id = (Integer) httpSession.getAttribute("login_user_id");      //登录用户的编号
        List<User> users = userRelationService.findAllOfFromUser(user_id);             //关注该用户的用户列表
        List<UserRelation> userRelations = new ArrayList<>();                          //用户关系列表
        //获取关注的用户的用户关系信息
        for (int i = 0;i<users.size();i++) {
            UserRelation userRelation = new UserRelation();
            userRelation.setFrom_user_count(userRelationService.findTotalOfFromUser(users.get(i).getUser_id())); //该用户的被关注数
            userRelation.setAsk_question_count(userService.findTotalOfAskQuestion(users.get(i).getUser_id()));   //该用户的提出问题数
            userRelation.setMake_answer_count(userService.findTotalOfMakeAnswer(users.get(i).getUser_id()));     //该用户的做出回答数
            userRelations.add(userRelation);
        }
        Integer count = userRelationService.findTotalOfFromUser(user_id);              //关注该用户的用户数
        model.addAttribute("users",users);                                          //向用户信息页面返回信息：关注该用户的用户列表
        model.addAttribute("userRelations",userRelations);                          //向用户信息页面返回信息：关注该用户的用户关系列表
        model.addAttribute("count",count);                                          //向用户信息页面返回信息：关注该用户的用户数
        String method = "FindOfFromUser";                                              //判断由哪个控制器方法返回Jsp页面
        model.addAttribute("method",method);                                        //向用户信息页面返回信息：由FindOfFromUser方法跳转
        return "User/userListUser";
    }

    /**
     * 查询关注的所有问题及问题数
     * @param httpSession
     * @param model
     * @return
     */
    @RequestMapping(value = "/FindOfToQuestion")
    public String FindOfToQuestion(HttpSession httpSession,Model model) {
        Integer user_id = (Integer) httpSession.getAttribute("login_user_id");      //登录用户的编号
        List<Question> questions = userRelationService.findAllOfToQuestion(user_id);   //关注的问题列表
        List<User> users = new ArrayList<>();                                          //提出关注的问题的用户列表
        for (int i = 0;i<questions.size();i++) {
            User user = questionService.findUserByQuestionId(questions.get(i).getQuestion_id()); //提出关注的问题的用户
            users.add(user);
        }
        Integer count = userRelationService.findTotalOfToQuestion(user_id);            //关注的问题数
        model.addAttribute("users",users);                                          //向问题信息页面返回信息:提出关注的用户的用户信息列表
        model.addAttribute("questions",questions);                                  //向问题信息页面返回信息:关注的问题列表
        model.addAttribute("count",count);                                          //向问题信息页面返回信息：关注的问题数
        String method = "FindOfToQuestion";                                            //判断由哪个控制器方法返回Jsp页面
        model.addAttribute("method",method);                                        //向用户信息页面返回信息：由FindOfToQuestion方法跳转
        return "User/userListQuestion";
    }

    /**
     * 查询关注的所有回答及回答数
     * @param httpSession
     * @param model
     * @return
     */
    @RequestMapping(value = "/FindOfToAnswer")
    public String FindOfToAnswer(HttpSession httpSession,Model model) {
        Integer user_id = (Integer) httpSession.getAttribute("login_user_id");       //登录用户的编号
        List<Answer> answers = userRelationService.findAllOfToAnswer(user_id);          //关注的回答列表
        Integer count = userRelationService.findTotalOfToAnswer(user_id);               //关注的回答数
        List<Question> questions = new ArrayList<>();                               //回答所对应的问题列表
        List<User> question_users = new ArrayList<>();                              //回答所对应的问题的提出者用户列表
        List<User> answer_users = new ArrayList<>();                                //回答所对应的用户列表
        for (int i = 0;i<answers.size();i++) {
            //当回答的内容长度大于100时对其进行处理
            //每条回答的内容
            String answer_content = answers.get(i).getAnswer_content();
            if(answer_content.length()>100) {
                answer_content = answer_content.substring(0,100)+"......"; //截取前100个字符并加上省略号
                answers.get(i).setAnswer_content(answer_content);
            }

            Question question = answerService.findQuestionByAnswerId(answers.get(i).getAnswer_id());  //回答所对应的问题
            questions.add(question);           //将每条回答所对应的问题信息加入问题列表

            //回答所对应的问题的编号
            Integer question_id = question.getQuestion_id();
            //根据问题编号返回提问者用户
            User question_user = questionService.findUserByQuestionId(question_id);
            //将提问者用户信息加入列表
            question_users.add(question_user);

            //回答者用户
            User answer_user = answerService.findUserByAnswerId(answers.get(i).getAnswer_id());
            //将回答者用户信息加入列表
            answer_users.add(answer_user);
        }
        model.addAttribute("questions",questions);                                   //向回答信息页面返回信息:回答所对应的问题列表
        model.addAttribute("question_users",question_users);                         //向回答信息页面返回信息：回答所对应的问题的提出者用户列表
        model.addAttribute("answer_users",answer_users);                             //向回答信息页面返回信息：回答所对应的用户列表
        model.addAttribute("answers",answers);                                       //向回答信息页面返回信息：关注的回答列表
        model.addAttribute("count",count);                                           //向回答信息页面返回信息：关注的回答数
        String method = "FindOfToAnswer";                                               //判断由哪个控制器方法返回Jsp页面
        model.addAttribute("method",method);                                         //向用户信息页面返回信息：由FindOfToAnswer方法跳转
        return "User/userListAnswer";
    }

    /**
     * 查询提出的所有问题及问题数
     * @param httpSession
     * @param model
     * @return
     */
    @RequestMapping(value = "/FindOfAskQuestion")
    public String FindOfAskQuestion(HttpSession httpSession,Model model) {
        Integer user_id = (Integer) httpSession.getAttribute("login_user_id");   //登录用户的编号
        List<Question> questions = userService.findAllOfAskQuestion(user_id);       //提出的问题列表
        List<User> users = new ArrayList<>();                                       //提出关注的问题的用户列表
        for (int i = 0;i<questions.size();i++) {
            User user = questionService.findUserByQuestionId(questions.get(i).getQuestion_id()); //提出关注的问题的用户
            users.add(user);
        }
        Integer count = userService.findTotalOfAskQuestion(user_id);                //提出的问题数
        model.addAttribute("users",users);                                       //向问题信息页面返回信息:提出关注的用户的用户列表
        model.addAttribute("questions",questions);                               //向问题信息页面返回信息:提出的问题列表
        model.addAttribute("count",count);                                       //向问题信息页面返回信息：提出的问题数
        String method = "FindOfAskQuestion";                                        //判断由哪个控制器方法返回Jsp页面
        model.addAttribute("method",method);                                     //向用户信息页面返回信息：由FindOfAskQuestion方法跳转
        return "User/userListQuestion";
    }

    /**
     * 查询做出的所有回答及回答数
     * @param httpSession
     * @param model
     * @return
     */
    @RequestMapping(value = "/FindOfMakeAnswer")
    public String FindOfMakeAnswer(HttpSession httpSession,Model model) {
        Integer user_id = (Integer) httpSession.getAttribute("login_user_id");   //登录用户的编号
        List<Answer> answers = userService.findAllOfMakeAnswer(user_id);            //做出的回答
        Integer count = userService.findTotalOfMakeAnswer(user_id);                 //做出的回答数
        List<Question> questions = new ArrayList<>();                               //回答所对应的问题列表
        List<User> question_users = new ArrayList<>();                              //回答所对应的问题的提出者用户列表
        List<User> answer_users = new ArrayList<>();                                //回答所对应的用户列表
        for (int i = 0;i<answers.size();i++) {
            Question question = answerService.findQuestionByAnswerId(answers.get(i).getAnswer_id());  //回答所对应的问题
            questions.add(question);

            //回答所对应的问题的编号
            Integer question_id = question.getQuestion_id();
            //根据问题编号返回提问者用户
            User question_user = questionService.findUserByQuestionId(question_id);
            //将用户信息加入列表
            question_users.add(question_user);

            User answer_user = answerService.findUserByAnswerId(answers.get(i).getAnswer_id());              //回答所对应的用户
            answer_users.add(answer_user);
        }
        model.addAttribute("questions",questions);                                   //向回答信息页面返回信息:回答所对应的问题列表
        model.addAttribute("question_users",question_users);                         //向回答信息页面返回信息：回答所对应的问题的提出者用户列表
        model.addAttribute("answer_users",answer_users);                             //向回答信息页面返回信息：回答所对应的用户列表
        model.addAttribute("answers",answers);                                       //向回答信息页面返回信息：关注的回答列表
        model.addAttribute("count",count);                                           //向回答信息页面返回信息：关注的回答数
        String method = "FindOfMakeAnswer";                                             //判断由哪个控制器方法返回Jsp页面
        model.addAttribute("method",method);                                         //向用户信息页面返回信息：由FindOfMakeAnswer方法跳转
        return "User/userListAnswer";
    }

    /**
     * 查询做出的所有评论及评论数
     * @param httpSession
     * @param model
     * @return
     */
    @RequestMapping(value = "/FindOfAskComment")
    public String FindOfAskComment(HttpSession httpSession,Model model) {
        Integer user_id = (Integer) httpSession.getAttribute("login_user_id");   //登录用户的编号
        List<Comment> comments = userService.findAllOfMakeComment(user_id);         //做出的评论列表
        Integer count = userService.findTotalOfMakeComment(user_id);                //做出的评论数
        List<User> comment_users = new ArrayList<>();                               //评论者用户列表
        List<Answer> answers = new ArrayList<>();                                   //评论所在的回答
        List<User> answer_users = new ArrayList<>();                                //评论所在的回答的回答者用户
        List<Question> questions = new ArrayList<>();                               //评论所在的问题
        List<User> question_users = new ArrayList<>();                              //评论所在的问题的提出者用户
        List<String> comment_flags = new ArrayList<>();                             //是否是一级评论
        for (int i = 0;i<comments.size();i++) {
            User comment_user = commentService.findUserByCommentId(comments.get(i).getComment_id());
            comment_users.add(comment_user);

            //评论是否为一级评论
            String comment_flag;
            //上级评论为空，为一级评论
            if (comments.get(i).getComment_last_id() == null) {
                comment_flag = "是";
            } else {
                comment_flag = "否";
            }
            comment_flags.add(comment_flag);

            //评论所对应的回答
            Answer answer = commentService.findAnswerByCommentId(comments.get(i).getComment_id());
            answers.add(answer);
            //该回答对应的用户
            User answer_user = answerService.findUserByAnswerId(answer.getAnswer_id());
            answer_users.add(answer_user);
            //评论对应的回答所对应的问题
            Question question = answerService.findQuestionByAnswerId(answer.getAnswer_id());
            questions.add(question);
            //该问题对应的用户
            User question_user = questionService.findUserByQuestionId(question.getQuestion_id());
            question_users.add(question_user);
        }
        model.addAttribute("comments",comments);                                 //向评论信息页面返回信息：做出的评论列表
        model.addAttribute("comment_users",comment_users);                       //向评论信息页面返回信息：评论者用户列表
        model.addAttribute("comment_flags",comment_flags);                       //向评论信息页面返回信息：该评论是否为一级评论
        model.addAttribute("answers",answers);                                   //向评论信息页面返回信息：评论所在的回答
        model.addAttribute("answer_users",answer_users);                         //向评论信息页面返回信息：评论所在回答的回答者用户
        model.addAttribute("questions",questions);                               //向评论信息页面返回信息：评论所在的问题
        model.addAttribute("question_users",question_users);                     //向评论信息页面返回信息：评论所在的问题的提出者用户
        model.addAttribute("count",count);                                       //向评论信息页面返回信息：做出的评论数
        return "User/userListComment";
    }

    /**
     * 进入个人信息页面
     * @param httpSession
     * @param model
     * @return
     */
    @RequestMapping(value = "/DisplayMyInfo")
    public String DisplayMyInfo(HttpSession httpSession, Model model) {
        Integer user_id = (Integer) httpSession.getAttribute("login_user_id");   //登录者个人编号
        User user = userService.findUserById(user_id);  //登录者个人信息

        model.addAttribute("user",user);             //将登录者个人信息返回给前端
        return "User/myInfo";
    }

    /**
     * 进入更新用户信息页面
     * @param httpSession
     * @param model
     * @return
     */
    @RequestMapping(value = "/DisplayUpdateUser")
    public String DisplayUpdateUser(HttpSession httpSession,Model model) {
        Integer user_id = (Integer) httpSession.getAttribute("login_user_id");   //登录者个人编号
        User user = userService.findUserById(user_id);  //登录者个人信息

        model.addAttribute("user",user);             //将登录者个人信息返回给前端
        return "User/updateUser";
    }

    /**
     * 更新用户
     * @param httpSession
     * @param user_nickname
     * @param user_sex
     * @param user_email
     * @param user_password
     * @return
     */
    @RequestMapping(value = "/UpdateUser")
    public String UpdateUser(HttpSession httpSession,String user_nickname,String user_sex,
                                            String user_email,String user_password) {
        //用户编号
        Integer user_id = (Integer) httpSession.getAttribute("login_user_id");

        //根据用户编号查询数据库中的用户信息
        User database_user = userService.findUserById(user_id);
        //修改各项信息
        database_user.setUser_nickname(user_nickname);  //用户昵称
        database_user.setUser_sex(user_sex);            //用户性别
        database_user.setUser_email(user_email);        //用户邮箱
        database_user.setUser_password(user_password);  //用户密码

        //修改数据库信息
        userService.updateUser(database_user);

        return "User/updateUserSuccess";
    }

    /**
     * 确认是否删除用户(注销)
     * @return
     */
    @RequestMapping(value = "/VerifyDeleteUser")
    public String VerifyDeleteUser() {
        return "User/verifyDeleteUser";
    }

    /**
     * 删除用户
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/DeleteUser")
    public String DeleteUser(HttpSession httpSession) {

        //用户编号
        Integer user_id = (Integer) httpSession.getAttribute("login_user_id");

        //删除用户
        userService.deleteUser(user_id);

        return "Login/login";
    }

}
