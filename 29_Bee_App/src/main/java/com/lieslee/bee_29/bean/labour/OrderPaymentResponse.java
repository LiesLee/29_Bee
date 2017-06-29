package com.lieslee.bee_29.bean.labour;

/**
 * Created by LiesLee on 17/6/29.
 */

public class OrderPaymentResponse {

    /**
     * order_info : {"order_id":"132","user_id":"1","user_mobile":"15915866778","project_id":"1","buy_num":"2","order_no":"V20170612170657151906","order_status":"0","order_amount":"220.00","order_promote":"220.00","pay_form":"0","pay_type":"0","pay_status":"0","pay_amount":"0.00","pay_time":"0","trans_no":null,"order_remark":null,"flag_refund":"0","refund_time":"0","flag_delete":"0","delete_time":"0","add_time":"1497258417","update_time":"1497258417","utm_medium":"ios","utm_source":"","income_num":"0","income_cycle":"6","income_percent":"10.00","income_expiretime":"0"}
     * weixin_data : {"partnerid":"13179541","appid":"wxb6e359051f1623","timestamp":"1497258416","noncestr":"o7rut5ld2pmav9c8pmqwcf7k7awz7gff","prepayid":"wx201706121707420cef0e9ddf0907787116","sign":"0B6824A81E512F70D62A8893B8187E13","weixinpackage":"Sign=WXPay"}
     * alipay_data : {"gateway_url":"https://openapi.alipay.com/gateway.do","app_param":"alipay_sdk=alipay-sdk-php-20160411&app_auth_token=&app_id=2015120800937361&auth_token=&biz_content=%7B%22subject%22%3A%22V%5Cu6001%5Cu8ba2%5Cu5355%22%2C%22out_trade_no%22%3A%22V20170613104820205742%22%2C%22total_amount%22%3A220%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%7D&charset=UTF-8&format=json&method=alipay.trade.app.pay&notify_url=http%3A%2F%2Fv.zm.cn%2Fnotify.php%3Fa%3Dalipaynotify&prod_code=&sign=Rmx%2FA9EAwbN7ADTA%2FCyLxhjFxz088uMt%2FwNrvckfUyyZm0dFH%2F8iX0QOMTdricTVX8OB0z9bXb4X6sefiXbwE3l%2BqfSBeUh4erFfe7NmPUEVgBsv3m5P1oelofsu95GOlZhxEOnoe6bdfgjMXDUeDo7GoQzzrrbgZWI8B0NnQgA%3D&sign_type=RSA&terminal_info=&terminal_type=&timestamp=2017-06-13+10%3A48%3A21&version=1.0"}
     */

    private OrderInfo order_info;
    private WeixinData weixin_data;
    private AlipayData alipay_data;

    public OrderInfo getOrder_info() {
        return order_info;
    }

    public void setOrder_info(OrderInfo order_info) {
        this.order_info = order_info;
    }

    public WeixinData getWeixin_data() {
        return weixin_data;
    }

    public void setWeixin_data(WeixinData weixin_data) {
        this.weixin_data = weixin_data;
    }

    public AlipayData getAlipay_data() {
        return alipay_data;
    }

    public void setAlipay_data(AlipayData alipay_data) {
        this.alipay_data = alipay_data;
    }

    public static class OrderInfo {
        /**
         * order_id : 132
         * user_id : 1
         * user_mobile : 15915866778
         * project_id : 1
         * buy_num : 2
         * order_no : V20170612170657151906
         * order_status : 0
         * order_amount : 220.00
         * order_promote : 220.00
         * pay_form : 0
         * pay_type : 0
         * pay_status : 0
         * pay_amount : 0.00
         * pay_time : 0
         * trans_no : null
         * order_remark : null
         * flag_refund : 0
         * refund_time : 0
         * flag_delete : 0
         * delete_time : 0
         * add_time : 1497258417
         * update_time : 1497258417
         * utm_medium : ios
         * utm_source :
         * income_num : 0
         * income_cycle : 6
         * income_percent : 10.00
         * income_expiretime : 0
         */

        private String order_id;
        private String user_id;
        private String user_mobile;
        private String project_id;
        private String buy_num;
        private String order_no;
        private String order_status;
        private String order_amount;
        private String order_promote;
        private String pay_form;
        private String pay_type;
        private String pay_status;
        private String pay_amount;
        private String pay_time;
        private Object trans_no;
        private Object order_remark;
        private String flag_refund;
        private String refund_time;
        private String flag_delete;
        private String delete_time;
        private String add_time;
        private String update_time;
        private String utm_medium;
        private String utm_source;
        private String income_num;
        private String income_cycle;
        private String income_percent;
        private String income_expiretime;

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

        public String getUser_mobile() {
            return user_mobile;
        }

        public void setUser_mobile(String user_mobile) {
            this.user_mobile = user_mobile;
        }

