package org.web.arba.model;

import java.util.Date;

public class ModelComment {
    
    private Integer comment_no      ; // comment_no` INT(11) NOT NULL AUTO_INCREMENT,
    private String comment_content ; // comment_content` VARCHAR(3000) NOT NULL,
    private Date comment_regdate    ; // comment_regdate` DATETIME NOT NULL,
    private Integer article_no      ; // article_no` INT(11) NOT NULL,
    private String user_id          ; // user_id` VARCHAR(50) NOT NULL,
    private Integer comment_use     ; // comment_use` TINYINT(1) NULL DEFAULT NULL,

    public Integer getComment_no() {
        return comment_no;
    }

    public void setComment_no(Integer comment_no) {
        this.comment_no = comment_no;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public Date getComment_regdate() {
        return comment_regdate;
    }

    public void setComment_regdate(Date comment_regdate) {
        this.comment_regdate = comment_regdate;
    }

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

    public Integer getComment_use() {
        return comment_use;
    }

    public void setComment_use(Integer comment_use) {
        this.comment_use = comment_use;
    }

    public ModelComment() {
        super();
    }

    public ModelComment(Integer comment_no, String comment_content, Date comment_regdate, Integer article_no,
            String user_id, Integer comment_use) {
        super();
        this.comment_no = comment_no;
        this.comment_content = comment_content;
        this.comment_regdate = comment_regdate;
        this.article_no = article_no;
        this.user_id = user_id;
        this.comment_use = comment_use;
    }

    @Override
    public String toString() {
        return "ModelComment [comment_no=" + comment_no + ", comment_content=" + comment_content + ", comment_regdate="
                + comment_regdate + ", article_no=" + article_no + ", user_id=" + user_id + ", comment_use="
                + comment_use + "]";
    }

}
