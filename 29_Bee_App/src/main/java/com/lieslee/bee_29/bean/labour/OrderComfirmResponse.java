package com.lieslee.bee_29.bean.labour;

import java.util.List;

/**
 * Created by LiesLee on 17/6/29.
 */

public class OrderComfirmResponse {

    /**
     * project_inof : {"project_id":1,"title":"劳务人数10人,按月分红","simple_title":"第第第第第一期期期期期","price":110,"sales_num":11,"sales_total":99,"buy_min":1,"buy_max":99}
     * order_info : {"buy_price":110,"buy_num":2,"order_amount":220,"order_promote":220}
     * user_wallet : {"user_id":"1","money":"98283.00","frozen_money":"1593.00","total_money":"99999.00"}
     * pay_type : [{"pay_id":1,"pay_title":"微信支付"},{"pay_id":2,"pay_title":"支付宝支付"},{"pay_id":4,"pay_title":"余额支付"}]
     */

    private ProjectInof project_inof;
    private OrderInfo order_info;
    private UserWallet user_wallet;
    private List<PayType> pay_type;

    public ProjectInof getProject_inof() {
        return project_inof;
    }

    public void setProject_inof(ProjectInof project_inof) {
        this.project_inof = project_inof;
    }

    public OrderInfo getOrder_info() {
        return order_info;
    }

    public void setOrder_info(OrderInfo order_info) {
        this.order_info = order_info;
    }

    public UserWallet getUser_wallet() {
        return user_wallet;
    }

    public void setUser_wallet(UserWallet user_wallet) {
        this.user_wallet = user_wallet;
    }

    public List<PayType> getPay_type() {
        return pay_type;
    }

    public void setPay_type(List<PayType> pay_type) {
        this.pay_type = pay_type;
    }

    public static class ProjectInof {
        /**
         * project_id : 1
         * title : 劳务人数10人,按月分红
         * simple_title : 第第第第第一期期期期期
         * price : 110
         * sales_num : 11
         * sales_total : 99
         * buy_min : 1
         * buy_max : 99
         */

        private String project_id;
        private String title;
        private String simple_title;
        private double price;
        private int sales_num;
        private int sales_total;
        private int buy_min;
        private int buy_max;

        public String getProject_id() {
            return project_id;
        }

        public void setProject_id(String project_id) {
            this.project_id = project_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSimple_title() {
            return simple_title;
        }

        public void setSimple_title(String simple_title) {
            this.simple_title = simple_title;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getSales_num() {
            return sales_num;
        }

        public void setSales_num(int sales_num) {
            this.sales_num = sales_num;
        }

        public int getSales_total() {
            return sales_total;
        }

        public void setSales_total(int sales_total) {
            this.sales_total = sales_total;
        }

        public int getBuy_min() {
            return buy_min;
        }

        public void setBuy_min(int buy_min) {
            this.buy_min = buy_min;
        }

        public int getBuy_max() {
            return buy_max;
        }

        public void setBuy_max(int buy_max) {
            this.buy_max = buy_max;
        }
    }

    public static class OrderInfo {
        /**
         * buy_price : 110
         * buy_num : 2
         * order_amount : 220
         * order_promote : 220
         */

        private double buy_price;
        private int buy_num;
        private double order_amount;
        private double order_promote;

        public double getBuy_price() {
            return buy_price;
        }

        public void setBuy_price(double buy_price) {
            this.buy_price = buy_price;
        }

        public int getBuy_num() {
            return buy_num;
        }

        public void setBuy_num(int buy_num) {
            this.buy_num = buy_num;
        }

        public double getOrder_amount() {
            return order_amount;
        }

        public void setOrder_amount(double order_amount) {
            this.order_amount = order_amount;
        }

        public double getOrder_promote() {
            return order_promote;
        }

        public void setOrder_promote(double order_promote) {
            this.order_promote = order_promote;
        }
    }

    public static class UserWallet {
        /**
         * user_id : 1
         * money : 98283.00
         * frozen_money : 1593.00
         * total_money : 99999.00
         */

        private String user_id;
        private double money;
        private double frozen_money;
        private double total_money;

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public double getMoney() {
            return money;
        }

        public void setMoney(double money) {
            this.money = money;
        }

        public double getFrozen_money() {
            return frozen_money;
        }

        public void setFrozen_money(double frozen_money) {
            this.frozen_money = frozen_money;
        }

        public double getTotal_money() {
            return total_money;
        }

        public void setTotal_money(double total_money) {
            this.total_money = total_money;
        }
    }

    public static class PayType {
        /**
         * pay_id : 1
         * pay_title : 微信支付
         */

        private int pay_id;
        private String pay_title;

        public int getPay_id() {
            return pay_id;
        }

        public void setPay_id(int pay_id) {
            this.pay_id = pay_id;
        }

        public String getPay_title() {
            return pay_title;
        }

        public void setPay_title(String pay_title) {
            this.pay_title = pay_title;
        }
    }
}
