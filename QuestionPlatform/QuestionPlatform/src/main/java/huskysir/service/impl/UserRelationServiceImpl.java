package huskysir.service.impl;

import huskysir.dao.AnswerDao;
import huskysir.dao.QuestionDao;
import huskysir.dao.UserRelationDao;
import huskysir.entity.Answer;
import huskysir.entity.Question;
import huskysir.entity.User;
import huskysir.service.UserRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务层 用户关注/赞同服务实现类
 */
@Service("userRelationService")
public class UserRelationServiceImpl implements UserRelationService {

    /**
     * 用户关系dao对象
     */
    @Autowired
    @Qualifier("userRelationDao")
    private UserRelationDao userRelationDao;

    /**
     * 问题dao对象
     */
    @Autowired
    @Qualifier("questionDao")
    private QuestionDao questionDao;

    /**
     * 回答dao对象
     */
    @Autowired
    @Qualifier("answerDao")
    private AnswerDao answerDao;

    /**
     * 查询某用户关注的所有用户(输入用户编号)
     * @param user_id
     * @return
     */
    @Override
    public List<User> findAllOfToUser(Integer user_id) {
        return userRelationDao.findAllOfToUser(user_id);
    }

    /**
     * 查询某用户关注的用户数(输入用户编号)
     * @param user_id
     * @return
     */
    @Override
    public Integer findTotalOfToUser(Integer user_id) {
        return userRelationDao.findTotalOfToUser(user_id);
    }

    /**
     * 查询关注某用户的所有用户(输入用户编号)
     * @param user_id
     * @return
     */
    @Override
    public List<User> findAllOfFromUser(Integer user_id) {
        return userRelationDao.findAllOfFromUser(user_id);
    }

    /**
     * 查询关注某用户的用户数（输入用户编号）
     * @param user_id
     * @return
     */
    @Override
    public Integer findTotalOfFromUser(Integer user_id) {
        return userRelationDao.findTotalOfFromUser(user_id);
    }

    /**
     * 查询某用户关注的所有问题(输入用户编号)
     * @param user_id
     * @return
     */
    @Override
    public List<Question> findAllOfToQuestion(Integer user_id) {
        return userRelationDao.findAllOfToQuestion(user_id);
    }

    /**
     * 查询某用户关注的问题数目(输入用户编号)
     * @param user_id
     * @return
     */
    @Override
    public Integer findTotalOfToQuestion(Integer user_id) {
        return userRelationDao.findTotalOfToQuestion(user_id);
    }

    /**
     * 查询某用户赞同的所有回答(输入用户编号)
     * @param user_id
     * @return
     */
    @Override
    public List<Answer> findAllOfToAnswer(Integer user_id) {
        return userRelationDao.findAllOfToAnswer(user_id);
    }

    /**
     * 查询某用户关注的回答数(输入用户编号)
     * @param user_id
     * @return
     */
    @Override
    public Integer findTotalOfToAnswer(Integer user_id) {
        return userRelationDao.findTotalOfToAnswer(user_id);
    }

    /**
     * 新增某用户关注某用户
     * @param from_user_id
     * @param to_user_id
     * @return
     */
    @Override
    public Boolean saveUserFollowUser(Integer from_user_id, Integer to_user_id) {
        //假设发起者用户未关注接受者用户
        Boolean follow = false;
        //查询发起者用户关注的所有用户
        List<User> users = userRelationDao.findAllOfToUser(from_user_id);
        //判断接受者用户是否被发起者用户关注
        for (int i=0;i<users.size();i++) {
            //接受者用户编号与发起者用户关注的用户编号相同
            if (to_user_id == users.get(i).getUser_id()) {
                follow = true;
            } else {
                follow = false;
            }
        }
        //发起者用户未关注接受者用户
        if (follow == false) {
            userRelationDao.saveUserFollowUser(from_user_id,to_user_id);  //发起者用户关注接受者用户
            return true;                                                  //成功新增某用户关注某用户
        }
        return false;

    }

    /**
     * 删除某用户关注某用户
     * @param from_user_id
     * @param to_user_id
     * @return
     */
    @Override
    public Boolean deleteUserFollowUser(Integer from_user_id, Integer to_user_id) {
        //假设发起者用户未关注接受者用户
        Boolean follow = false;
        //查询发起者用户关注的所有用户
        List<User> users = userRelationDao.findAllOfToUser(from_user_id);
        //判断接受者用户是否被发起者用户关注
        for (int i=0;i<users.size();i++) {
            //接受者用户编号与发起者用户关注的用户编号相同
            if (to_user_id == users.get(i).getUser_id()) {
                follow = true;
            } else {
                follow = false;
            }
        }
        //发起者用户关注了接受者用户
        if (follow == true) {
            userRelationDao.deleteUserFollowUser(from_user_id,to_user_id);  //发起者用户取消关注接受者用户
            return true;                                                    //成功删除某用户关注某用户
        }

        return false;

    }

