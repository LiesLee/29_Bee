package com.lieslee.bee_29.bean.labour;

import java.util.List;

/**
 * Created by LiesLee on 17/6/28.
 */

public class BeeDetailResponse {

    /**
     * project_info : {"project_id":"1","simple_title":"第第第第第一期期期期期","title":"劳务人数10人,按月分红","project_image":"","price":"110.00","project_type":"1","type_title":"按月分红","status":2,"status_title":"己售罄","buy_min":"1","buy_max":"99","sales_num":"11","sales_total":"99","income_cycle":"6","income_percent":"10.00","start_time":"2017-06-07 10:41:33","end_time":"2018-01-01 01:01:01"}
     * order_record : {"page":1,"count":10,"lists":[{"order_id":165,"order_no":"V20170628152241538219","order_promote":"110.00","income_cycle":"6","income_percent":"10.00","buy_num":1,"add_time":"2017-06-28 15:22:41","user_info":{"user_id":"18","user_name":"13888888880","user_mobile":"13888888880","nick_name":"888880","user_level":"1","gender":"0","birthday":"0","avatar":"http://test.jsb-app.com/29mf/uploads/","province_id":"0","city_id":"0","region_id":"0","address":""},"project_info":[]},{"order_id":163,"order_no":"V20170627163359743096","order_promote":"660.00","income_cycle":"6","income_percent":"10.00","buy_num":6,"add_time":"2017-06-27 16:33:59","user_info":{"user_id":"17","user_name":"13928753569","user_mobile":"13928753569","nick_name":"753569","user_level":"1","gender":"0","birthday":"0","avatar":"http://test.jsb-app.com/29mf/uploads/","province_id":"0","city_id":"0","region_id":"0","address":""},"project_info":[]},{"order_id":130,"order_no":"V20170612170500810742","order_promote":"220.00","income_cycle":"6","income_percent":"10.00","buy_num":2,"add_time":"2017-06-12 17:05:00","user_info":{"user_id":"1","user_name":"zaka","user_mobile":"15915866778","nick_name":"aa","user_level":"1","gender":"1","birthday":"1262275200","avatar":"http://test.jsb-app.com/29mf/uploads/avatar/1.git","province_id":"1","city_id":"2","region_id":"3","address":"xxx"},"project_info":[]},{"order_id":129,"order_no":"V20170612170427157165","order_promote":"220.00","income_cycle":"6","income_percent":"10.00","buy_num":2,"add_time":"2017-06-12 17:04:27","user_info":{"user_id":"1","user_name":"zaka","user_mobile":"15915866778","nick_name":"aa","user_level":"1","gender":"1","birthday":"1262275200","avatar":"http://test.jsb-app.com/29mf/uploads/avatar/1.git","province_id":"1","city_id":"2","region_id":"3","address":"xxx"},"project_info":[]},{"order_id":4,"order_no":"O20170531175741346608","order_promote":"9.00","income_cycle":"6","income_percent":"0.00","buy_num":0,"add_time":"2017-05-31 17:57:41","user_info":{"user_id":"1","user_name":"zaka","user_mobile":"15915866778","nick_name":"aa","user_level":"1","gender":"1","birthday":"1262275200","avatar":"http://test.jsb-app.com/29mf/uploads/avatar/1.git","province_id":"1","city_id":"2","region_id":"3","address":"xxx"},"project_info":[]},{"order_id":1,"order_no":"O20170531175741346606","order_promote":"12.00","income_cycle":"0","income_percent":"0.00","buy_num":0,"add_time":"1970-01-01 08:00:00","user_info":{"user_id":"1","user_name":"zaka","user_mobile":"15915866778","nick_name":"aa","user_level":"1","gender":"1","birthday":"1262275200","avatar":"http://test.jsb-app.com/29mf/uploads/avatar/1.git","province_id":"1","city_id":"2","region_id":"3","address":"xxx"},"project_info":[]}],"total_record":"6","total_page":1}
     * order_ranking : [{"order_id":"163","user_id":"17","buy_num":192,"add_time":"2017-06-27 16:33:59","nick_name":"753569","avatar":"http://test.jsb-app.com/29mf/uploads/","floor":1}]
     */

    private ProjectInfo project_info;
    private OrderRecordBean order_record;
    private List<OrderRanking> order_ranking;

    public ProjectInfo getProject_info() {
        return project_info;
    }

    public void setProject_info(ProjectInfo project_info) {
        this.project_info = project_info;
    }

    public OrderRecordBean getOrder_record() {
        return order_record;
    }

    public void setOrder_record(OrderRecordBean order_record) {
        this.order_record = order_record;
    }

    public List<OrderRanking> getOrder_ranking() {
        return order_ranking;
    }

