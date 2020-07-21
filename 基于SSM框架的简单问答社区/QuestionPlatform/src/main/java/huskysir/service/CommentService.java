package huskysir.service;

import huskysir.entity.Answer;
import huskysir.entity.Comment;
import huskysir.entity.Question;
import huskysir.entity.User;

import java.util.List;

/**
 * 业务层 评论服务接口
 */
public interface CommentService {

    /**
     * 根据评论编号查询评论
     * @param comment_id
     * @return
     */
    Comment findCommentById(Integer comment_id);

    /**
     * 根据用户编号查询评论
     * @return
     */
    List<Comment> findCommentByUserId(Integer user_id);

    /**
     * 根据回答编号查询评论
     * @return
     */
    List<Comment> findCommentByAnswerId(Integer answer_id);

    /**
     * 查询该回答下的所有一级评论
     * @param answer_id
     * @return
     */
    List<Comment> findFirstCommentByAnswerId(Integer answer_id);

    /**
     * 查询该评论所对应的用户信息（输入评论编号）
     * @param comment_id
     * @return
     */
    User findUserByCommentId(Integer comment_id);

    /**
     * 查询该评论所对应的回答信息（输入评论编号）
     * @param comment_id
     * @return
     */
    Answer findAnswerByCommentId(Integer comment_id);

    /**
     * 查询该评论的上级评论信息（输入评论编号，该评论是二级及以下评论）
     * @param comment_id
     * @return
     */
    Comment findPriorCommentByCommentId(Integer comment_id);

    /**
     * 查询某一评论的下级评论（输入该评论编号）
     * @param comment_id
     * @return
     */
    Comment findNextCommentByCommentId(Integer comment_id);

    /**
     * 新增评论
     * 评论者用户编号、评论所对应的回答编号为必填项
     * @param comment
     */
    void saveComment(Comment comment);

    /**
     * 更新评论
     * 评论编号、评论者用户编号、评论所对应的回答编号为必填项
     * @param comment
     */
    void updateComment(Comment comment);

    /**
     * 根据ID删除评论
     * 注意：
     *      删除当前评论前，还应当删除该评论的下级评论
     * @param comment_id
     */
    void deleteComment(Integer comment_id);
}
