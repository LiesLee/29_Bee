package com.lieslee.bee_29.bean.home;

import com.lieslee.bee_29.bean.labour.Bee;

import java.util.List;

/**
 * Created by LiesLee on 17/6/29.
 */

public class OrderListResponse {

    /**
     * page : 1
     * count : 10
     * lists : [{"order_id":"130","order_no":"V20170612170500810742","order_amount":"220.00","order_promote":"220.00","buy_num":"2","add_time":"1497258300","order_time":"2017-06-12 17:05:00","refund_time":"","pay_type":"0","pay_status":"1","pay_amount":"0.00","pay_time":"2017-06-12 17:05:01","income_num":"0","income_cycle":"6","income_percent":"10.00","income_expiretime":"1499850301","order_status":9,"order_status_title":"己结算","project_info":{"project_id":"1","title":"劳务人数10人,按月分红","type_title":"按月分红","simple_title":"第第第第第一期期期期期","project_image":"","price":"110.00","sales_num":"11","sales_total":"99","buy_min":"1","buy_max":"99","income_cycle":"6","income_percent":"10.00","start_time":"1496803293","end_time":"1514739661"}},{"order_id":"129","order_no":"V20170612170427157165","order_amount":"220.00","order_promote":"220.00","buy_num":"2","add_time":"1497258267","order_time":"2017-06-12 17:04:27","refund_time":"","pay_type":"0","pay_status":"1","pay_amount":"0.00","pay_time":"2017-06-12 17:04:27","income_num":"0","income_cycle":"6","income_percent":"10.00","income_expiretime":"1499850267","order_status":9,"order_status_title":"己结算","project_info":{"project_id":"1","title":"劳务人数10人,按月分红","type_title":"按月分红","simple_title":"第第第第第一期期期期期","project_image":"","price":"110.00","sales_num":"11","sales_total":"99","buy_min":"1","buy_max":"99","income_cycle":"6","income_percent":"10.00","start_time":"1496803293","end_time":"1514739661"}},{"order_id":"4","order_no":"O20170531175741346608","order_amount":"10.00","order_promote":"9.00","buy_num":"0","add_time":"1496224661","order_time":"2017-05-31 17:57:41","refund_time":"2017-06-04 22:53:29","pay_type":"4","pay_status":"1","pay_amount":"9.00","pay_time":"2017-06-04 15:18:04","income_num":"0","income_cycle":"6","income_percent":"0.00","income_expiretime":"1499152684","order_status":9,"order_status_title":"己结算","project_info":{"project_id":"1","title":"劳务人数10人,按月分红","type_title":"按月分红","simple_title":"第第第第第一期期期期期","project_image":"","price":"110.00","sales_num":"11","sales_total":"99","buy_min":"1","buy_max":"99","income_cycle":"6","income_percent":"10.00","start_time":"1496803293","end_time":"1514739661"}},{"order_id":"1","order_no":"O20170531175741346606","order_amount":"20.00","order_promote":"12.00","buy_num":"0","add_time":"0","order_time":"1970-01-01 08:00:00","refund_time":"2017-06-04 22:59:19","pay_type":"1","pay_status":"1","pay_amount":"12.00","pay_time":"","income_num":"0","income_cycle":"0","income_percent":"0.00","income_expiretime":"0","order_status":9,"order_status_title":"己结算","project_info":{"project_id":"1","title":"劳务人数10人,按月分红","type_title":"按月分红","simple_title":"第第第第第一期期期期期","project_image":"","price":"110.00","sales_num":"11","sales_total":"99","buy_min":"1","buy_max":"99","income_cycle":"6","income_percent":"10.00","start_time":"1496803293","end_time":"1514739661"}}]
     * total_record : 4
     * total_page : 1
     */

    private int page;
    private int count;
    private String total_record;
    private int total_page;
    private List<Order> lists;

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

    public List<Order> getLists() {
        return lists;
    }

    public void setLists(List<Order> lists) {
        this.lists = lists;
    }

    public static class Order {
        /**
         * order_id : 130
         * order_no : V20170612170500810742
         * order_amount : 220.00
         * order_promote : 220.00
         * buy_num : 2
         * add_time : 1497258300
         * order_time : 2017-06-12 17:05:00
         * refund_time :
         * pay_type : 0
         * pay_status : 1
         * pay_amount : 0.00
         * pay_time : 2017-06-12 17:05:01
         * income_num : 0
         * income_cycle : 6
         * income_percent : 10.00
         * income_expiretime : 1499850301
         * order_status : 9
         * order_status_title : 己结算
         * project_info : {"project_id":"1","title":"劳务人数10人,按月分红","type_title":"按月分红","simple_title":"第第第第第一期期期期期","project_image":"","price":"110.00","sales_num":"11","sales_total":"99","buy_min":"1","buy_max":"99","income_cycle":"6","income_percent":"10.00","start_time":"1496803293","end_time":"1514739661"}
         */

        private String order_id;
        private String order_no;
        private String order_amount;
        private String order_promote;
        private String buy_num;
        private String add_time;
        private String order_time;
        private String refund_time;
        private String pay_type;
        private String pay_status;
        private String pay_amount;
        private String pay_time;
        private String income_num;
        private String income_cycle;
        private String income_percent;
        private String income_expiretime;
        private int order_status;
        private String order_status_title;
        private Bee project_info;

