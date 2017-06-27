package com.lieslee.bee_29.bean.home;

import java.io.Serializable;
import java.util.List;

/**
 * Created by LiesLee on 2017/6/27.
 * Email: LiesLee@foxmail.com
 */

public class BankcardListResponse implements Serializable {


    /**
     * bank_card : {"count":10,"lists":[{"add_time":"1498557194","bank_id":"1","bank_name":"招商银行","bank_region":"党建党建手机","bankcard_id":"11","card_mobile":"13888888880","card_no":"9999999999999999999","card_user":"呵呵实际上是","flag_delete":"0","update_time":"1498557194","user_id":"18"}],"page":1,"total_page":1,"total_record":"1"}
     * bank_type : [{"bank_id":"1","bank_name":"招商银行"},{"bank_id":"11","bank_name":"民生银行"},{"bank_id":"10","bank_name":"光大银行"},{"bank_id":"9","bank_name":"兴业银行"},{"bank_id":"8","bank_name":"中信银行"},{"bank_id":"7","bank_name":"交通银行"},{"bank_id":"6","bank_name":"平安银行"},{"bank_id":"5","bank_name":"中国建设银行"},{"bank_id":"4","bank_name":"中国银行"},{"bank_id":"3","bank_name":"中国农业银行"},{"bank_id":"2","bank_name":"中国工商银行"},{"bank_id":"12","bank_name":"中国邮政储蓄银行"}]
     */

    private BankCardList bank_card;
    private List<BankType> bank_type;

    public BankCardList getBank_card() {
        return bank_card;
    }

    public void setBank_card(BankCardList bank_card) {
        this.bank_card = bank_card;
    }

    public List<BankType> getBank_type() {
        return bank_type;
    }

    public void setBank_type(List<BankType> bank_type) {
        this.bank_type = bank_type;
    }

    public static class BankCardList implements Serializable {
        /**
         * count : 10
         * lists : [{"add_time":"1498557194","bank_id":"1","bank_name":"招商银行","bank_region":"党建党建手机","bankcard_id":"11","card_mobile":"13888888880","card_no":"9999999999999999999","card_user":"呵呵实际上是","flag_delete":"0","update_time":"1498557194","user_id":"18"}]
         * page : 1
         * total_page : 1
         * total_record : 1
         */

        private int count;
        private int page;
        private int total_page;
        private String total_record;
        private List<Bankcard> lists;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getTotal_page() {
            return total_page;
        }

        public void setTotal_page(int total_page) {
            this.total_page = total_page;
        }

        public String getTotal_record() {
            return total_record;
        }

        public void setTotal_record(String total_record) {
            this.total_record = total_record;
        }

        public List<Bankcard> getLists() {
            return lists;
        }

        public void setLists(List<Bankcard> lists) {
            this.lists = lists;
        }

    }

    public static class BankType implements Serializable{
        /**
         * bank_id : 1
         * bank_name : 招商银行
         */

        private String bank_id;
        private String bank_name;

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
    }
}
