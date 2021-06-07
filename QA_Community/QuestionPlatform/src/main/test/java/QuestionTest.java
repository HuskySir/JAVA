import huskysir.dao.QuestionDao;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * 测试问题类
 */
public class QuestionTest {

    private InputStream inputStream;
    private SqlSession sqlSession;
    private QuestionDao questionDao;

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
        questionDao =sqlSession.getMapper(QuestionDao.class);
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
     * 测试根据问题编号查询问题
     */
    @Test
    public void testFindQuestionById() {

        //使用代理对象的方法
        Question question = questionDao.findQuestionById(4);
        Date question_create_time = question.getQuestion_create_time();
        System.out.println("类型为："+question_create_time.getClass().toString());
        System.out.println("时间为："+question_create_time);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(question_create_time.getTime());
        System.out.println(time);

    }

    /**
     * 测试查询所有问题
     */
    @Test
    public void testFindAll() {

        //使用代理对象的方法
        List<Question> questions = questionDao.findAll();
        for (Question question:questions) {
            System.out.println(question);
        }
    }

    /**
     * 测试查询总问题数
     */
    @Test
    public void testFindTotal() {

        //执行查询总问题数操作
        int count = questionDao.findTotal();
        System.out.println(count);
    }

    /**
     * 测试查询该问题下的所有回答
     */
    @Test
    public void testFindAllOfAnswer() {

        //使用代理对象的方法
        List<Answer> answers = questionDao.findAllOfAnswer(1);
        for (Answer answer:answers) {
            System.out.println(answer);
        }
    }

    /**
     * 测试查询该问题下的所有回答数
     */
    @Test
    public void testFindTotalOfAnswer() {

        //执行查询总问题数操作
        int count = questionDao.findTotalOfAnswer(1);
        System.out.println(count);
    }

    /**
     * 测试查询关注某问题的所有用户(输入用户编号)
     */
    @Test
    public void testFindAllOfFromUser() {

        //使用代理对象的方法
        List<User> users =questionDao.findAllOfFromUser(5);
        for (User user:users) {
            System.out.println(user);
        }
    }

    /**
     * 测试查询关注某用户的用户数（输入用户编号）
     */
    @Test
    public void testFindTotalOfFromUser() {

        Integer count = questionDao.findTotalOfFromUser(5);
        System.out.println(count);

    }

    /**
     * 测试根据条件查询
     * 条件：问题编号、提问者用户编号、问题标题（模糊匹配）、问题状态
     */
    @Test
    public void testFindQuestionByCondition() {

        Question question = new Question();
        question.setQuestion_user_id(4);
        question.setQuestion_title("儿");

        //执行条件查询
        List<Question> questions = questionDao.findQuestionByCondition(question);
        for (Question q:questions) {
            System.out.println(q);
        }
    }

    /**
     * 测试新增问题操作
     * 问题的提问者用户编号、问题状态为必填项
     */
    @Test
    public void testSaveQuestion() {
        Question question = new Question();
        question.setQuestion_user_id(2);
        question.setQuestion_status(1);

        //执行新增方法
        questionDao.saveQuestion(question);
        System.out.println(question);
    }

    /**
     * 测试更新问题操作
     * 问题编号、问题的提问者用户编号、问题状态为必填项
     */
    @Test
    public void testUpdateQuestion() {
        Question question = new Question();
        question.setQuestion_id(6);
        question.setQuestion_user_id(2);
        question.setQuestion_status(1);
        question.setQuestion_title("怎么办");

        //执行更新操作
        questionDao.updateQuestion(question);
    }

    /**
     * 测试删除问题操作
     * 输入为问题编号
     */
    @Test
    public void testDeleteQuestion() {

        //执行删除操作
        questionDao.deleteQuestion(6);
    }
}
