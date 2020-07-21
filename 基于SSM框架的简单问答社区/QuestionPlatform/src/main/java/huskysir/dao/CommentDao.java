package huskysir.dao;

import huskysir.entity.Answer;
import huskysir.entity.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 持久层 评论接口
 */
@Repository("commentDao")
public interface CommentDao {

    /**
     * 根据评论编号查询评论
     * @param comment_id
     * @return
     */
    Comment findCommentById(Integer comment_id);

    /**
     * 根据用户编号查询评论
     * @param user_id
     * @return
     */
    List<Comment> findCommentByUserId(Integer user_id);

    /**
     * 根据回答编号查询评论
     * @param answer_id
     * @return
     */
    List<Comment> findCommentByAnswerId(Integer answer_id);

    /**
     * 查询某一评论的下级评论（输入该评论编号）
     * @param comment_id
     * @return
     */
    Comment findNextCommentByCommentId(Integer comment_id);

    /**
     * 新增评论
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
     * 根据评论编号删除评论
     * @param comment_id
     */
    void deleteComment(Integer comment_id);
}
