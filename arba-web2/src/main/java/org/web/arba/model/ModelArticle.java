package org.web.arba.model;

import java.util.Date;

public class ModelArticle {
    
    private Integer article_no      ;//`article_no` INT(11) NOT NULL AUTO_INCREMENT,
    private Integer article_subno   ;//`article_subno` INT(11) NOT NULL,
    private String  article_title   ;//`article_title` VARCHAR(100) NOT NULL,
    private String  article_content ;//`article_content` VARCHAR(3000) NULL DEFAULT NULL,
    private Integer article_hit     ;//`article_hit` INT(11) NOT NULL,
    private Integer article_good    ;//`article_good` INT(11) NOT NULL,
    private Integer article_bad     ;//`article_bad` INT(11) NOT NULL,
    private Date    article_regdate ;//`article_regdate` DATETIME NOT NULL,
    private Date    article_update  ;//`article_update` DATETIME NULL DEFAULT NULL,
    private String  user_id         ;//`user_id` VARCHAR(50) NOT NULL,
    private String  board_id        ;//`board_id` VARCHAR(50) NOT NULL,
    private Integer article_use     ;//`article_use` TINYINT(1) NOT NULL,
    
    private Integer vote_count      ;
    private Integer comment_count   ;
    
    private String  file_userid     ;
    private Integer file_article_no ;

    public Integer getArticle_no() {
        return article_no;
    }

    public void setArticle_no(Integer article_no) {
        this.article_no = article_no;
    }

    public Integer getArticle_subno() {
        return article_subno;
    }

    public void setArticle_subno(Integer article_subno) {
        this.article_subno = article_subno;
    }

    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public String getArticle_content() {
        return article_content;
    }

    public void setArticle_content(String article_content) {
        this.article_content = article_content;
    }

    public Integer getArticle_hit() {
        return article_hit;
    }

    public void setArticle_hit(Integer article_hit) {
        this.article_hit = article_hit;
    }

    public Integer getArticle_good() {
        return article_good;
    }

    public void setArticle_good(Integer article_good) {
        this.article_good = article_good;
    }

    public Integer getArticle_bad() {
        return article_bad;
    }

    public void setArticle_bad(Integer article_bad) {
        this.article_bad = article_bad;
    }

    public Date getArticle_regdate() {
        return article_regdate;
    }

    public void setArticle_regdate(Date article_regdate) {
        this.article_regdate = article_regdate;
    }

    public Date getArticle_update() {
        return article_update;
    }

    public void setArticle_update(Date article_update) {
        this.article_update = article_update;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getBoard_id() {
        return board_id;
    }

    public void setBoard_id(String board_id) {
        this.board_id = board_id;
    }

    public Integer getArticle_use() {
        return article_use;
    }

    public void setArticle_use(Integer article_use) {
        this.article_use = article_use;
    }
    
    public String getFile_userid() {
        return file_userid;
    }

    public void setFile_userid(String file_userid) {
        this.file_userid = file_userid;
    }

    public Integer getFile_article_no() {
        return file_article_no;
    }

    public void setFile_article_no(Integer file_article_no) {
        this.file_article_no = file_article_no;
    }

    public Integer getVote_count() {
        return vote_count;
    }

    public void setVote_count(Integer vote_count) {
        this.vote_count = vote_count;
    }
    
    public Integer getComment_count() {
        return comment_count;
    }

    public void setComment_count(Integer comment_count) {
        this.comment_count = comment_count;
    }

    public ModelArticle() {
        super();
    }

    public ModelArticle(Integer article_no, Integer article_subno, String article_title, String article_content,
            Integer article_hit, Integer article_good, Integer article_bad, Date article_regdate, Date article_update,
            String user_id, String board_id, Integer article_use, Integer vote_count, Integer comment_count,
            String file_userid, Integer file_article_no) {
        super();
        this.article_no = article_no;
        this.article_subno = article_subno;
        this.article_title = article_title;
        this.article_content = article_content;
        this.article_hit = article_hit;
        this.article_good = article_good;
        this.article_bad = article_bad;
        this.article_regdate = article_regdate;
        this.article_update = article_update;
        this.user_id = user_id;
        this.board_id = board_id;
        this.article_use = article_use;
        this.vote_count = vote_count;
        this.comment_count = comment_count;
        this.file_userid = file_userid;
        this.file_article_no = file_article_no;
    }

    @Override
    public String toString() {
        return "ModelArticle [article_no=" + article_no + ", article_subno=" + article_subno + ", article_title="
                + article_title + ", article_content=" + article_content + ", article_hit=" + article_hit
                + ", article_good=" + article_good + ", article_bad=" + article_bad + ", article_regdate="
                + article_regdate + ", article_update=" + article_update + ", user_id=" + user_id + ", board_id="
                + board_id + ", article_use=" + article_use + ", vote_count=" + vote_count + ", comment_count="
                + comment_count + ", file_userid=" + file_userid + ", file_article_no=" + file_article_no + "]";
    }

}
