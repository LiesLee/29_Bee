package com.lieslee.bee_29.bean.common;

/**
 * Created by LiesLee on 17/6/8.
 */

public class User {

    /**
     * quick_login : {"login_encode":"hfnMM3nPwPMy7tekJerCpKMEbUYnsGv25HTNigijC5mjLpQsCLGmIM92wRD+S5tDAH7vA/SrCVAD5uCQThepWzBEn7+YzFv15RT7HMTOSW8=","exp_time":1499246216}
     * user : {"user_id":"16","nick_name":"138000","user_mobile":"138****8000","user_mobile_encrypt":"oj8wWFKkhYUcTYMAhlv4dg==","is_pay_password":1,"add_time":"1496647836","province_id":"0","city_id":"0","region_id":"0"}
     */

    private QuickLogin quick_login;
    private UserInfo user;

    public QuickLogin getQuick_login() {
        return quick_login;
    }

    public void setQuick_login(QuickLogin quick_login) {
        this.quick_login = quick_login;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public static class QuickLogin {
        /**
         * login_encode : hfnMM3nPwPMy7tekJerCpKMEbUYnsGv25HTNigijC5mjLpQsCLGmIM92wRD+S5tDAH7vA/SrCVAD5uCQThepWzBEn7+YzFv15RT7HMTOSW8=
         * exp_time : 1499246216
         */

        private String login_encode;
        private int exp_time;

        public String getLogin_encode() {
            return login_encode;
        }

        public void setLogin_encode(String login_encode) {
            this.login_encode = login_encode;
        }

        public int getExp_time() {
            return exp_time;
        }

        public void setExp_time(int exp_time) {
            this.exp_time = exp_time;
        }
    }


}
