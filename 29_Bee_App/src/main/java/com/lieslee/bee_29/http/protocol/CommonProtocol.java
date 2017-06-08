package com.lieslee.bee_29.http.protocol;


import com.common.http.HostType;
import com.common.http.HttpResult;
import com.common.utils.MD5Util;
import com.lieslee.bee_29.bean.common.SmsCodeTestResponse;
import com.lieslee.bee_29.bean.common.User;
import com.lieslee.bee_29.http.manager.RetrofitManager;

import java.util.HashMap;
import java.util.Map;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by LiesLee on 16/10/17.
 */
public class CommonProtocol extends BaseProtocol {

    /**
     * register
     * @return
     */
    public static Observable<HttpResult<String>> register(String sms_code,String mobile, String login_password, String pay_password){
        Map<String, Object> params = new HashMap<>();
        params.put("mobile", mobile);
        params.put("sms_code", sms_code);
        params.put("login_password", MD5Util.MD5Encode(login_password, "utf-8"));
        params.put("pay_password", MD5Util.MD5Encode(pay_password, "utf-8"));
        return RetrofitManager.getInstance(HostType.USER_HOST).getCommonService()
                .commonString(createPatams(params, "register"));
    }

    /**
     * 获取验证码
     * @param mobile
     * @param sms_type 1:注册验证、2忘记密码、 修改登录密码、4修改支付密码
     * @param is_encrypt 是否为加密手机号码 0-否(默认),1-是
     * @return
     */
    public static Observable<HttpResult<SmsCodeTestResponse>> getSmsCode(String mobile, int sms_type, int is_encrypt){
        Map<String, Object> params = new HashMap<>();
        params.put("mobile", mobile);
        params.put("sms_type", sms_type);
        params.put("is_encrypt", is_encrypt);
        return RetrofitManager.getInstance(HostType.USER_HOST).getCommonService()
                .getSmsCode(createPatams(params, "getSmsCode"));
    }

    /**
     * login
     * @param mobile
     * @return
     */
    public static Observable<HttpResult<User>> login(String mobile, String password){
        Map<String, Object> params = new HashMap<>();
        params.put("mobile", mobile);
        params.put("password", MD5Util.MD5Encode(password, "utf-8"));
        return RetrofitManager.getInstance(HostType.USER_HOST).getCommonService()
                .login(createPatams(params, "login"));
    }

}
