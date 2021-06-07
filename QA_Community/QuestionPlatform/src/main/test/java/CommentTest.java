import huskysir.dao.CommentDao;
import huskysir.entity.Answer;
import huskysir.entity.Comment;
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
 * 测试评论类
 */
public class CommentTest {

    private InputStream inputStream;
    private SqlSession sqlSession;
    private CommentDao commentDao;

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
        commentDao =sqlSession.getMapper(CommentDao.class);
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
     * 测试根据评论编号查询评论
     */
    @Test
    public void testFindCommentById() {

        //使用代理对象的方法
        Comment comment = commentDao.findCommentById(2);
        System.out.println(comment);

    }

    /**
     * 测试根据用户编号查询评论
     */
    @Test
    public void testFindCommentByUserId() {

        //使用代理对象的方法
        List<Comment> comments = commentDao.findCommentByUserId(4);
        for (Comment comment:comments) {
            System.out.println(comment);
        }
    }

    /**
     * 测试根据回答编号查询评论
     */
    @Test
    public void testFindCommentByAnswerId() {

        //使用代理对象的方法
        List<Comment> comments = commentDao.findCommentByAnswerId(1);
        for (Comment comment:comments) {
            System.out.println(comment);
        }
    }

    /**
     * 测试查询某一评论的下级评论（输入该评论编号）
     */
    @Test
    public void textFindNextCommentByCommentId() {

        //使用代理对象的方法
        Comment comment = commentDao.findNextCommentByCommentId(2);
            System.out.println(comment);

    }

    /**
     * 测试新增评论操作
     * 评论者用户编号、评论所对应的回答编号为必填项
     */
    @Test
    public void testSaveComment() {
        Comment comment = new Comment();
        comment.setComment_user_id(1);
        comment.setComment_answer_id(2);
        comment.setComment_content("今天高考了");

        //执行新增方法
        commentDao.saveComment(comment);
        System.out.println(comment);
    }

    /**
     * 测试更新评论操作
     * 评论编号、评论者用户编号、评论所对应的回答编号为必填项
     */
    @Test
    public void testUpdateComment() {
        Comment comment = new Comment();
        comment.setComment_id(5);
        comment.setComment_user_id(1);
        comment.setComment_answer_id(2);
        comment.setComment_content("今天是晴天");

        //执行更新操作
        commentDao.updateComment(comment);
    }

    /**
     * 测试删除评论操作
     * 输入为评论编号
     */
    @Test
    public void testDeleteComment() {

        //执行删除操作
        commentDao.deleteComment(10);
    }
}
