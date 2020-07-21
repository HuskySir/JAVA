package huskysir.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * 问题类
 */
public class Question implements Serializable {

    private Integer question_id;                        //问题编号
    private Integer question_user_id;                   //问题的提问者用户编号（关联用户表）
    private String question_title;                      //问题标题
    private String question_content;                    //问题内容
    private Integer question_view_count;                //问题浏览量
    private Integer question_follow_count;              //问题关注量
    private Integer question_answer_count;              //问题回答量
    private Date question_update_time;                  //问题更新时间
    private Date question_create_time;                  //问题创建时间
    private Integer question_status;                    //问题状态

    public Integer getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Integer question_id) {
        this.question_id = question_id;
    }

    public Integer getQuestion_user_id() {
        return question_user_id;
    }

    public void setQuestion_user_id(Integer question_user_id) {
        this.question_user_id = question_user_id;
    }

    public String getQuestion_title() {
        return question_title;
    }

    public void setQuestion_title(String question_title) {
        this.question_title = question_title;
    }

    public String getQuestion_content() {
        return question_content;
    }

    public void setQuestion_content(String question_content) {
        this.question_content = question_content;
    }

    public Integer getQuestion_view_count() {
        return question_view_count;
    }

    public void setQuestion_view_count(Integer question_view_count) {
        this.question_view_count = question_view_count;
    }

    public Integer getQuestion_follow_count() {
        return question_follow_count;
    }

    public void setQuestion_follow_count(Integer question_follow_count) {
        this.question_follow_count = question_follow_count;
    }

    public Integer getQuestion_answer_count() {
        return question_answer_count;
    }

    public void setQuestion_answer_count(Integer question_answer_count) {
        this.question_answer_count = question_answer_count;
    }

    public Date getQuestion_update_time() {
        return question_update_time;
    }

    public void setQuestion_update_time(Date question_update_time) {
        this.question_update_time = question_update_time;
    }

    public Date getQuestion_create_time() {
        return question_create_time;
    }

    public void setQuestion_create_time(Date question_create_time) {
        this.question_create_time = question_create_time;
    }

    public Integer getQuestion_status() {
        return question_status;
    }

    public void setQuestion_status(Integer question_status) {
        this.question_status = question_status;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question_id=" + question_id +
                ", question_user_id=" + question_user_id +
                ", question_title='" + question_title + '\'' +
                ", question_content='" + question_content + '\'' +
                ", question_view_count=" + question_view_count +
                ", question_follow_count=" + question_follow_count +
                ", question_answer_count=" + question_answer_count +
                ", question_update_time=" + question_update_time +
                ", question_create_time=" + question_create_time +
                ", question_status=" + question_status +
                '}';
    }
}
