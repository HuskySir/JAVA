package huskysir.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * 评论类
 */
public class Comment implements Serializable {

    private Integer comment_id;         //评论编号
    private Integer comment_user_id;    //评论的评论者用户编号（关联用户表）
    private Integer comment_answer_id;  //评论所对应的回答编号（关联回答表）
    private Integer comment_last_id;    //评论上一条回复编号（关联评论表）
    private String comment_content;     //评论内容
    private Date comment_time;          //评论时间

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public Integer getComment_user_id() {
        return comment_user_id;
    }

    public void setComment_user_id(Integer comment_user_id) {
        this.comment_user_id = comment_user_id;
    }

    public Integer getComment_answer_id() {
        return comment_answer_id;
    }

    public void setComment_answer_id(Integer comment_answer_id) {
        this.comment_answer_id = comment_answer_id;
    }

    public Integer getComment_last_id() {
        return comment_last_id;
    }

    public void setComment_last_id(Integer comment_last_id) {
        this.comment_last_id = comment_last_id;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public Date getComment_time() {
        return comment_time;
    }

    public void setComment_time(Date comment_time) {
        this.comment_time = comment_time;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "comment_id=" + comment_id +
                ", comment_user_id=" + comment_user_id +
                ", comment_answer_id=" + comment_answer_id +
                ", comment_last_id=" + comment_last_id +
                ", comment_content='" + comment_content + '\'' +
                ", comment_time=" + comment_time +
                '}';
    }
}
