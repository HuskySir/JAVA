package huskysir.service.impl;

import huskysir.dao.UserDao;
import huskysir.entity.Answer;
import huskysir.entity.Comment;
import huskysir.entity.Question;
import huskysir.entity.User;
import huskysir.service.UserRelationService;
import huskysir.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务层 用户服务实现类
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    /**
     * 用户dao对象
     */
    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;

    /**
     * 根据用户名查询用户
     * 用于用户登录及注册
     * @param user_name
     * @return
     */
    @Override
    public User findUserByName(String user_name) {
        return userDao.findUserByName(user_name);
    }

    /**
     * 根据用户编号查询用户
     * @param user_id
     * @return
     */
    @Override
    public User findUserById(Integer user_id) {
        return userDao.findUserById(user_id);
    }

    /**
     * 查询所有用户
     * @return
     */
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    /**
     * 查询总用户数
     * @return
     */
    @Override
    public Integer findTotal() {
        return userDao.findTotal();
    }

    /**
     * 查询某用户提出的所有问题（传入用户编号）
     * @param user_id
     * @return
     */
    @Override
    public List<Question> findAllOfAskQuestion(Integer user_id) {
        return userDao.findAllOfAskQuestion(user_id);
    }

    /**
     * 查询某用户提出的问题数（传入用户编号）
     * @param user_id
     * @return
     */
    @Override
    public Integer findTotalOfAskQuestion(Integer user_id) {
        return userDao.findTotalOfAskQuestion(user_id);
    }

    /**
     * 查询某用户做出的所有回答（传入用户编号）
     * @param user_id
     * @return
     */
    @Override
    public List<Answer> findAllOfMakeAnswer(Integer user_id) {
        return userDao.findAllOfMakeAnswer(user_id);
    }

    /**
     * 查询某用户做出的回答数（传入用户编号）
     * @param user_id
     * @return
     */
    @Override
    public Integer findTotalOfMakeAnswer(Integer user_id) {
        return userDao.findTotalOfMakeAnswer(user_id);
    }

    /**
     * 查询某用户做出的所有评论（传入用户编号）
     * @param user_id
     * @return
     */
    @Override
    public List<Comment> findAllOfMakeComment(Integer user_id) {
        return userDao.findAllOfMakeComment(user_id);
    }

    /**
     * 查询某用户做出的评论数（传入用户编号）
     * @param user_id
     * @return
     */
    @Override
    public Integer findTotalOfMakeComment(Integer user_id) {
        return userDao.findTotalOfMakeComment(user_id);
    }

    /**
     * 根据传入参数条件查询
     * @param user 查询条件：用户编号、用户名、用户昵称、用户性别、用户状态
     * @return
     */
    @Override
    public List<User> findUserByCondition(User user) {
        return userDao.findUserByCondition(user);
    }

    /**
     * 新增用户
     * 用户名、用户性别、用户密码、用户状态为必填项
     * @param user
     */
    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    /**
     * 更新用户
     * 用户编号、用户名、用户性别、用户密码、用户状态为必填项
     * @param user
     */
    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    /**
     * 根据用户编号删除用户
     * @param user_id
     */
    @Override
    public void deleteUser(Integer user_id) {
        userDao.deleteUser(user_id);
    }
}
