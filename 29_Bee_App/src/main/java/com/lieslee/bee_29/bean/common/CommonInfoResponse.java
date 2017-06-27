package com.lieslee.bee_29.bean.common;

/**
 * Created by LiesLee on 17/6/27.
 */

public class CommonInfoResponse {


    /**
     * info_data : {"id":"5","title":"关于29蜜蜂","classify_title":"信息","views_num":10,"content":"关于29蜜蜂......","add_time":"2017-06-07 16:06:05","html":"<div><div><h4>关于29蜜蜂<\/h4><\/div><div>2017-06-07 16:06:05<span><\/span><\/div><div style=\"margin:auto; width:90%\">关于29蜜蜂......<\/div><\/div>"}
     */

    private InfoDataBean info_data;

    public InfoDataBean getInfo_data() {
        return info_data;
    }

    public void setInfo_data(InfoDataBean info_data) {
        this.info_data = info_data;
    }

    public static class InfoDataBean {
        /**
         * id : 5
         * title : 关于29蜜蜂
         * classify_title : 信息
         * views_num : 10
         * content : 关于29蜜蜂......
         * add_time : 2017-06-07 16:06:05
         * html : <div><div><h4>关于29蜜蜂</h4></div><div>2017-06-07 16:06:05<span></span></div><div style="margin:auto; width:90%">关于29蜜蜂......</div></div>
         */

        private String id;
        private String title;
        private String classify_title;
        private int views_num;
        private String content;
        private String add_time;
        private String html;

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

        public int getViews_num() {
            return views_num;
        }

        public void setViews_num(int views_num) {
            this.views_num = views_num;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public String getHtml() {
            return html;
        }

        public void setHtml(String html) {
            this.html = html;
        }
    }
}