    /**
     * 新增某用户关注某问题
     * @param from_user_id
     * @param to_question_id
     * @return
     */
    @Override
    public Boolean saveUserFollowQuestion(Integer from_user_id, Integer to_question_id) {
        //假设用户未关注问题
        Boolean follow = false;
        //查询用户关注的所有问题
        List<Question> questions = userRelationDao.findAllOfToQuestion(from_user_id);
        //判断问题是否被用户关注
        for (int i=0;i<questions.size();i++) {
            //问题编号与用户关注的问题编号相同
            if (to_question_id == questions.get(i).getQuestion_id()) {
                follow = true;
            } else {
                follow = false;
            }
        }
        //用户未关注问题
        if (follow == false) {
            userRelationDao.saveUserFollowQuestion(from_user_id,to_question_id);  //用户关注问题
            //更新问题信息：将问题信息中的关注量+1
            Question question = questionDao.findQuestionById(to_question_id);
            question.setQuestion_follow_count(question.getQuestion_follow_count()+1);
            questionDao.updateQuestion(question);
            return true;                                                          //成功新增某用户关注某问题
        }
        return false;

    }

    /**
     * 删除某用户关注某问题
     * @param from_user_id
     * @param to_question_id
     * @return
     */
    @Override
    public Boolean deleteUserFollowQuestion(Integer from_user_id, Integer to_question_id) {
        //假设用户未关注问题
        Boolean follow = false;
        //查询用户关注的所有问题
        List<Question> questions = userRelationDao.findAllOfToQuestion(from_user_id);
        //判断问题是否被用户关注
        for (int i=0;i<questions.size();i++) {
            //问题编号与用户关注的问题编号相同
            if (to_question_id == questions.get(i).getQuestion_id()) {
                follow = true;
            } else {
                follow = false;
            }
        }
        //用户关注问题
        if (follow == true) {
            userRelationDao.deleteUserFollowQuestion(from_user_id,to_question_id);  //用户取消关注问题
            //更新问题信息：将问题信息中的关注量-1
            Question question = questionDao.findQuestionById(to_question_id);
            question.setQuestion_follow_count(question.getQuestion_follow_count()-1);
            questionDao.updateQuestion(question);
            return true;                                                            //成功取消某用户关注某问题
        }
        return false;
    }

    /**
     * 新增某用户赞同某回答
     * @param from_user_id
     * @param to_answer_id
     * @return
     */
    @Override
    public Boolean saveUserSupportAnswer(Integer from_user_id, Integer to_answer_id) {
        //假设用户未赞同回答
        Boolean support = false;
        //查询用户赞同的所有回答
        List<Answer> answers = userRelationDao.findAllOfToAnswer(from_user_id);
        //判断回答是否被用户赞同
        for (int i=0;i<answers.size();i++) {
            //回答编号与用户赞同的回答编号相同
            if (to_answer_id == answers.get(i).getAnswer_id()) {
                support = true;
            } else {
                support = false;
            }
        }
        //用户未赞同回答
        if (support == false) {
            userRelationDao.saveUserSupportAnswer(from_user_id,to_answer_id);  //用户赞同回答
            //更新回答：将回答信息中的赞同量+1
            Answer answer = answerDao.findAnswerById(to_answer_id);
            answer.setAnswer_agree_count(answer.getAnswer_agree_count()+1);
            answerDao.updateAnswer(answer);
            return true;                                                       //成功新增某用户赞同某回答
        }
        return false;

    }

    /**
     * 删除某用户赞同某回答
     * @param from_user_id
     * @param to_answer_id
     * @return
     */
    @Override
    public Boolean deleteUserSupportAnswer(Integer from_user_id, Integer to_answer_id) {
        //假设用户未赞同回答
        Boolean support = false;
        //查询用户赞同的所有回答
        List<Answer> answers = userRelationDao.findAllOfToAnswer(from_user_id);
        //判断回答是否被用户赞同
        for (int i=0;i<answers.size();i++) {
            //回答编号与用户赞同的回答编号相同
            if (to_answer_id == answers.get(i).getAnswer_id()) {
                support = true;
            } else {
                support = false;
            }
        }
        //用户赞同回答
        if (support == true) {
            userRelationDao.deleteUserSupportAnswer(from_user_id,to_answer_id);  //用户取消赞同回答
            //更新回答：将回答信息中的赞同量-1
            Answer answer = answerDao.findAnswerById(to_answer_id);
            answer.setAnswer_agree_count(answer.getAnswer_agree_count()-1);
            answerDao.updateAnswer(answer);
            return true;                                                         //成功取消某用户赞同某回答
        }
        return false;
    }
}
