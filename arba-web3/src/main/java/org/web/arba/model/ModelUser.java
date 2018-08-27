package org.web.arba.model;

public class ModelUser {

    private Integer user_no     ; //`user_no` INT(11) NOT NULL AUTO_INCREMENT,
    private String  user_id     ; //`user_id` VARCHAR(50) NOT NULL,
    private String  user_passwd ; //`user_passwd` VARCHAR(50) NOT NULL,
    private String  user_email  ; //`user_email` VARCHAR(50) NULL DEFAULT NULL,
    private String  user_phone  ; //`user_phone` VARCHAR(50) NULL DEFAULT NULL,
    private Integer user_use    ; //`user_use` TINYINT(1) NULL DEFAULT NULL,

    public Integer getUser_no() {
        return user_no;
    }

    public void setUser_no(Integer user_no) {
        this.user_no = user_no;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_passwd() {
        return user_passwd;
    }

    public void setUser_passwd(String user_passwd) {
        this.user_passwd = user_passwd;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public Integer getUser_use() {
        return user_use;
    }

    public void setUser_use(Integer user_use) {
        this.user_use = user_use;
    }

    public ModelUser() {
        super();
    }

    public ModelUser(Integer user_no, String user_id, String user_passwd, String user_email, String user_phone,
            Integer user_use) {
        super();
        this.user_no = user_no;
        this.user_id = user_id;
        this.user_passwd = user_passwd;
        this.user_email = user_email;
        this.user_phone = user_phone;
        this.user_use = user_use;
    }

    @Override
    public String toString() {
        return "ModelUser [user_no=" + user_no + ", user_id=" + user_id + ", user_passwd=" + user_passwd
                + ", user_email=" + user_email + ", user_phone=" + user_phone + ", user_use=" + user_use + "]";
    }
}
