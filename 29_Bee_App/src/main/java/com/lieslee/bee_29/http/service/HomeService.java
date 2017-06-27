package com.lieslee.bee_29.http.service;

import com.common.http.HttpResult;
import com.lieslee.bee_29.bean.home.WalletResponse;
import com.lieslee.bee_29.bean.home.WithdrawIndexResponse;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by LiesLee on 17/6/27.
 */

public interface HomeService {

    /**
     * 钱包
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST("api.php")
    Observable<HttpResult<WalletResponse>> getWallet(@FieldMap Map<String, Object> params);
    /**
     * 提现首页
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST("api.php")
    Observable<HttpResult<WithdrawIndexResponse>> withdrawIndex(@FieldMap Map<String, Object> params);

}
