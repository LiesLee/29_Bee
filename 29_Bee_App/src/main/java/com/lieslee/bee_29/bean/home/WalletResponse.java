package com.lieslee.bee_29.bean.home;

/**
 * Created by LiesLee on 17/6/27.
 */

public class WalletResponse {

    /**
     * user_wallet : {"user_id":"1","money":"702.00","frozen_money":"1296.00","total_money":"999.00"}
     */

    private UserWallet user_wallet;

    public UserWallet getUser_wallet() {
        return user_wallet;
    }

    public void setUser_wallet(UserWallet user_wallet) {
        this.user_wallet = user_wallet;
    }

    public static class UserWallet {
        /**
         * user_id : 1
         * money : 702.00
         * frozen_money : 1296.00
         * total_money : 999.00
         */

        private String user_id;
        private String money;
        private String frozen_money;
        private String total_money;

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getFrozen_money() {
            return frozen_money;
        }

        public void setFrozen_money(String frozen_money) {
            this.frozen_money = frozen_money;
        }

        public String getTotal_money() {
            return total_money;
        }

        public void setTotal_money(String total_money) {
            this.total_money = total_money;
        }
    }
}
