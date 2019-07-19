package com.klaus.base.ioPojo;

import com.wfq.demo_sb.pojo.User;

import java.util.List;

public class MainInfo {
    private String io_type;
    private Integer rtn_code;
    private String rtn_msg;
    private List<User> userList;

    public String getIo_type() {
        return io_type;
    }

    public void setIo_type(String io_type) {
        this.io_type = io_type;
    }

    public Integer getRtn_code() {
        return rtn_code;
    }

    public void setRtn_code(Integer rtn_code) {
        this.rtn_code = rtn_code;
    }

    public String getRtn_msg() {
        return rtn_msg;
    }

    public void setRtn_msg(String rtn_msg) {
        this.rtn_msg = rtn_msg;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
