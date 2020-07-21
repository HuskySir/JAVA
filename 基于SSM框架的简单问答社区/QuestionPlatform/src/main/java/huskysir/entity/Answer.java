package huskysir.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 回答类
 */
public class Answer implements Serializable {

    private Integer answer_id;              //回答编号
    private Integer answer_user_id;         //回答的回答者用户编号（关联用户表）
    private Integer answer_question_id;     //回答所对应的问题编号（关联问题表）
    private String answer_content;          //回答内容
    private Integer answer_view_count;      //回答浏览量
    private Integer answer_agree_count;     //回答赞同量
    private Date answer_update_time;        //回答更新时间
    private Date answer_create_time;        //回答创建时间
    private Integer answer_status;          //回答状态

    public Integer getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(Integer answer_id) {
        this.answer_id = answer_id;
    }

    public Integer getAnswer_user_id() {
        return answer_user_id;
    }

    public void setAnswer_user_id(Integer answer_user_id) {
        this.answer_user_id = answer_user_id;
    }

    public Integer getAnswer_question_id() {
        return answer_question_id;
    }

    public void setAnswer_question_id(Integer answer_question_id) {
        this.answer_question_id = answer_question_id;
    }

    public String getAnswer_content() {
        return answer_content;
    }

    public void setAnswer_content(String answer_content) {
        this.answer_content = answer_content;
    }

    public Integer getAnswer_view_count() {
        return answer_view_count;
    }

    public void setAnswer_view_count(Integer answer_view_count) {
        this.answer_view_count = answer_view_count;
    }

    public Integer getAnswer_agree_count() {
        return answer_agree_count;
    }

    public void setAnswer_agree_count(Integer answer_agree_count) {
        this.answer_agree_count = answer_agree_count;
    }

    public Date getAnswer_update_time() {
        return answer_update_time;
    }

    public void setAnswer_update_time(Date answer_update_time) {
        this.answer_update_time = answer_update_time;
    }

    public Date getAnswer_create_time() {
        return answer_create_time;
    }

    public void setAnswer_create_time(Date answer_create_time) {
        this.answer_create_time = answer_create_time;
    }

    public Integer getAnswer_status() {
        return answer_status;
    }

    public void setAnswer_status(Integer answer_status) {
        this.answer_status = answer_status;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answer_id=" + answer_id +
                ", answer_user_id=" + answer_user_id +
                ", answer_question_id=" + answer_question_id +
                ", answer_content='" + answer_content + '\'' +
                ", answer_view_count=" + answer_view_count +
                ", answer_agree_count=" + answer_agree_count +
                ", answer_update_time=" + answer_update_time +
                ", answer_create_time=" + answer_create_time +
                ", answer_status=" + answer_status +
                '}';
    }
}
