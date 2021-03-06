package huskysir.dao;
import huskysir.entity.Answer;
import huskysir.entity.Comment;
import huskysir.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 持久层 回答接口
 */
@Repository("answerDao")
public interface AnswerDao {

    /**
     * 根据回答编号查询回答
     * @param answer_id
     * @return
     */
    Answer findAnswerById(Integer answer_id);

    /**
     * 根据用户编号查询回答
     * @param user_id
     * @return
     */
    List<Answer> findAnswerByUserId(Integer user_id);

    /**
     * 根据问题编号查询回答
     * @param question_id
     * @return
     */
    List<Answer> findAnswerByQuestionId(Integer question_id);

    /**
     * 查询该回答下的所有一级评论(输入回答编号，一级评论指对回答的评论）
     * @param answer_id
     * @return
     */
    List<Comment> findAllOfFirstComment(Integer answer_id);

    /**
     * 查询该回答下的所有一级评论数(输入回答编号，一级评论指对回答的评论）
     * @param answer_id
     * @return
     */
    Integer findTotalOfFirstComment(Integer answer_id);

    /**
     * 查询赞同某回答的所有用户(输入回答编号)
     * @param answer_id
     * @return
     */
    List<User> findAllOfFromUser(Integer answer_id);

    /**
     * 查询赞同某回答的用户数(输入回答编号)
     * @param answer_id
     * @return
     */
    Integer findTotalOfFromUser(Integer answer_id);

    /**
     * 新增回答
     * 回答者用户编号、回答所对应的问题编号为必填项
     * @param answer
     */
    void saveAnswer(Answer answer);

    /**
     * 更新回答
     * 回答编号、回答者用户编号、回答所对应的问题编号为必填项
     * @param answer
     */
    void updateAnswer(Answer answer);

    /**
     * 根据ID删除回答
     * @param answer_id
     */
    void deleteAnswer(Integer answer_id);
}
