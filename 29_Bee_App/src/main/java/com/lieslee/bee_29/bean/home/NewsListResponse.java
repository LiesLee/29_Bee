package com.lieslee.bee_29.bean.home;

import java.util.List;

/**
 * Created by LiesLee on 17/6/28.
 */

public class NewsListResponse {

    /**
     * page : 1
     * count : 10
     * lists : [{"id":"4","title":"各地高考作文出炉!北京二选一:共和国我为你拍照","classify_title":"资讯","views_num":"0","add_time":"2017-06-07 16:06:05"}]
     * total_record : 1
     * total_page : 1
     */

    private int page;
    private int count;
    private String total_record;
    private int total_page;
    private List<News> lists;

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

    public List<News> getLists() {
        return lists;
    }

    public void setLists(List<News> lists) {
        this.lists = lists;
    }

    public static class News {
        /**
         * id : 4
         * title : 各地高考作文出炉!北京二选一:共和国我为你拍照
         * classify_title : 资讯
         * views_num : 0
         * add_time : 2017-06-07 16:06:05
         */

        private String id;
        private String title;
        private String classify_title;
        private String views_num;
        private String add_time;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getClassify_title() {
            return classify_title;
        }

        public void setClassify_title(String classify_title) {
            this.classify_title = classify_title;
        }

        public String getViews_num() {
            return views_num;
        }

        public void setViews_num(String views_num) {
            this.views_num = views_num;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }
    }
}
