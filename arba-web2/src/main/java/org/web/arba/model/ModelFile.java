package org.web.arba.model;

import java.util.Date;

public class ModelFile {
    
    private Integer file_no       ; // `file_no` INT(11) NOT NULL AUTO_INCREMENT,
    private String  file_name     ; // `file_name` VARCHAR(255) NOT NULL,
    private String  file_nametemp ; // `file_nametemp` VARCHAR(255) NOT NULL,
    private String  file_type     ; // `file_type` VARCHAR(20) NULL DEFAULT NULL,
    private Integer file_size     ; // `file_size` INT(50) NULL DEFAULT NULL,
    private String  file_path     ; // `file_path` VARCHAR(1000) NOT NULL,
    private String  user_id       ; // `user_id` VARCHAR(50) NULL DEFAULT NULL,
    private Date    file_regdate  ; // `file_regdate` DATETIME NOT NULL,
    private Integer article_no    ; // `article_no` INT(11) NULL DEFAULT NULL,
    private Integer file_use      ; // `file_use` TINYINT(1) NULL DEFAULT NULL, 

    public Integer getFile_no() {
        return file_no;
    }

    public void setFile_no(Integer file_no) {
        this.file_no = file_no;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getFile_nametemp() {
        return file_nametemp;
    }

    public void setFile_nametemp(String file_nametemp) {
        this.file_nametemp = file_nametemp;
    }

    public String getFile_type() {
        return file_type;
    }

    public void setFile_type(String file_type) {
        this.file_type = file_type;
    }

    public Integer getFile_size() {
        return file_size;
    }

    public void setFile_size(Integer file_size) {
        this.file_size = file_size;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Date getFile_regdate() {
        return file_regdate;
    }

    public void setFile_regdate(Date file_regdate) {
        this.file_regdate = file_regdate;
    }

    public Integer getArticle_no() {
        return article_no;
    }

    public void setArticle_no(Integer article_no) {
        this.article_no = article_no;
    }

    public Integer getFile_use() {
        return file_use;
    }

    public void setFile_use(Integer file_use) {
        this.file_use = file_use;
    }

    public ModelFile() {
        super();
    }

    public ModelFile(Integer file_no, String file_name, String file_nametemp, String file_type, Integer file_size,
            String file_path, String user_id, Date file_regdate, Integer article_no, Integer file_use) {
        super();
        this.file_no = file_no;
        this.file_name = file_name;
        this.file_nametemp = file_nametemp;
        this.file_type = file_type;
        this.file_size = file_size;
        this.file_path = file_path;
        this.user_id = user_id;
        this.file_regdate = file_regdate;
        this.article_no = article_no;
        this.file_use = file_use;
    }

    @Override
    public String toString() {
        return "ModelFile [file_no=" + file_no + ", file_name=" + file_name + ", file_nametemp=" + file_nametemp
                + ", file_type=" + file_type + ", file_size=" + file_size + ", file_path=" + file_path + ", user_id="
                + user_id + ", file_regdate=" + file_regdate + ", article_no=" + article_no + ", file_use=" + file_use
                + "]";
    }

}
