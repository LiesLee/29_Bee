package com.lieslee.bee_29.http;

import com.common.http.HostType;
import com.lieslee.bee_29.BuildConfig;
import com.lieslee.bee_29.R;
import com.lieslee.bee_29.application.BeeApplication;

/**
 * Created by LiesLee on 2017/5/24.
 * Email: LiesLee@foxmail.com
 */


public class HttpConstants {

    /**
     * 返回成功
     */
    public static final int REQUEST_SUCESS = 200;
    /**
     * 登录状态失效,需要重新登录
     */
    public static final int LOGIN_STATUS_DISABLED = 202;
    /**
     * TOKEN状态失效,需要重新登录
     */
    public static final int TOKEN_STATUS_DISABLED = 201;
    /**
     * 签名认证错误
     */
    public static final int SIGNKEY_ERROR = 203;
    /**
     * 接口不存在
     */
    public static final int URL_NOT_FOUND = 204;
    public static final int LOGIN_PASSWORD_ERROR = 205;
    public static final int PAY_PASSWORD_ERROR = 206;

    public static String getHost(int hostType) {
        if (HostType.USER_HOST == hostType) {
            return getCustomerBaseUrl();
        } else {
            return "";
        }
    }


    /**
     * 域名
     * @return
     */
    public static String getCustomerBaseUrl() {
        return BuildConfig.DEBUG ?
                "http://test.jsb-app.com/29mf/api.php/" :
                "http://test.jsb-app.com/29mf/api.php/";
    }

    public static String getSignKey() {
        return BuildConfig.DEBUG
                ? BeeApplication.getInstance().getResources().getString(R.string.sign_key)
                : BeeApplication.getInstance().getResources().getString(R.string.sign_key_release);
    }

}
