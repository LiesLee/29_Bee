package com.lieslee.bee_29.bean.home;

import java.util.List;

/**
 * Created by LiesLee on 17/6/27.
 */

public class WithdrawIndexResponse {


    /**
     * wallet_info : {"user_id":18,"money":99999999,"frozen_money":0,"total_money":99999999}
     * bankcard_lists : []
     * wallet_balance : [{"title":"可提现余额","explain":"全部提现","money":99999999,"flag_withdraw":1,"remark":[]},{"title":"提现未到账","explain":"结算周期","money":0,"flag_withdraw":0,"remark":["申请提现,需要等待客服处理，请知悉"]}]
     */

    private WalletInfo wallet_info;
    private List<Bankcard> bankcard_lists;
    private List<WalletBalance> wallet_balance;

    public WalletInfo getWallet_info() {
        return wallet_info;
    }

    public void setWallet_info(WalletInfo wallet_info) {
        this.wallet_info = wallet_info;
    }

    public List<Bankcard> getBankcard_lists() {
        return bankcard_lists;
    }

    public void setBankcard_lists(List<Bankcard> bankcard_lists) {
        this.bankcard_lists = bankcard_lists;
    }

    public List<WalletBalance> getWallet_balance() {
        return wallet_balance;
    }

    public void setWallet_balance(List<WalletBalance> wallet_balance) {
        this.wallet_balance = wallet_balance;
    }

    public static class WalletInfo {
        /**
         * user_id : 18
         * money : 99999999
         * frozen_money : 0
         * total_money : 99999999
         */

        private int user_id;
        private double money;
        private double frozen_money;
        private double total_money;

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
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

    public static class WalletBalance {
        /**
         * title : 可提现余额
         * explain : 全部提现
         * money : 99999999
         * flag_withdraw : 1
         * remark : []
         */

        private String title;
        private String explain;
        private double money;
        private int flag_withdraw;
        private List<String> remark;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getExplain() {
            return explain;
        }

        public void setExplain(String explain) {
            this.explain = explain;
        }

        public double getMoney() {
            return money;
        }

        public void setMoney(double money) {
            this.money = money;
        }

        public int getFlag_withdraw() {
            return flag_withdraw;
        }

        public void setFlag_withdraw(int flag_withdraw) {
            this.flag_withdraw = flag_withdraw;
        }

        public List<String> getRemark() {
            return remark;
        }

        public void setRemark(List<String> remark) {
            this.remark = remark;
        }
    }
}
