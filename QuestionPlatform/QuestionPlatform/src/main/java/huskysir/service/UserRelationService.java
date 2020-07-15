package huskysir.service;

import huskysir.entity.Answer;
import huskysir.entity.Question;
import huskysir.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 业务层 用户关注/赞同服务接口
 */
public interface UserRelationService {

    /**
     * 查询某用户关注的所有用户(输入用户编号)
     * @param user_id
     * @return
     */
    List<User> findAllOfToUser(Integer user_id);

    /**
     * 查询某用户关注的用户数(输入用户编号)
     * @param user_id
     * @return
     */
    Integer findTotalOfToUser(Integer user_id);

    /**
     * 查询关注某用户的所有用户(输入用户编号)
     * @param user_id
     * @return
     */
    List<User> findAllOfFromUser(Integer user_id);

    /**
     * 查询关注某用户的用户数（输入用户编号）
     * @param user_id
     * @return
     */
    Integer findTotalOfFromUser(Integer user_id);

    /**
     * 查询某用户关注的所有问题(输入用户编号)
     * @param user_id
     * @return
     */
    List<Question> findAllOfToQuestion(Integer user_id);

    /**
     * 查询某用户关注的问题数目(输入用户编号)
     * @param user_id
     * @return
     */
    Integer findTotalOfToQuestion(Integer user_id);

    /**
     * 查询某用户赞同的所有回答(输入用户编号)
     * @param user_id
     * @return
     */
    List<Answer> findAllOfToAnswer(Integer user_id);

    /**
     * 查询某用户关注的回答数(输入用户编号)
     * @param user_id
     * @return
     */
    Integer findTotalOfToAnswer(Integer user_id);

    /**
     * 新增某用户关注某用户
     * @param from_user_id
     * @param to_user_id
     * @return
     */
    Boolean saveUserFollowUser(Integer from_user_id,Integer to_user_id);

    /**
     * 删除某用户关注某用户
     * @param from_user_id
     * @param to_user_id
     * @return
     */
    Boolean deleteUserFollowUser(Integer from_user_id,Integer to_user_id);

    /**
     * 新增某用户关注某问题
     * @param from_user_id
     * @param to_question_id
     * @return
     */
    Boolean saveUserFollowQuestion(Integer from_user_id,Integer to_question_id);

    /**
     * 删除某用户关注某问题
     * @param from_user_id
     * @param to_question_id
     * @return
     */
    Boolean deleteUserFollowQuestion(Integer from_user_id,Integer to_question_id);

    /**
     * 新增某用户赞同某回答
     * @param from_user_id
     * @param to_answer_id
     * @return
     */
    Boolean saveUserSupportAnswer(Integer from_user_id,Integer to_answer_id);

    /**
     * 删除某用户赞同某回答
     * @param from_user_id
     * @param to_answer_id
     * @return
     */
    Boolean deleteUserSupportAnswer(Integer from_user_id,Integer to_answer_id);
}