        public String getProject_id() {
            return project_id;
        }

        public void setProject_id(String project_id) {
            this.project_id = project_id;
        }

        public String getBuy_num() {
            return buy_num;
        }

        public void setBuy_num(String buy_num) {
            this.buy_num = buy_num;
        }

        public String getOrder_no() {
            return order_no;
        }

        public void setOrder_no(String order_no) {
            this.order_no = order_no;
        }

        public String getOrder_status() {
            return order_status;
        }

        public void setOrder_status(String order_status) {
            this.order_status = order_status;
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

        public String getPay_form() {
            return pay_form;
        }

        public void setPay_form(String pay_form) {
            this.pay_form = pay_form;
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

        public Object getTrans_no() {
            return trans_no;
        }

        public void setTrans_no(Object trans_no) {
            this.trans_no = trans_no;
        }

        public Object getOrder_remark() {
            return order_remark;
        }

        public void setOrder_remark(Object order_remark) {
            this.order_remark = order_remark;
        }

        public String getFlag_refund() {
            return flag_refund;
        }

        public void setFlag_refund(String flag_refund) {
            this.flag_refund = flag_refund;
        }

        public String getRefund_time() {
            return refund_time;
        }

        public void setRefund_time(String refund_time) {
            this.refund_time = refund_time;
        }

        public String getFlag_delete() {
            return flag_delete;
        }

        public void setFlag_delete(String flag_delete) {
            this.flag_delete = flag_delete;
        }

        public String getDelete_time() {
            return delete_time;
        }

        public void setDelete_time(String delete_time) {
            this.delete_time = delete_time;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public String getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(String update_time) {
            this.update_time = update_time;
        }

        public String getUtm_medium() {
            return utm_medium;
        }

        public void setUtm_medium(String utm_medium) {
            this.utm_medium = utm_medium;
        }

        public String getUtm_source() {
            return utm_source;
        }

        public void setUtm_source(String utm_source) {
            this.utm_source = utm_source;
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
    }

    public static class WeixinData {
        /**
         * partnerid : 13179541
         * appid : wxb6e359051f1623
         * timestamp : 1497258416
         * noncestr : o7rut5ld2pmav9c8pmqwcf7k7awz7gff
         * prepayid : wx201706121707420cef0e9ddf0907787116
         * sign : 0B6824A81E512F70D62A8893B8187E13
         * weixinpackage : Sign=WXPay
         */

        private String partnerid;
        private String appid;
        private String timestamp;
        private String noncestr;
        private String prepayid;
        private String sign;
        private String weixinpackage;

        public String getPartnerid() {
            return partnerid;
        }

        public void setPartnerid(String partnerid) {
            this.partnerid = partnerid;
        }

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public String getNoncestr() {
            return noncestr;
        }

        public void setNoncestr(String noncestr) {
            this.noncestr = noncestr;
        }

        public String getPrepayid() {
            return prepayid;
        }

        public void setPrepayid(String prepayid) {
            this.prepayid = prepayid;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getWeixinpackage() {
            return weixinpackage;
        }

        public void setWeixinpackage(String weixinpackage) {
            this.weixinpackage = weixinpackage;
        }
    }

    public static class AlipayData {
        /**
         * gateway_url : https://openapi.alipay.com/gateway.do
         * app_param : alipay_sdk=alipay-sdk-php-20160411&app_auth_token=&app_id=2015120800937361&auth_token=&biz_content=%7B%22subject%22%3A%22V%5Cu6001%5Cu8ba2%5Cu5355%22%2C%22out_trade_no%22%3A%22V20170613104820205742%22%2C%22total_amount%22%3A220%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%7D&charset=UTF-8&format=json&method=alipay.trade.app.pay&notify_url=http%3A%2F%2Fv.zm.cn%2Fnotify.php%3Fa%3Dalipaynotify&prod_code=&sign=Rmx%2FA9EAwbN7ADTA%2FCyLxhjFxz088uMt%2FwNrvckfUyyZm0dFH%2F8iX0QOMTdricTVX8OB0z9bXb4X6sefiXbwE3l%2BqfSBeUh4erFfe7NmPUEVgBsv3m5P1oelofsu95GOlZhxEOnoe6bdfgjMXDUeDo7GoQzzrrbgZWI8B0NnQgA%3D&sign_type=RSA&terminal_info=&terminal_type=&timestamp=2017-06-13+10%3A48%3A21&version=1.0
         */

        private String gateway_url;
        private String app_param;

        public String getGateway_url() {
            return gateway_url;
        }

        public void setGateway_url(String gateway_url) {
            this.gateway_url = gateway_url;
        }

        public String getApp_param() {
            return app_param;
        }

        public void setApp_param(String app_param) {
            this.app_param = app_param;
        }
    }
}