        public String getOrder_id() {
            return order_id;
        }

        public void setOrder_id(String order_id) {
            this.order_id = order_id;
        }

        public String getOrder_no() {
            return order_no;
        }

        public void setOrder_no(String order_no) {
            this.order_no = order_no;
        }

        public String getOrder_amount() {
            return order_amount;
        }

        public void setOrder_amount(String order_amount) {
            this.order_amount = order_amount;
        }

        public String getOrder_promote() {
            return order_promote;
        }

        public void setOrder_promote(String order_promote) {
            this.order_promote = order_promote;
        }

        public String getBuy_num() {
            return buy_num;
        }

        public void setBuy_num(String buy_num) {
            this.buy_num = buy_num;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public String getOrder_time() {
            return order_time;
        }

        public void setOrder_time(String order_time) {
            this.order_time = order_time;
        }

        public String getRefund_time() {
            return refund_time;
        }

        public void setRefund_time(String refund_time) {
            this.refund_time = refund_time;
        }

        public String getPay_type() {
            return pay_type;
        }

        public void setPay_type(String pay_type) {
            this.pay_type = pay_type;
        }

        public String getPay_status() {
            return pay_status;
        }

        public void setPay_status(String pay_status) {
            this.pay_status = pay_status;
        }

        public String getPay_amount() {
            return pay_amount;
        }

        public void setPay_amount(String pay_amount) {
            this.pay_amount = pay_amount;
        }

        public String getPay_time() {
            return pay_time;
        }

        public void setPay_time(String pay_time) {
            this.pay_time = pay_time;
        }

        public String getIncome_num() {
            return income_num;
        }

        public void setIncome_num(String income_num) {
            this.income_num = income_num;
        }

        public String getIncome_cycle() {
            return income_cycle;
        }

        public void setIncome_cycle(String income_cycle) {
            this.income_cycle = income_cycle;
        }

        public String getIncome_percent() {
            return income_percent;
        }

        public void setIncome_percent(String income_percent) {
            this.income_percent = income_percent;
        }

        public String getIncome_expiretime() {
            return income_expiretime;
        }

        public void setIncome_expiretime(String income_expiretime) {
            this.income_expiretime = income_expiretime;
        }

        public int getOrder_status() {
            return order_status;
        }

        public void setOrder_status(int order_status) {
            this.order_status = order_status;
        }

        public String getOrder_status_title() {
            return order_status_title;
        }

        public void setOrder_status_title(String order_status_title) {
            this.order_status_title = order_status_title;
        }

        public Bee getProject_info() {
            return project_info;
        }

        public void setProject_info(Bee project_info) {
            this.project_info = project_info;
        }

        public static class ProjectInfo {
            /**
             * project_id : 1
             * title : 劳务人数10人,按月分红
             * type_title : 按月分红
             * simple_title : 第第第第第一期期期期期
             * project_image :
             * price : 110.00
             * sales_num : 11
             * sales_total : 99
             * buy_min : 1
             * buy_max : 99
             * income_cycle : 6
             * income_percent : 10.00
             * start_time : 1496803293
             * end_time : 1514739661
             */

            private String project_id;
            private String title;
            private String type_title;
            private String simple_title;
            private String project_image;
            private String price;
            private String sales_num;
            private String sales_total;
            private String buy_min;
            private String buy_max;
            private String income_cycle;
            private String income_percent;
            private String start_time;
            private String end_time;

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

            public String getType_title() {
                return type_title;
            }

            public void setType_title(String type_title) {
                this.type_title = type_title;
            }

            public String getSimple_title() {
                return simple_title;
            }

            public void setSimple_title(String simple_title) {
                this.simple_title = simple_title;
            }

            public String getProject_image() {
                return project_image;
            }

            public void setProject_image(String project_image) {
                this.project_image = project_image;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getSales_num() {
                return sales_num;
            }

            public void setSales_num(String sales_num) {
                this.sales_num = sales_num;
            }

            public String getSales_total() {
                return sales_total;
            }

            public void setSales_total(String sales_total) {
                this.sales_total = sales_total;
            }

            public String getBuy_min() {
                return buy_min;
            }

            public void setBuy_min(String buy_min) {
                this.buy_min = buy_min;
            }

            public String getBuy_max() {
                return buy_max;
            }

            public void setBuy_max(String buy_max) {
                this.buy_max = buy_max;
            }

            public String getIncome_cycle() {
                return income_cycle;
            }

            public void setIncome_cycle(String income_cycle) {
                this.income_cycle = income_cycle;
            }

            public String getIncome_percent() {
                return income_percent;
            }

            public void setIncome_percent(String income_percent) {
                this.income_percent = income_percent;
            }

            public String getStart_time() {
                return start_time;
            }

            public void setStart_time(String start_time) {
                this.start_time = start_time;
            }

            public String getEnd_time() {
                return end_time;
            }

            public void setEnd_time(String end_time) {
                this.end_time = end_time;
            }
        }
    }
}
