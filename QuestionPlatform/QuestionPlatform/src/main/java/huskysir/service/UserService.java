package huskysir.service;

import huskysir.entity.Answer;
import huskysir.entity.Comment;
import huskysir.entity.Question;
import huskysir.entity.User;

import java.util.List;

/**
 * 业务层 用户服务
 */
public interface UserService {

    /**
     * 根据用户名查询用户
     * 用于用户登录及注册
     * @param user_name
     * @return
     */
    User findUserByName(String user_name);

    /**
     * 根据用户编号查询用户
     * @param user_id
     * @return
     */
    User findUserById(Integer user_id);

    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();

    /**
     * 查询总用户数
     * @return
     */
    Integer findTotal();

    /**
     * 查询某用户提出的所有问题（传入用户编号）
     * @param user_id
     * @return
     */
    List<Question> findAllOfAskQuestion(Integer user_id);

    /**
     * 查询某用户提出的问题数（传入用户编号）
     * @param user_id
     * @return
     */
    Integer findTotalOfAskQuestion(Integer user_id);

    /**
     * 查询某用户做出的所有回答（传入用户编号）
     * @param user_id
     * @return
     */
    List<Answer> findAllOfMakeAnswer(Integer user_id);

    /**
     * 查询某用户做出的回答数（传入用户编号）
     * @param user_id
     * @return
     */
    Integer findTotalOfMakeAnswer(Integer user_id);

    /**
     * 查询某用户做出的所有评论（传入用户编号）
     * @param user_id
     * @return
     */
    List<Comment> findAllOfMakeComment(Integer user_id);

    /**
     * 查询某用户做出的评论数（传入用户编号）
     * @param user_id
     * @return
     */
    Integer findTotalOfMakeComment(Integer user_id);

    /**
     * 根据传入参数条件查询
     * @param user 查询条件：用户编号、用户名、用户昵称、用户性别、用户状态
     * @return
     */
    List<User> findUserByCondition(User user);

    /**
     * 新增用户
     * 用户名、用户性别、用户密码、用户状态为必填项
     * @param user
     */
    void saveUser(User user);

    /**
     * 更新用户
     * 用户编号、用户名、用户性别、用户密码、用户状态为必填项
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据用户编号删除用户
     * @param user_id
     */
    void deleteUser(Integer user_id);
}
