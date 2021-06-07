package huskysir.service.impl;

import huskysir.dao.AnswerDao;
import huskysir.dao.QuestionDao;
import huskysir.dao.UserDao;
import huskysir.entity.Answer;
import huskysir.entity.Comment;
import huskysir.entity.Question;
import huskysir.entity.User;
import huskysir.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务层 回答服务实现类
 */
@Service("answerService")
public class AnswerServiceImpl implements AnswerService {

    /**
     * 回答dao对象
     */
    @Autowired
    @Qualifier("answerDao")
    private AnswerDao answerDao;

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
     * 根据回答编号查询回答
     * @param answer_id
     * @return
     */
    @Override
    public Answer findAnswerById(Integer answer_id) {
        return answerDao.findAnswerById(answer_id);
    }

    /**
     * 根据用户编号查询回答
     * @param user_id
     * @return
     */
    @Override
    public List<Answer> findAnswerByUserId(Integer user_id) {
        return answerDao.findAnswerByUserId(user_id);
    }

    /**
     * 根据问题编号查询回答
     * @param question_id
     * @return
     */
    @Override
    public List<Answer> findAnswerByQuestionId(Integer question_id) {
        return answerDao.findAnswerByQuestionId(question_id);
    }

    /**
     * 查询该回答所对应的问题信息(输入回答编号)
     * @param answer_id
     * @return
     */
    @Override
    public Question findQuestionByAnswerId(Integer answer_id) {
        //根据回答编号获得回答
        Answer answer = answerDao.findAnswerById(answer_id);
        //该回答对应的问题编号
        Integer question_id = answer.getAnswer_question_id();
        return questionDao.findQuestionById(question_id);
    }

    /**
     * 查询做出该回答的用户信息(输入回答编号)
     * @param answer_id
     * @return
     */
    @Override
    public User findUserByAnswerId(Integer answer_id) {
        //根据回答编号获得回答
        Answer answer = answerDao.findAnswerById(answer_id);
        //该回答所对应的用户编号
        Integer user_id = answer.getAnswer_user_id();
        return userDao.findUserById(user_id);
    }

    /**
     * 查询该回答下的所有一级评论(输入回答编号，一级评论指对回答的评论）
     * @param answer_id
     * @return
     */
    @Override
    public List<Comment> findAllOfFirstComment(Integer answer_id) {
        return answerDao.findAllOfFirstComment(answer_id);
    }

    /**
     * 查询该回答下的所有一级评论数(输入回答编号，一级评论指对回答的评论）
     * @param answer_id
     * @return
     */
    @Override
    public Integer findTotalOfFirstComment(Integer answer_id) {
        return answerDao.findTotalOfFirstComment(answer_id);
    }

    /**
     * 查询赞同某回答的所有用户(输入回答编号)
     * @param answer_id
     * @return
     */
    @Override
    public List<User> findAllOfFromUser(Integer answer_id) {
        return answerDao.findAllOfFromUser(answer_id);
    }

    /**
     * 查询赞同某回答的用户数(输入回答编号)
     * @param answer_id
     * @return
     */
    @Override
    public Integer findTotalOfFromUser(Integer answer_id) {
        return answerDao.findTotalOfFromUser(answer_id);
    }

    /**
     * 新增回答
     * 回答者用户编号、回答所对应的问题编号为必填项
     * @param answer
     */
    @Override
    public void saveAnswer(Answer answer) {
        answerDao.saveAnswer(answer);
    }

    /**
     * 更新回答
     * 回答编号、回答者用户编号、回答所对应的问题编号为必填项
     * @param answer
     */
    @Override
    public void updateAnswer(Answer answer) {
        answerDao.updateAnswer(answer);
    }

    /**
     * 根据回答编号删除回答
     * @param answer_id
     */
    @Override
    public void deleteAnswer(Integer answer_id) {
        answerDao.deleteAnswer(answer_id);
    }
}
