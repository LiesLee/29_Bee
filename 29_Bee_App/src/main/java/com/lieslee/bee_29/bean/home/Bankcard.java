package com.lieslee.bee_29.bean.home;

import java.io.Serializable;

/**
 * Created by LiesLee on 17/6/27.
 */

public class Bankcard implements Serializable{
    /**
     * add_time : 1498557194
     * bank_id : 1
     * bank_name : 招商银行
     * bank_region : 党建党建手机
     * bankcard_id : 11
     * card_mobile : 13888888880
     * card_no : 9999999999999999999
     * card_user : 呵呵实际上是
     * flag_delete : 0
     * update_time : 1498557194
     * user_id : 18
     */

    private String add_time;
    private String bank_id;
    private String bank_name;
    private String bank_region;
    private String bankcard_id;
    private String card_mobile;
    private String card_no;
    private String card_user;
    private String flag_delete;
    private String update_time;
    private String user_id;

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    public String getBank_id() {
        return bank_id;
    }

    public void setBank_id(String bank_id) {
        this.bank_id = bank_id;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getBank_region() {
        return bank_region;
    }

    public void setBank_region(String bank_region) {
        this.bank_region = bank_region;
    }

    public String getBankcard_id() {
        return bankcard_id;
    }

    public void setBankcard_id(String bankcard_id) {
        this.bankcard_id = bankcard_id;
    }

    public String getCard_mobile() {
        return card_mobile;
    }

    public void setCard_mobile(String card_mobile) {
        this.card_mobile = card_mobile;
    }

    public String getCard_no() {
        return card_no;
    }

    public void setCard_no(String card_no) {
        this.card_no = card_no;
    }

    public String getCard_user() {
        return card_user;
    }

    public void setCard_user(String card_user) {
        this.card_user = card_user;
    }

    public String getFlag_delete() {
        return flag_delete;
    }

    public void setFlag_delete(String flag_delete) {
        this.flag_delete = flag_delete;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
