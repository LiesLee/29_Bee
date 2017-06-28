package com.lieslee.bee_29.bean.labour;

import java.util.List;

/**
 * Created by LiesLee on 17/6/28.
 */

public class BeeListResponse {


    /**
     * page : 1
     * count : 10
     * total_record : 3
     * total_page : 1
     * lists : [{"project_id":"1","title":"劳务人数10人,按月分红","simple_title":"第第第第第一期期期期期","project_image":"","price":"110.00","project_type":"1","type_title":"按月分红","status":1,"status_title":"认购中","buy_min":"1","buy_max":"99","sales_num":"12","sales_total":"99","income_cycle":"6","income_percent":"10.00","start_time":"2017-06-07 10:41:33","end_time":"2018-01-01 01:01:01"},{"project_id":"2","title":"劳务人数30人,按月分红","simple_title":"第二期","project_image":"","price":"120.00","project_type":"1","type_title":"按月分红","status":1,"status_title":"认购中","buy_min":"1","buy_max":"99","sales_num":"4","sales_total":"999","income_cycle":"6","income_percent":"11.00","start_time":"2017-06-07 10:41:33","end_time":"2018-01-01 01:01:01"},{"project_id":"3","title":"劳务人数20人,按月分红","simple_title":"第三期","project_image":"","price":"130.00","project_type":"1","type_title":"按月分红","status":1,"status_title":"认购中","buy_min":"1","buy_max":"99","sales_num":"0","sales_total":"9999","income_cycle":"6","income_percent":"12.00","start_time":"2017-06-07 10:41:33","end_time":"2018-01-01 01:01:01"}]
     */

    private int page;
    private int count;
    private int total_record;
    private int total_page;
    private List<Bee> lists;

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

    public List<Bee> getLists() {
        return lists;
    }

    public void setLists(List<Bee> lists) {
        this.lists = lists;
    }

    public static class Bee {
        /**
         * project_id : 1
         * title : 劳务人数10人,按月分红
         * simple_title : 第第第第第一期期期期期
         * project_image :
         * price : 110.00
         * project_type : 1
         * type_title : 按月分红
         * status : 1
         * status_title : 认购中
         * buy_min : 1
         * buy_max : 99
         * sales_num : 12
         * sales_total : 99
         * income_cycle : 6
         * income_percent : 10.00
         * start_time : 2017-06-07 10:41:33
         * end_time : 2018-01-01 01:01:01
         */

        private String project_id;
        private String title;
        private String simple_title;
        private String project_image;
        private String price;
        private int project_type;
        private String type_title;
        private int status;
        private String status_title;
        private int buy_min;
        private int buy_max;
        private int sales_num;
        private int sales_total;
        private int income_cycle;
        private float income_percent;
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

        public int getProject_type() {
            return project_type;
        }

        public void setProject_type(int project_type) {
            this.project_type = project_type;
        }

        public String getType_title() {
            return type_title;
        }

        public void setType_title(String type_title) {
            this.type_title = type_title;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getStatus_title() {
            return status_title;
        }

        public void setStatus_title(String status_title) {
            this.status_title = status_title;
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

        public int getIncome_cycle() {
            return income_cycle;
        }

        public void setIncome_cycle(int income_cycle) {
            this.income_cycle = income_cycle;
        }

        public float getIncome_percent() {
            return income_percent;
        }

        public void setIncome_percent(float income_percent) {
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
