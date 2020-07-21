package huskysir.service.impl;

import huskysir.dao.AnswerDao;
import huskysir.dao.CommentDao;
import huskysir.dao.UserDao;
import huskysir.entity.Answer;
import huskysir.entity.Comment;
import huskysir.entity.Question;
import huskysir.entity.User;
import huskysir.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 业务层 评论服务实现类
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService {

    /**
     * 评论dao对象
     */
    @Autowired
    @Qualifier("commentDao")
    private CommentDao commentDao;

    /**
     * 回答dao对象
     */
    @Autowired
    @Qualifier("answerDao")
    private AnswerDao answerDao;

    /**
     * 用户dao对象
     */
    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;

    /**
     * 根据评论编号查询评论
     * @param comment_id
     * @return
     */
    @Override
    public Comment findCommentById(Integer comment_id) {
        return commentDao.findCommentById(comment_id);
    }

    /**
     * 根据用户编号查询评论
     * @param user_id
     * @return
     */
    @Override
    public List<Comment> findCommentByUserId(Integer user_id) {
        return commentDao.findCommentByUserId(user_id);
    }

    /**
     * 根据回答编号查询评论
     * @param answer_id
     * @return
     */
    @Override
    public List<Comment> findCommentByAnswerId(Integer answer_id) {
        return commentDao.findCommentByAnswerId(answer_id);
    }

    /**
     * 查询该回答下的所有一级评论
     * @param answer_id
     * @return
     */
    @Override
    public List<Comment> findFirstCommentByAnswerId(Integer answer_id) {
        //根据回答编号查询回答下所有评论
        List<Comment> all_comments = commentDao.findCommentByAnswerId(answer_id);
        //一级评论列表
        List<Comment> first_comments = new ArrayList<>();
        for (int i=0;i<all_comments.size();i++) {
            //上一个评论编号为空，则为一级评论
            if (all_comments.get(i).getComment_last_id() == null) {
                first_comments.add(all_comments.get(i));
            }
        }
        return first_comments;
    }

    /**
     * 查询该评论所对应的用户信息（输入评论编号）
     * @param comment_id
     * @return
     */
    @Override
    public User findUserByCommentId(Integer comment_id) {
        //根据评论编号获得评论
        Comment comment = commentDao.findCommentById(comment_id);
        //该评论对应的用户编号
        Integer user_id = comment.getComment_user_id();
        //根据用户编号返回用户
        return userDao.findUserById(user_id);
    }

    /**
     * 查询该评论所对应的回答信息（输入评论编号）
     * @param comment_id
     * @return
     */
    @Override
    public Answer findAnswerByCommentId(Integer comment_id) {
        //根据评论编号获得评论
        Comment comment = commentDao.findCommentById(comment_id);
        //该评论对应的回答编号
        Integer answer_id = comment.getComment_answer_id();
        //根据回答编号返回回答
        return answerDao.findAnswerById(answer_id);
    }

    /**
     * 查询该评论的上级评论信息（输入评论编号，该评论是二级及以下评论，如果不存在上级评论，返回为空）
     * @param comment_id
     * @return
     */
    @Override
    public Comment findPriorCommentByCommentId(Integer comment_id) {
        //根据评论编号获得评论
        Comment comment = commentDao.findCommentById(comment_id);
        //判断该评论是否是二级及以下评论
        if (comment.getComment_last_id() != null) {
            //上级评论编号
            Integer prior_comment_id = comment.getComment_last_id();
            //根据上级评论编号返回上级评论信息
            return commentDao.findCommentById(prior_comment_id);
        }
        //不存在上级评论，返回空
        return null;
    }

    /**
     * 查询某一评论的下级评论（输入该评论编号）
     * @param comment_id
     * @return
     */
    @Override
    public Comment findNextCommentByCommentId(Integer comment_id) {
        return commentDao.findNextCommentByCommentId(comment_id);
    }

    /**
     * 新增评论
     * 评论者用户编号、评论所对应的回答编号为必填项
     * @param comment
     */
    @Override
    public void saveComment(Comment comment) {
        commentDao.saveComment(comment);
    }

    /**
     * 更新评论
     * 评论编号、评论者用户编号、评论所对应的回答编号为必填项
     * @param comment
     */
    @Override
    public void updateComment(Comment comment) {
        commentDao.updateComment(comment);
    }

    /**
     * 根据评论编号删除评论
     * 注意：
     *      删除当前评论前，还应当删除该评论的下级评论
     * @param comment_id
     */
    @Override
    public void deleteComment(Integer comment_id) {
        //如果该评论的下级评论非空，即存在下级评论，做出以下操作
        while(commentDao.findNextCommentByCommentId(comment_id) != null){
            //获得下级评论的评论编号
            Integer comment_next_id = commentDao.findNextCommentByCommentId(comment_id).getComment_id();
            //删除下级评论
            deleteComment(comment_next_id);
        }
        //当该评论的下级评论为空，即不存在下级评论时，删除该评论
        commentDao.deleteComment(comment_id);
    }
}
