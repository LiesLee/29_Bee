package com.lieslee.bee_29.bean.home;

import java.util.List;

/**
 * Created by LiesLee on 2017/6/27.
 * Email: LiesLee@foxmail.com
 */

public class WithdrawalsRecordResponse {


    /**
     * page : 1
     * count : 10
     * lists : [{"withdraw_id":"12","withdraw_no":"W20170606191944118219","withdraw_money":"99.00","toll_percent":"0","actual_money":"99.00","add_time":"2017-06-06 19:19:44","status":0,"handle_remark":"","complete_time":"0","card_user":"zaka","card_no":"z1234***789","card_mobile":"","bank_region":"","bank_id":""},{"withdraw_id":"11","withdraw_no":"W20170606191943233093","withdraw_money":"99.00","toll_percent":"0","actual_money":"99.00","add_time":"2017-06-06 19:19:43","status":0,"handle_remark":"","complete_time":"0","card_user":"zaka","card_no":"z1234***789","card_mobile":"","bank_region":"","bank_id":""},{"withdraw_id":"10","withdraw_no":"W20170606185529286114","withdraw_money":"99.00","toll_percent":"0","actual_money":"99.00","add_time":"2017-06-06 18:55:29","status":0,"handle_remark":"","complete_time":"0","card_user":"zaka","card_no":"z1234***789","card_mobile":"","bank_region":"","bank_id":""},{"withdraw_id":"9","withdraw_no":"W20170606185321894169","withdraw_money":"99.00","toll_percent":"0","actual_money":"99.00","add_time":"2017-06-06 18:53:21","status":0,"handle_remark":"","complete_time":"0","card_user":"zaka","card_no":"z1234***789","card_mobile":"","bank_region":"","bank_id":""},{"withdraw_id":"8","withdraw_no":"W20170606185316742330","withdraw_money":"99.00","toll_percent":"0","actual_money":"99.00","add_time":"2017-06-06 18:53:16","status":0,"handle_remark":"","complete_time":"0","card_user":"zaka","card_no":"z1234***789","card_mobile":"","bank_region":"","bank_id":""},{"withdraw_id":"7","withdraw_no":"W20170606185255710550","withdraw_money":"99.00","toll_percent":"0","actual_money":"99.00","add_time":"2017-06-06 18:52:55","status":0,"handle_remark":"","complete_time":"0","card_user":"zaka","card_no":"z1234***789","card_mobile":"","bank_region":"","bank_id":""},{"withdraw_id":"6","withdraw_no":"W20170606185243656742","withdraw_money":"99.00","toll_percent":"0","actual_money":"99.00","add_time":"2017-06-06 18:52:43","status":0,"handle_remark":"","complete_time":"0","card_user":"zaka","card_no":"z1234***789","card_mobile":"","bank_region":"","bank_id":""},{"withdraw_id":"5","withdraw_no":"W20170606185143372887","withdraw_money":"99.00","toll_percent":"0","actual_money":"99.00","add_time":"2017-06-06 18:51:43","status":0,"handle_remark":"","complete_time":"0","card_user":"zaka","card_no":"z1234***789","card_mobile":"","bank_region":"","bank_id":""},{"withdraw_id":"4","withdraw_no":"W20170606185132291386","withdraw_money":"99.00","toll_percent":"0","actual_money":"99.00","add_time":"2017-06-06 18:51:32","status":0,"handle_remark":"","complete_time":"0","card_user":"zaka","card_no":"z1234***789","card_mobile":"","bank_region":"","bank_id":""},{"withdraw_id":"3","withdraw_no":"W20170606185118023657","withdraw_money":"99.00","toll_percent":"0","actual_money":"99.00","add_time":"2017-06-06 18:51:18","status":0,"handle_remark":"","complete_time":"0","card_user":"zaka","card_no":"z1234***789","card_mobile":"","bank_region":"","bank_id":""}]
     * total_record : 12
     * total_page : 2
     */

    private int page;
    private int count;
    private String total_record;
    private int total_page;
    private List<WithdrawlsRecord> lists;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getTotal_record() {
        return total_record;
    }

    public void setTotal_record(String total_record) {
        this.total_record = total_record;
    }

    public int getTotal_page() {
        return total_page;
    }

    public void setTotal_page(int total_page) {
        this.total_page = total_page;
    }

    public List<WithdrawlsRecord> getLists() {
        return lists;
    }

    public void setLists(List<WithdrawlsRecord> lists) {
        this.lists = lists;
    }

    public static class WithdrawlsRecord {
        /**
         * withdraw_id : 12
         * withdraw_no : W20170606191944118219
         * withdraw_money : 99.00
         * toll_percent : 0
         * actual_money : 99.00
         * add_time : 2017-06-06 19:19:44
         * status : 0
         * handle_remark :
         * complete_time : 0
         * card_user : zaka
         * card_no : z1234***789
         * card_mobile :
         * bank_region :
         * bank_id :
         */

        private String withdraw_id;
        private String withdraw_no;
        private String withdraw_money;
        private String toll_percent;
        private String actual_money;
        private String add_time;
        private int status;
        private String handle_remark;
        private String complete_time;
        private String card_user;
        private String card_no;
        private String card_mobile;
        private String bank_region;
        private String bank_id;

        public String getWithdraw_id() {
            return withdraw_id;
        }

        public void setWithdraw_id(String withdraw_id) {
            this.withdraw_id = withdraw_id;
        }

        public String getWithdraw_no() {
            return withdraw_no;
        }

        public void setWithdraw_no(String withdraw_no) {
            this.withdraw_no = withdraw_no;
        }

        public String getWithdraw_money() {
            return withdraw_money;
        }

        public void setWithdraw_money(String withdraw_money) {
            this.withdraw_money = withdraw_money;
        }

        public String getToll_percent() {
            return toll_percent;
        }

        public void setToll_percent(String toll_percent) {
            this.toll_percent = toll_percent;
        }

        public String getActual_money() {
            return actual_money;
        }

        public void setActual_money(String actual_money) {
            this.actual_money = actual_money;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getHandle_remark() {
            return handle_remark;
        }

        public void setHandle_remark(String handle_remark) {
            this.handle_remark = handle_remark;
        }

        public String getComplete_time() {
            return complete_time;
        }

        public void setComplete_time(String complete_time) {
            this.complete_time = complete_time;
        }

        public String getCard_user() {
            return card_user;
        }

        public void setCard_user(String card_user) {
            this.card_user = card_user;
        }

        public String getCard_no() {
            return card_no;
        }

        public void setCard_no(String card_no) {
            this.card_no = card_no;
        }

        public String getCard_mobile() {
            return card_mobile;
        }

        public void setCard_mobile(String card_mobile) {
            this.card_mobile = card_mobile;
        }

        public String getBank_region() {
            return bank_region;
        }

        public void setBank_region(String bank_region) {
            this.bank_region = bank_region;
        }

        public String getBank_id() {
            return bank_id;
        }

        public void setBank_id(String bank_id) {
            this.bank_id = bank_id;
        }
    }
}
