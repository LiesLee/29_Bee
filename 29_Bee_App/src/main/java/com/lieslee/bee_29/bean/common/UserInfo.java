package com.lieslee.bee_29.bean.common;

/**
 * Created by LiesLee on 17/6/8.
 */

public class UserInfo {
    /**
     * user_id : 16
     * nick_name : 138000
     * user_mobile : 138****8000
     * user_mobile_encrypt : oj8wWFKkhYUcTYMAhlv4dg==
     * is_pay_password : 1
     * add_time : 1496647836
     * province_id : 0
     * city_id : 0
     * region_id : 0
     */

    private String user_id;
    private String nick_name;
    private String user_mobile;
    private String user_mobile_encrypt;
    private int is_pay_password;
    private long add_time;
    private String province_id;
    private String city_id;
    private String region_id;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getUser_mobile() {
        return user_mobile;
    }

    public void setUser_mobile(String user_mobile) {
        this.user_mobile = user_mobile;
    }

    public String getUser_mobile_encrypt() {
        return user_mobile_encrypt;
    }

    public void setUser_mobile_encrypt(String user_mobile_encrypt) {
        this.user_mobile_encrypt = user_mobile_encrypt;
    }

    public int getIs_pay_password() {
        return is_pay_password;
    }

    public void setIs_pay_password(int is_pay_password) {
        this.is_pay_password = is_pay_password;
    }

    public long getAdd_time() {
        return add_time;
    }

    public void setAdd_time(long add_time) {
        this.add_time = add_time;
    }

    public String getProvince_id() {
        return province_id;
    }

    public void setProvince_id(String province_id) {
        this.province_id = province_id;
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    public String getRegion_id() {
        return region_id;
    }

    public void setRegion_id(String region_id) {
        this.region_id = region_id;
    }
}
