package org.web.arba.model;

public class ModelVote {
    
    private Integer article_no   ; //`article_no` INT(11) NOT NULL,
    private String  user_id      ; //`user_id` VARCHAR(50) NOT NULL,
    private Integer vote_goodbad ; //`vote_goodbad` TINYINT(1) NULL DEFAULT NULL

    public Integer getArticle_no() {
        return article_no;
    }

    public void setArticle_no(Integer article_no) {
        this.article_no = article_no;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Integer getVote_goodbad() {
        return vote_goodbad;
    }

    public void setVote_goodbad(Integer vote_goodbad) {
        this.vote_goodbad = vote_goodbad;
    }

    public ModelVote() {
        super();
    }

    public ModelVote(Integer article_no, String user_id, Integer vote_goodbad) {
        super();
        this.article_no = article_no;
        this.user_id = user_id;
        this.vote_goodbad = vote_goodbad;
    }

    @Override
    public String toString() {
        return "ModelVote [article_no=" + article_no + ", user_id=" + user_id + ", vote_goodbad=" + vote_goodbad + "]";
    }

}
