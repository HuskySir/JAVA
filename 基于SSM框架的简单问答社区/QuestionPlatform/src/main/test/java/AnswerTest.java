import huskysir.dao.AnswerDao;
import huskysir.entity.Answer;
import huskysir.entity.Comment;
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
 * 测试回答类
 */
public class AnswerTest {

    private InputStream inputStream;
    private SqlSession sqlSession;
    private AnswerDao answerDao;

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
        answerDao =sqlSession.getMapper(AnswerDao.class);
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
     * 测试根据回答编号查询回答
     */
    @Test
    public void testFindAnswerById() {

        //使用代理对象的方法
        Answer answer = answerDao.findAnswerById(6);
        System.out.println(answer);

    }

    /**
     * 测试根据用户编号查询回答
     */
    @Test
    public void testFindAnswerByUserId() {

        //使用代理对象的方法
        List<Answer> answers = answerDao.findAnswerByUserId(2);
        for (Answer answer:answers) {
            System.out.println(answer);
        }
    }

    /**
     * 测试根据问题编号查询回答
     */
    @Test
    public void testFindAnswerByQuestionId() {

        //使用代理对象的方法
        List<Answer> answers = answerDao.findAnswerByQuestionId(1);
        for (Answer answer:answers) {
            System.out.println(answer);
        }
    }

    /**
     * 查询该回答下的所有一级评论(输入回答编号，一级评论指对回答的评论）
     */
    @Test
    public void testFindAllOfFirstComment() {

        //使用代理对象的方法
        List<Comment> comments = answerDao.findAllOfFirstComment(2);
        for (Comment comment:comments) {
            System.out.println(comment);
        }
    }

    /**
     * 查询该回答下的所有一级评论数(输入回答编号，一级评论指对回答的评论）
     */
    @Test
    public void testFindTotalOfFirstComment() {

        //使用代理对象的方法
        Integer count = answerDao.findTotalOfFirstComment(2);
        System.out.println(count);

    }

    /**
     * 测试查询赞同某回答的所有用户(输入回答编号)
     */
    @Test
    public void testFindAllOfFromUser() {

        //使用代理对象的方法
        List<User> users =answerDao.findAllOfFromUser(3);
        for (User user:users) {
            System.out.println(user);
        }
    }

    /**
     * 测试查询赞同某回答的用户数（输入回答编号）
     */
    @Test
    public void testFindTotalOfFromUser() {

        Integer count = answerDao.findTotalOfFromUser(3);
        System.out.println(count);

    }

    /**
     * 测试新增回答操作
     * 回答者用户编号、回答所对应的问题编号为必填项
     */
    @Test
    public void testSaveAnswer() {
        Answer answer = new Answer();
        answer.setAnswer_user_id(1);
        answer.setAnswer_question_id(2);
        answer.setAnswer_content("我觉得不错");

        //执行新增方法
        answerDao.saveAnswer(answer);
        System.out.println(answer);
    }

    /**
     * 测试更新回答操作
     * 回答编号、回答者用户编号、回答所对应的问题编号为必填项
     */
    @Test
    public void testUpdateAnswer() {
        Answer answer = new Answer();
        answer.setAnswer_id(7);
        answer.setAnswer_user_id(1);
        answer.setAnswer_question_id(2);
        answer.setAnswer_content("我觉得可以");

        //执行更新操作
        answerDao.updateAnswer(answer);
    }

    /**
     * 测试删除回答操作
     * 输入为回答编号
     */
    @Test
    public void testDeleteAnswer() {

        //执行删除操作
        answerDao.deleteAnswer(7);
    }
}
