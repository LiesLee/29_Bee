package com.lieslee.bee_29.bean.home;

import java.util.List;

/**
 * Created by LiesLee on 17/6/28.
 */

public class TransactionRecordResponse {

    /**
     * page : 1
     * count : 10
     * total_record : 9
     * total_page : 1
     * lists : [{"change_id":"1","pay_mode":"2","pay_money":"9.00","pay_classify":"2","add_time":"2017-06-04 15:18:04","remark":"您购买了(【第一期】劳务人数10人,按月分红)，购买数量：0，订号：O20170531175741346606","title":"购买劳务"},{"change_id":"2","pay_mode":"2","pay_money":"9.00","pay_classify":"3","add_time":"2017-06-04 15:18:04","remark":"您获得收益，单号：O20170531175741346606","title":"劳务收益"},{"change_id":"20","pay_mode":"1","pay_money":"99.00","pay_classify":"4","add_time":"2017-06-04 15:18:04","remark":"您申请退款成功，单号：O20170531175741346606","title":"劳务退款"},{"change_id":"21","pay_mode":"2","pay_money":"99.00","pay_classify":"5","add_time":"2017-06-04 15:18:04","remark":"您申请提现99.00元余额，单号：W20170606184808815968","title":"余额提现"},{"change_id":"22","pay_mode":"1","pay_money":"99.00","pay_classify":"6","add_time":"2017-06-04 15:18:04","remark":"您申请提现失败，原因：，单号：W20170606185118023657","title":"余额提现"},{"change_id":"23","pay_mode":"2","pay_money":"99.00","pay_classify":"5","add_time":"2017-06-04 15:18:04","remark":"您申请提现99.00元余额，单号：W20170606185132291386","title":"余额提现"},{"change_id":"24","pay_mode":"2","pay_money":"99.00","pay_classify":"5","add_time":"2017-06-04 15:18:04","remark":"您申请提现99.00元余额，单号：W20170606185143372887","title":"余额提现"},{"change_id":"25","pay_mode":"2","pay_money":"99.00","pay_classify":"5","add_time":"2017-06-04 15:18:04","remark":"您申请提现99.00元余额，单号：W20170606185243656742","title":"余额提现"},{"change_id":"26","pay_mode":"2","pay_money":"99.00","pay_classify":"5","add_time":"2017-06-04 15:18:04","remark":"您申请提现99.00元余额，单号：W20170606185255710550","title":"余额提现"}]
     */

    private int page;
    private int count;
    private int total_record;
    private int total_page;
    private List<TransctionRecord> lists;

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

    public int getTotal_record() {
        return total_record;
    }

    public void setTotal_record(int total_record) {
        this.total_record = total_record;
    }

    public int getTotal_page() {
        return total_page;
    }

    public void setTotal_page(int total_page) {
        this.total_page = total_page;
    }

    public List<TransctionRecord> getLists() {
        return lists;
    }

    public void setLists(List<TransctionRecord> lists) {
        this.lists = lists;
    }

    public static class TransctionRecord {
        /**
         * change_id : 1
         * pay_mode : 2
         * pay_money : 9.00
         * pay_classify : 2
         * add_time : 2017-06-04 15:18:04
         * remark : 您购买了(【第一期】劳务人数10人,按月分红)，购买数量：0，订号：O20170531175741346606
         * title : 购买劳务
         */

        private String change_id;
        private String pay_mode;
        private String pay_money;
        private String pay_classify;
        private String add_time;
        private String remark;
        private String title;

        public String getChange_id() {
            return change_id;
        }

        public void setChange_id(String change_id) {
            this.change_id = change_id;
        }

        public String getPay_mode() {
            return pay_mode;
        }

        public void setPay_mode(String pay_mode) {
            this.pay_mode = pay_mode;
        }

        public String getPay_money() {
            return pay_money;
        }

        public void setPay_money(String pay_money) {
            this.pay_money = pay_money;
        }

        public String getPay_classify() {
            return pay_classify;
        }

        public void setPay_classify(String pay_classify) {
            this.pay_classify = pay_classify;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
