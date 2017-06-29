package com.lieslee.bee_29.bean.home;

import com.lieslee.bee_29.bean.labour.Bee;

import java.util.List;

/**
 * Created by LiesLee on 17/6/29.
 */

public class HomeResponse {

    private List<Bee> project_recommend;
    private List<BulletinRecommend> bulletin_recommend;

    public List<Bee> getProject_recommend() {
        return project_recommend;
    }

    public void setProject_recommend(List<Bee> project_recommend) {
        this.project_recommend = project_recommend;
    }

    public List<BulletinRecommend> getBulletin_recommend() {
        return bulletin_recommend;
    }

    public void setBulletin_recommend(List<BulletinRecommend> bulletin_recommend) {
        this.bulletin_recommend = bulletin_recommend;
    }


    public static class BulletinRecommend {
        /**
         * id : 112
         * title : 文章标题
         * classify_title : 公告
         * views_num : 0
         * add_time : 1970-01-01 08:00:00
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
