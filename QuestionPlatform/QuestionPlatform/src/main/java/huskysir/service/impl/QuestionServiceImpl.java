package huskysir.service.impl;

import huskysir.dao.QuestionDao;
import huskysir.dao.UserDao;
import huskysir.entity.Answer;
import huskysir.entity.Question;
import huskysir.entity.User;
import huskysir.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务层 问题服务实现类
 */
@Service("questionService")
public class QuestionServiceImpl implements QuestionService {

    /**
     * 问题dao对象
     */
    @Autowired
    @Qualifier("questionDao")
    private QuestionDao questionDao;

    /**
     * 用户dao对象
     */
    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;

    /**
     * 根据问题编号查询问题
     * @param question_id
     * @return
     */
    @Override
    public Question findQuestionById(Integer question_id) {
        return questionDao.findQuestionById(question_id);
    }

    /**
     * 查询所有问题
     * @return
     */
    @Override
    public List<Question> findAll() {
        return questionDao.findAll();
    }

    /**
     * 查询总问题数
     * @return
     */
    @Override
    public Integer findTotal() {
        return questionDao.findTotal();
    }

    /**
     * 查询提出该问题的用户信息(输入问题编号）
     * @param question_id
     * @return
     */
    @Override
    public User findUserByQuestionId(Integer question_id) {
        //根据问题编号获得问题
        Question question = questionDao.findQuestionById(question_id);
        //该问题对应的用户编号
        Integer user_id = question.getQuestion_user_id();
        return userDao.findUserById(user_id);
    }

    /**
     * 查询该问题下的所有回答(输入问题编号）
     * @param question_id
     * @return
     */
    @Override
    public List<Answer> findAllOfAnswer(Integer question_id) {
        return questionDao.findAllOfAnswer(question_id);
    }

    /**
     * 查询该问题下的所有回答数(输入问题编号）
     * @param question_id
     * @return
     */
    @Override
    public Integer findTotalOfAnswer(Integer question_id) {
        return questionDao.findTotalOfAnswer(question_id);
    }

    /**
     * 查询关注某问题的所有用户(输入问题编号)
     * @param question_id
     * @return
     */
    @Override
    public List<User> findAllOfFromUser(Integer question_id) {
        return questionDao.findAllOfFromUser(question_id);
    }

    /**
     * 查询关注某问题的用户数(输入问题编号)
     * @param question_id
     * @return
     */
    @Override
    public Integer findTotalOfFromUser(Integer question_id) {
        return questionDao.findTotalOfFromUser(question_id);
    }

    /**
     * 根据传入参数查询
     * 问题编号、提问者用户编号、问题标题（模糊匹配）、问题状态
     * @param question
     * @return
     */
    @Override
    public List<Question> findQuestionByCondition(Question question) {
        return questionDao.findQuestionByCondition(question);
    }

    /**
     * 新增问题
     * 问题的提问者用户编号、问题状态为必填项
     * @param question
     */
    @Override
    public void saveQuestion(Question question) {
        questionDao.saveQuestion(question);
    }

    /**
     * 更新问题
     * 问题编号、问题的提问者用户编号、问题状态为必填项
     * @param question
     */
    @Override
    public void updateQuestion(Question question) {
        questionDao.updateQuestion(question);
    }

    /**
     * 根据问题编号删除问题
     * @param question_id
     */
    @Override
    public void deleteQuestion(Integer question_id) {
        questionDao.deleteQuestion(question_id);
    }
}
