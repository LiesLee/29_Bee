package com.lieslee.bee_29.http.service;

import com.common.http.HttpResult;
import com.lieslee.bee_29.bean.common.SmsCodeTestResponse;
import com.lieslee.bee_29.bean.common.User;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by LiesLee on 16/8/23.
 */
public interface CommonService {

    /**
     * 刷新登录状态
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST("api.php")
    Observable<HttpResult<String>> commonString(@FieldMap Map<String, Object> params);

    /**
     * 刷新登录状态
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST("api.php")
    Observable<HttpResult<SmsCodeTestResponse>> getSmsCode(@FieldMap Map<String, Object> params);

    /**
     * 刷新登录状态
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST("api.php")
    Observable<HttpResult<User>> login(@FieldMap Map<String, Object> params);


}
