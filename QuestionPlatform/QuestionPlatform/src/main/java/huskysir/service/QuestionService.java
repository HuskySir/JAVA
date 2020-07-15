package huskysir.service;

import huskysir.entity.Answer;
import huskysir.entity.Question;
import huskysir.entity.User;

import java.util.List;
/**
 * 业务层 问题服务接口
 */
public interface QuestionService {

    /**
     * 根据问题编号查询问题
     * @param question_id
     * @return
     */
    Question findQuestionById(Integer question_id);

    /**
     * 查询所有问题
     * @return
     */
    List<Question> findAll();

    /**
     * 查询总问题数
     * @return
     */
    Integer findTotal();

    /**
     * 查询提出该问题的用户信息(输入问题编号）
     * @param question_id
     * @return
     */
    User findUserByQuestionId(Integer question_id);

    /**
     * 查询该问题下的所有回答(输入问题编号）
     * @param question_id
     * @return
     */
    List<Answer> findAllOfAnswer(Integer question_id);

    /**
     * 查询该问题下的所有回答数(输入问题编号）
     * @param question_id
     * @return
     */
    Integer findTotalOfAnswer(Integer question_id);

    /**
     * 查询关注某问题的所有用户(输入问题编号)
     * @return
     */
    List<User> findAllOfFromUser(Integer question_id);

    /**
     * 查询关注某问题的用户数(输入问题编号)
     * @return
     */
    Integer findTotalOfFromUser(Integer question_id);

    /**
     * 根据传入参数查询
     * 问题编号、提问者用户编号、问题标题（模糊匹配）、问题状态
     * @param question
     * @return
     */
    List<Question> findQuestionByCondition(Question question);

    /**
     * 新增问题
     * 问题的提问者用户编号、问题状态为必填项
     * @param question
     */
    void saveQuestion(Question question);

    /**
     * 更新问题
     * 问题编号、问题的提问者用户编号、问题状态为必填项
     * @param question
     */
    void updateQuestion(Question question);

    /**
     * 根据问题编号删除问题
     * @param question_id
     */
    void deleteQuestion(Integer question_id);
}
