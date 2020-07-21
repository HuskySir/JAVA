package huskysir.controller;

import huskysir.entity.Comment;
import huskysir.entity.User;
import huskysir.service.AnswerService;
import huskysir.service.CommentService;
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
 * 表现层 评论
 *
 * ************************
 *                        *
 * 子评论功能还有缺陷 故先放弃 *
 *                        *
 **************************
 */
@Controller
@RequestMapping(value = "/Comment")
public class CommentController {

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
     * 进入做出评论页面
     * @param answer_id
     * @param model
     * @return
     */
    @RequestMapping(value = "/MakeComment")
    public String MakeComment(Integer answer_id,Model model) {
        //保存该评论对应的回答编号
        model.addAttribute("answer_id",answer_id);
        return "Comment/makeComment";
    }

    /**
     * 进入评论详细页面，在下方显示子评论 暂不使用子评论功能
     * @param comment_id
     * @param model
     * @return
     */
    @RequestMapping(value = "/DisplayCommentAndChildrenComment")
    public String DisplayCommentAndChildrenComment(Integer comment_id, Model model) {
        //当前评论
        Comment this_comment = commentService.findCommentById(comment_id);
        //当前评论的评论者用户信息
        User this_user = commentService.findUserByCommentId(comment_id);
        //创建评论列表，从当前评论依次接收子评论
        List<Comment> comments = new ArrayList<>();
        /*//创建用户列表，依次接收子评论的评论者用户信息
        List<User> next_users = new ArrayList<>();
        //子评论不为空
        while (commentService.findNextCommentByCommentId(comment_id)!=null) {
            //接收子评论
            Comment next_comment = commentService.findNextCommentByCommentId(comment_id);
            comments.add(next_comment);
            //comment_id变为子评论的id
            comment_id = next_comment.getComment_id();
            //接收子评论的评论者用户信息
            User next_user = commentService.findUserByCommentId(comment_id);
            next_users.add(next_user);

        }*/
        //将当前评论返回前端
        model.addAttribute("this_comment",this_comment);
        //将当前评论对应的评论者用户返回前端
        model.addAttribute("this_user",this_user);
        /*//将子评论列表返回前端
        model.addAttribute("comments",comments);
        //将子评论对应的评论者用户列表返回前端
        model.addAttribute("next_users",next_users);*/
        return "Comment/commentAndChildrenComment";
    }

    /**
     * 进入评论详情信息页面
     * @param comment_id
     * @param model
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/DisplayCommentInfo")
    public String DisplayCommentInfo(Integer comment_id,Model model,HttpSession httpSession) {
        //根据评论编号获取评论信息
        Comment comment = commentService.findCommentById(comment_id);
        //登录者用户编号
        Integer user_id = (Integer) httpSession.getAttribute("login_user_id");
        //判断该评论是否是登录者用户做出
        Boolean MakeByMyself;
        if (user_id == comment.getComment_user_id()) {
            MakeByMyself = true;
        } else {
            MakeByMyself = false;
        }

        //将评论信息传给前端
        model.addAttribute("comment",comment);
        //将该评论是否由登录者做出信息传给前端
        model.addAttribute("MakeByMyself",MakeByMyself);

        return "Comment/commentInfo";
    }

    /**
     * 进入更新评论页面
     * @param comment_id
     * @param model
     * @return
     */
    @RequestMapping(value = "/DisplayUpdateComment")
    public String DisplayUpdateComment(Integer comment_id,Model model) {

        //根据回答编号查询回答信息
        Comment comment = commentService.findCommentById(comment_id);

        //将回答信息传给前端
        model.addAttribute("comment",comment);
        return "Comment/updateComment";
    }

    /**
     * 更新评论
     * @param comment_id
     * @param comment_content
     * @return
     */
    @RequestMapping(value = "/UpdateComment")
    public String UpdateComment(Integer comment_id,String comment_content) {

        //根据评论编号查询数据库中的评论
        Comment database_comment = commentService.findCommentById(comment_id);
        //更改内容
        database_comment.setComment_content(comment_content);
        //更改更新时间
        Date date = new Date();
        database_comment.setComment_time(date);

        System.out.println("评论内容"+database_comment);
        //在数据库中更新评论
        //commentService.updateComment(database_comment);

        return "Comment/updateCommentSuccess";
    }

    /**
     * 新增评论
     * @param answer_id
     * @param comment_content
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/SaveComment")
    public String SaveComment(Integer answer_id, String comment_content, HttpSession httpSession) {
        Integer comment_user_id = (Integer) httpSession.getAttribute("login_user_id");  //登陆者（进行）的用户编号
        //创建一个评论对象
        Comment comment =new Comment();
        comment.setComment_user_id(comment_user_id);        //评论者用户编号
        comment.setComment_answer_id(answer_id);            //评论的回答编号
        comment.setComment_last_id(null);                   //上级评论默认为空 先不开通此功能
        comment.setComment_content(comment_content);        //评论内容
        //评论时间
        Date date = new Date();
        comment.setComment_time(date);

        commentService.saveComment(comment);            //存入数据库
        return "Comment/makeCommentSuccess";
    }

    /**
     * 删除评论
     * @param map
     * @return
     */
    @RequestMapping("/DeleteComment")
    public @ResponseBody Boolean DeleteComment(@RequestBody Map<String,String> map) {

        //要删除的评论编号
        Integer comment_id = Integer.parseInt(map.get("comment_id"));
        //在数据库中删除回答
        commentService.deleteComment(comment_id);

        return true;
    }
}
