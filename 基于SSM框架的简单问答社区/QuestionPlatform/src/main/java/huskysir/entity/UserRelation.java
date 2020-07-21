package huskysir.entity;

import java.io.Serializable;

/**
 * 用户的关系类
 * 用户关注及被关注用户数，关注问题数，赞同回答数
 * 用户提出问题数，做出回答及评论数
 */
public class UserRelation implements Serializable {

    private Integer to_user_count;      //关注的用户数
    private Integer from_user_count;    //关注该用户的用户数
    private Integer to_question_count;  //关注的问题数
    private Integer to_answer_count;    //赞同的回答数
    private Integer ask_question_count; //提出的问题数
    private Integer make_answer_count;  //做出的回答数
    private Integer make_comment_count; //做出的评论数

    public Integer getTo_user_count() {
        return to_user_count;
    }

    public void setTo_user_count(Integer to_user_count) {
        this.to_user_count = to_user_count;
    }

    public Integer getFrom_user_count() {
        return from_user_count;
    }

    public void setFrom_user_count(Integer from_user_count) {
        this.from_user_count = from_user_count;
    }

    public Integer getTo_question_count() {
        return to_question_count;
    }

    public void setTo_question_count(Integer to_question_count) {
        this.to_question_count = to_question_count;
    }

    public Integer getTo_answer_count() {
        return to_answer_count;
    }

    public void setTo_answer_count(Integer to_answer_count) {
        this.to_answer_count = to_answer_count;
    }

    public Integer getAsk_question_count() {
        return ask_question_count;
    }

    public void setAsk_question_count(Integer ask_question_count) {
        this.ask_question_count = ask_question_count;
    }

    public Integer getMake_answer_count() {
        return make_answer_count;
    }

    public void setMake_answer_count(Integer make_answer_count) {
        this.make_answer_count = make_answer_count;
    }

    public Integer getMake_comment_count() {
        return make_comment_count;
    }

    public void setMake_comment_count(Integer make_comment_count) {
        this.make_comment_count = make_comment_count;
    }
}
