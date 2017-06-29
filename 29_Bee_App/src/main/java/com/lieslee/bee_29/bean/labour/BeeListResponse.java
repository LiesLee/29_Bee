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

}