    public void setOrder_ranking(List<OrderRanking> order_ranking) {
        this.order_ranking = order_ranking;
    }

    public static class ProjectInfo {
        /**
         * project_id : 1
         * simple_title : 第第第第第一期期期期期
         * title : 劳务人数10人,按月分红
         * project_image :
         * price : 110.00
         * project_type : 1
         * type_title : 按月分红
         * status : 2
         * status_title : 己售罄
         * buy_min : 1
         * buy_max : 99
         * sales_num : 11
         * sales_total : 99
         * income_cycle : 6
         * income_percent : 10.00
         * start_time : 2017-06-07 10:41:33
         * end_time : 2018-01-01 01:01:01
         */

        private String project_id;
        private String simple_title;
        private String title;
        private String project_image;
        private double price;
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

        public String getSimple_title() {
            return simple_title;
        }

        public void setSimple_title(String simple_title) {
            this.simple_title = simple_title;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getProject_image() {
            return project_image;
        }

        public void setProject_image(String project_image) {
            this.project_image = project_image;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
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

    public static class OrderRecordBean {
        /**
         * page : 1
         * count : 10
         * lists : [{"order_id":165,"order_no":"V20170628152241538219","order_promote":"110.00","income_cycle":"6","income_percent":"10.00","buy_num":1,"add_time":"2017-06-28 15:22:41","user_info":{"user_id":"18","user_name":"13888888880","user_mobile":"13888888880","nick_name":"888880","user_level":"1","gender":"0","birthday":"0","avatar":"http://test.jsb-app.com/29mf/uploads/","province_id":"0","city_id":"0","region_id":"0","address":""},"project_info":[]},{"order_id":163,"order_no":"V20170627163359743096","order_promote":"660.00","income_cycle":"6","income_percent":"10.00","buy_num":6,"add_time":"2017-06-27 16:33:59","user_info":{"user_id":"17","user_name":"13928753569","user_mobile":"13928753569","nick_name":"753569","user_level":"1","gender":"0","birthday":"0","avatar":"http://test.jsb-app.com/29mf/uploads/","province_id":"0","city_id":"0","region_id":"0","address":""},"project_info":[]},{"order_id":130,"order_no":"V20170612170500810742","order_promote":"220.00","income_cycle":"6","income_percent":"10.00","buy_num":2,"add_time":"2017-06-12 17:05:00","user_info":{"user_id":"1","user_name":"zaka","user_mobile":"15915866778","nick_name":"aa","user_level":"1","gender":"1","birthday":"1262275200","avatar":"http://test.jsb-app.com/29mf/uploads/avatar/1.git","province_id":"1","city_id":"2","region_id":"3","address":"xxx"},"project_info":[]},{"order_id":129,"order_no":"V20170612170427157165","order_promote":"220.00","income_cycle":"6","income_percent":"10.00","buy_num":2,"add_time":"2017-06-12 17:04:27","user_info":{"user_id":"1","user_name":"zaka","user_mobile":"15915866778","nick_name":"aa","user_level":"1","gender":"1","birthday":"1262275200","avatar":"http://test.jsb-app.com/29mf/uploads/avatar/1.git","province_id":"1","city_id":"2","region_id":"3","address":"xxx"},"project_info":[]},{"order_id":4,"order_no":"O20170531175741346608","order_promote":"9.00","income_cycle":"6","income_percent":"0.00","buy_num":0,"add_time":"2017-05-31 17:57:41","user_info":{"user_id":"1","user_name":"zaka","user_mobile":"15915866778","nick_name":"aa","user_level":"1","gender":"1","birthday":"1262275200","avatar":"http://test.jsb-app.com/29mf/uploads/avatar/1.git","province_id":"1","city_id":"2","region_id":"3","address":"xxx"},"project_info":[]},{"order_id":1,"order_no":"O20170531175741346606","order_promote":"12.00","income_cycle":"0","income_percent":"0.00","buy_num":0,"add_time":"1970-01-01 08:00:00","user_info":{"user_id":"1","user_name":"zaka","user_mobile":"15915866778","nick_name":"aa","user_level":"1","gender":"1","birthday":"1262275200","avatar":"http://test.jsb-app.com/29mf/uploads/avatar/1.git","province_id":"1","city_id":"2","region_id":"3","address":"xxx"},"project_info":[]}]
         * total_record : 6
         * total_page : 1
         */

        private int page;
        private int count;
        private String total_record;
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

        public List<Bee> getLists() {
            return lists;
        }

        public void setLists(List<Bee> lists) {
            this.lists = lists;
        }

        public static class Bee {
            /**
             * order_id : 165
             * order_no : V20170628152241538219
             * order_promote : 110.00
             * income_cycle : 6
             * income_percent : 10.00
             * buy_num : 1
             * add_time : 2017-06-28 15:22:41
             * user_info : {"user_id":"18","user_name":"13888888880","user_mobile":"13888888880","nick_name":"888880","user_level":"1","gender":"0","birthday":"0","avatar":"http://test.jsb-app.com/29mf/uploads/","province_id":"0","city_id":"0","region_id":"0","address":""}
             * project_info : []
             */

            private int order_id;
            private String order_no;
            private String order_promote;
            private String income_cycle;
            private String income_percent;
            private int buy_num;
            private String add_time;
            private UserInfo user_info;

            public int getOrder_id() {
                return order_id;
            }

            public void setOrder_id(int order_id) {
                this.order_id = order_id;
            }

            public String getOrder_no() {
                return order_no;
            }

            public void setOrder_no(String order_no) {
                this.order_no = order_no;
            }

            public String getOrder_promote() {
                return order_promote;
            }

            public void setOrder_promote(String order_promote) {
                this.order_promote = order_promote;
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

            public int getBuy_num() {
                return buy_num;
            }

            public void setBuy_num(int buy_num) {
                this.buy_num = buy_num;
            }

            public String getAdd_time() {
                return add_time;
            }

            public void setAdd_time(String add_time) {
                this.add_time = add_time;
            }

            public UserInfo getUser_info() {
                return user_info;
            }

            public void setUser_info(UserInfo user_info) {
                this.user_info = user_info;
            }

            public static class UserInfo {
                /**
                 * user_id : 18
                 * user_name : 13888888880
                 * user_mobile : 13888888880
                 * nick_name : 888880
                 * user_level : 1
                 * gender : 0
                 * birthday : 0
                 * avatar : http://test.jsb-app.com/29mf/uploads/
                 * province_id : 0
                 * city_id : 0
                 * region_id : 0
                 * address :
                 */

                private String user_id;
                private String user_name;
                private String user_mobile;
                private String nick_name;
                private String user_level;
                private String gender;
                private String birthday;
                private String avatar;
                private String province_id;
                private String city_id;
                private String region_id;
                private String address;

                public String getUser_id() {
                    return user_id;
                }

                public void setUser_id(String user_id) {
                    this.user_id = user_id;
                }

                public String getUser_name() {
                    return user_name;
                }

                public void setUser_name(String user_name) {
                    this.user_name = user_name;
                }

                public String getUser_mobile() {
                    return user_mobile;
                }

                public void setUser_mobile(String user_mobile) {
                    this.user_mobile = user_mobile;
                }

                public String getNick_name() {
                    return nick_name;
                }

                public void setNick_name(String nick_name) {
                    this.nick_name = nick_name;
                }

                public String getUser_level() {
                    return user_level;
                }

                public void setUser_level(String user_level) {
                    this.user_level = user_level;
                }

                public String getGender() {
                    return gender;
                }

                public void setGender(String gender) {
                    this.gender = gender;
                }

                public String getBirthday() {
                    return birthday;
                }

                public void setBirthday(String birthday) {
                    this.birthday = birthday;
                }

                public String getAvatar() {
                    return avatar;
                }

                public void setAvatar(String avatar) {
                    this.avatar = avatar;
                }

                public String getProvince_id() {
                    return province_id;
                }

                public void setProvince_id(String province_id) {
                    this.province_id = province_id;
                }

                public String getCity_id() {
                    return city_id;
                }

                public void setCity_id(String city_id) {
                    this.city_id = city_id;
                }

                public String getRegion_id() {
                    return region_id;
                }

                public void setRegion_id(String region_id) {
                    this.region_id = region_id;
                }

                public String getAddress() {
                    return address;
                }

                public void setAddress(String address) {
                    this.address = address;
                }
            }
        }
    }

    public static class OrderRanking {
        /**
         * order_id : 163
         * user_id : 17
         * buy_num : 192
         * add_time : 2017-06-27 16:33:59
         * nick_name : 753569
         * avatar : http://test.jsb-app.com/29mf/uploads/
         * floor : 1
         */

        private String order_id;
        private String user_id;
        private int buy_num;
        private String add_time;
        private String nick_name;
        private String avatar;
        private int floor;

        public String getOrder_id() {
            return order_id;
        }

        public void setOrder_id(String order_id) {
            this.order_id = order_id;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public int getBuy_num() {
            return buy_num;
        }

        public void setBuy_num(int buy_num) {
            this.buy_num = buy_num;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public String getNick_name() {
            return nick_name;
        }

        public void setNick_name(String nick_name) {
            this.nick_name = nick_name;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public int getFloor() {
            return floor;
        }

        public void setFloor(int floor) {
            this.floor = floor;
        }
    }
}
