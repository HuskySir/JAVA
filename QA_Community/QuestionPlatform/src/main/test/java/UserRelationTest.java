import huskysir.dao.UserRelationDao;
import huskysir.entity.Answer;
import huskysir.entity.Question;
import huskysir.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * 测试用户关注/赞同类
 */
public class UserRelationTest {

    private InputStream inputStream;
    private SqlSession sqlSession;
    private UserRelationDao userRelationDao;

    @Before//用于在测试方法之前执行
    public void init() throws Exception {
        //1.读取配置文件
        inputStream = Resources.getResourceAsStream("MyBatis/SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        //3.使用SqlSessionFactory工厂创建SqlSession
        sqlSession =factory.openSession();
        //4.使用SqlSession创建dao接口的代理对象
        userRelationDao =sqlSession.getMapper(UserRelationDao.class);
    }

    @After//用于在测试方法之后执行
    public void destroy() throws Exception {

        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
        inputStream.close();
    }

    /**
     * 测试查询某用户关注的所有用户(输入用户编号)
     */
    @Test
    public void testFindAllOfToUser() {

        //使用代理对象的方法
        List<User> users =userRelationDao.findAllOfToUser(2);
        for (User user:users) {
            System.out.println(user);
        }
    }

    /**
     * 测试查询某用户关注的用户数（输入用户编号）
     */
    @Test
    public void testFindTotalOfToUser() {

        Integer count = userRelationDao.findTotalOfToUser(2);
        System.out.println(count);

    }

    /**
     * 测试查询关注某用户的所有用户(输入用户编号)
     */
    @Test
    public void testFindAllOfFromUser() {

        //使用代理对象的方法
        List<User> users =userRelationDao.findAllOfFromUser(5);
        for (User user:users) {
            System.out.println(user);
        }
    }

    /**
     * 测试查询关注某用户的用户数（输入用户编号）
     */
    @Test
    public void testFindTotalOfFromUser() {

        Integer count = userRelationDao.findTotalOfFromUser(5);
        System.out.println(count);

    }

    /**
     * 测试查询某用户关注的所有问题(输入用户编号)
     */
    @Test
    public void testFindAllOfToQuestion() {

        //使用代理对象的方法
        List<Question> questions =userRelationDao.findAllOfToQuestion(2);
        for (Question question:questions) {
            System.out.println(question);
        }
    }

    /**
     * 测试查询某用户关注的问题数（输入用户编号）
     */
    @Test
    public void testFindTotalOfToQuestion() {

        Integer count = userRelationDao.findTotalOfToQuestion(2);
        System.out.println(count);

    }

    /**
     * 测试查询某用户关注的所有回答(输入用户编号)
     */
    @Test
    public void testFindAllOfToAnswer() {

        //使用代理对象的方法
        List<Answer> answers = userRelationDao.findAllOfToAnswer(3);
        for (Answer answer:answers) {
            System.out.println(answer);
        }
    }

    /**
     * 测试查询某用户赞同的回答数（输入用户编号）
     */
    @Test
    public void testFindTotalOfToAnswer() {

        Integer count = userRelationDao.findTotalOfToAnswer(3);
        System.out.println(count);

    }

    /**
     * 新增某用户关注某用户
     */
    @Test
    public void testSaveUserFollowUser() {
        Integer from_user_id = 1;
        Integer to_user_id = 2;
        userRelationDao.saveUserFollowUser(from_user_id,to_user_id);
    }

    /**
     * 删除某用户关注某用户
     */
    @Test
    public void testDeleteUserFollowUser() {
        Integer from_user_id = 1;
        Integer to_user_id = 2;
        userRelationDao.deleteUserFollowUser(from_user_id,to_user_id);
    }

    /**
     * 新增某用户关注问题
     */
    @Test
    public void testSaveUserFollowQuestion() {
        Integer from_user_id = 1;
        Integer to_question_id = 2;
        userRelationDao.saveUserFollowQuestion(from_user_id,to_question_id);
    }

    /**
     * 删除某用户关注某问题
     */
    @Test
    public void testDeleteUserFollowQuestion() {
        Integer from_user_id = 1;
        Integer to_question_id = 2;
        userRelationDao.deleteUserFollowQuestion(from_user_id,to_question_id);
    }

    /**
     * 新增某用户赞同某回答
     */
    @Test
    public void testSaveUserFollowAnswer() {
        Integer from_user_id = 1;
        Integer to_answer_id = 2;
        userRelationDao.saveUserSupportAnswer(from_user_id,to_answer_id);
    }

    /**
     * 删除某用户某回答赞同
     */
    @Test
    public void testDeleteUserFollowAnswer() {
        Integer from_user_id = 1;
        Integer to_answer_id = 2;
        userRelationDao.deleteUserSupportAnswer(from_user_id,to_answer_id);
    }

}
