import huskysir.dao.UserDao;
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
 * 测试用户类
 */
public class UserTest {

    private InputStream inputStream;
    private SqlSession sqlSession;
    private UserDao userDao;

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
        userDao =sqlSession.getMapper(UserDao.class);
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
     * 测试根据用户编号查询用户（输入用户编号）
     */
    @Test
    public void testFindUserById() {

        //使用代理对象的方法
        User user =userDao.findUserById(1);
        System.out.println(user);
    }

    /**
     * 测试根据用户名查询用户（用于用户登录）
     */
    @Test
    public void testFindUserByName() {

        //使用代理对象的方法
        User user =userDao.findUserByName("yang");
            System.out.println(user);

    }

    /**
     * 测试查询所有用户
     */
    @Test
    public void testFindAll() {

        //使用代理对象的方法
        List<User> users =userDao.findAll();
        for (User user:users) {
            System.out.println(user);
        }
    }

    /**
     * 测试查询总用户数
     */
    @Test
    public void testFindTotal() {

        //执行查询总用户数操作
        int count = userDao.findTotal();
        System.out.println(count);
    }

    /**
     * 测试查询某用户提出的所有问题（传入用户编号）
     */
    @Test
    public void testFindAllOfAskQuestion() {

        //使用代理对象的方法
        List<Question> questions =userDao.findAllOfAskQuestion(1);
        for (Question question:questions) {
            System.out.println(question);
        }
    }

    /**
     * 测试查询某用户提出的问题数（传入用户编号）
     */
    @Test
    public void testFindTotalOfAskQuestion() {

        //执行查询总用户数操作
        int count = userDao.findTotalOfAskQuestion(1);
        System.out.println(count);
    }

    /**
     * 测试查询某用户做出的所有回答（传入用户编号）
     */
    @Test
    public void testFindAllOfMakeAnswer() {

        //使用代理对象的方法
        List<Answer> answers =userDao.findAllOfMakeAnswer(10);
        for (Answer answer:answers) {
            System.out.println(answer);
        }
    }

    /**
     * 测试查询某用户做出的回答数（传入用户编号）
     */
    @Test
    public void testFindTotalOfMakeAnswer() {

        //执行查询总用户数操作
        int count = userDao.findTotalOfMakeAnswer(10);
        System.out.println(count);
    }

    /**
     * 测试查询某用户做出的所有评论（传入用户编号）
     */
    @Test
    public void testFindAllOfMakeComment() {

        //使用代理对象的方法
        List<Comment> comments =userDao.findAllOfMakeComment(10);
        for (Comment comment:comments) {
            System.out.println(comment);
        }
    }

    /**
     * 测试查询某用户做出的评论数（传入用户编号）
     */
    @Test
    public void testFindTotalOfMakeComment() {

        //执行查询总用户数操作
        int count = userDao.findTotalOfMakeComment(10);
        System.out.println(count);
    }

    /**
     * 测试根据条件查询
     * 条件：用户编号、用户名、用户昵称、用户性别、用户状态
     */
    @Test
    public void testFindUserByCondition() {

        User user = new User();
        user.setUser_id(1);

        //执行条件查询
        List<User> users = userDao.findUserByCondition(user);
        for (User u:users) {
            System.out.println(u);
        }
    }

    /**
     * 测试新增用户操作
     * 用户名、用户性别、用户密码、用户状态为必填项
     */
    @Test
    public void testSaveUser() {
        User user = new User();
        user.setUser_name("wang");
        user.setUser_nickname("王重阳");
        user.setUser_sex("男");
        user.setUser_password("123456");
        user.setUser_status(1);

        //执行新增方法
        userDao.saveUser(user);
        System.out.println(user);
    }

    /**
     * 测试更新用户操作
     * 用户编号、用户名、用户性别、用户密码、用户状态为必填项
     */
    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setUser_id(10);
        user.setUser_name("wang");
        user.setUser_nickname("王重阳");
        user.setUser_sex("男");
        user.setUser_password("123");
        user.setUser_status(1);

        //执行更新操作
        userDao.updateUser(user);
    }

    /**
     * 测试删除用户操作
     * 输入为用户编号
     */
    @Test
    public void testDeleteUser() {

        //执行删除操作
        userDao.deleteUser(11);
    }
}
