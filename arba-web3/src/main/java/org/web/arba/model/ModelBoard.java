package org.web.arba.model;


public class ModelBoard {
    
    private String no       ; // `no` INT(11) NOT NULL AUTO_INCREMENT,
    private String board_id ; // `board_id` VARCHAR(50) NOT NULL,
    private String board_nm ; // `board_nm` VARCHAR(50) NOT NULL,
    private String use_yn   ; // `use_yn` TINYINT(1) NOT NULL DEFAULT '1',

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getBoard_id() {
        return board_id;
    }

    public void setBoard_id(String board_id) {
        this.board_id = board_id;
    }

    public String getBoard_nm() {
        return board_nm;
    }

    public void setBoard_nm(String board_nm) {
        this.board_nm = board_nm;
    }

    public String getUse_yn() {
        return use_yn;
    }

    public void setUse_yn(String use_yn) {
        this.use_yn = use_yn;
    }

    public ModelBoard() {
        super();
    }

    public ModelBoard(String no, String board_id, String board_nm, String use_yn) {
        super();
        this.no = no;
        this.board_id = board_id;
        this.board_nm = board_nm;
        this.use_yn = use_yn;
    }

    @Override
    public String toString() {
        return "ModelBoard [no=" + no + ", board_id=" + board_id + ", board_nm=" + board_nm + ", use_yn=" + use_yn
                + "]";
    }
}
