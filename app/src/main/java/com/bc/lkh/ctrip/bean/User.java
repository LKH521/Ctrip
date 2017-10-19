package com.bc.lkh.ctrip.bean;

/**
 * Created by 刘凯华 on 2017/8/24.
 */

public class User {

    int _id;
    String phone, password;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "_id=" + _id +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
