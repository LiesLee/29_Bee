package com.lieslee.bee_29.http.service;

import com.common.http.HttpResult;
import com.lieslee.bee_29.bean.home.BankcardListResponse;
import com.lieslee.bee_29.bean.home.HomeResponse;
import com.lieslee.bee_29.bean.home.NewsListResponse;
import com.lieslee.bee_29.bean.home.OrderListResponse;
import com.lieslee.bee_29.bean.home.TransactionRecordResponse;
import com.lieslee.bee_29.bean.home.WalletResponse;
import com.lieslee.bee_29.bean.home.WithdrawIndexResponse;
import com.lieslee.bee_29.bean.home.WithdrawalsRecordResponse;
import com.lieslee.bee_29.bean.labour.BeeDetailResponse;
import com.lieslee.bee_29.bean.labour.BeeListResponse;
import com.lieslee.bee_29.bean.labour.OrderComfirmResponse;
import com.lieslee.bee_29.bean.labour.OrderPaymentResponse;
import com.lieslee.bee_29.module.home.view.NewsListView;

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
     * 订单列表
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST("api.php")
    Observable<HttpResult<OrderListResponse>> orderPage(@FieldMap Map<String, Object> params);

    /**
     * home
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST("api.php")
    Observable<HttpResult<HomeResponse>> appIndex(@FieldMap Map<String, Object> params);
    /**
     * 订单确认
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST("api.php")
    Observable<HttpResult<OrderPaymentResponse>> orderPayment(@FieldMap Map<String, Object> params);
    /**
     * 订单确认
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST("api.php")
    Observable<HttpResult<OrderComfirmResponse>> orderConfirm(@FieldMap Map<String, Object> params);
    /**
     * bee detail
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST("api.php")
    Observable<HttpResult<BeeDetailResponse>> projectView(@FieldMap Map<String, Object> params);
    /**
     * bee列表
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST("api.php")
    Observable<HttpResult<BeeListResponse>> projectPage(@FieldMap Map<String, Object> params);
    /**
     * news列表
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST("api.php")
    Observable<HttpResult<NewsListResponse>> articlePage(@FieldMap Map<String, Object> params);
    /**
     * 银行卡列表
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST("api.php")
    Observable<HttpResult<BankcardListResponse>> bankcardPage(@FieldMap Map<String, Object> params);
    /**
     * 提现记录
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST("api.php")
    Observable<HttpResult<WithdrawalsRecordResponse>> withdrawPage(@FieldMap Map<String, Object> params);
    /**
     * 交易记录
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST("api.php")
    Observable<HttpResult<TransactionRecordResponse>> walletPage(@FieldMap Map<String, Object> params);
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
