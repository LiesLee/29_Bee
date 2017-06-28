package com.lieslee.bee_29.http.protocol;

import com.common.http.HostType;
import com.common.http.HttpResult;
import com.common.utils.MD5Util;
import com.lieslee.bee_29.application.BeeApplication;
import com.lieslee.bee_29.bean.common.CommonInfoResponse;
import com.lieslee.bee_29.bean.home.BankcardListResponse;
import com.lieslee.bee_29.bean.home.NewsListResponse;
import com.lieslee.bee_29.bean.home.TransactionRecordResponse;
import com.lieslee.bee_29.bean.home.WalletResponse;
import com.lieslee.bee_29.bean.home.WithdrawIndexResponse;
import com.lieslee.bee_29.bean.home.WithdrawalsRecordResponse;
import com.lieslee.bee_29.bean.labour.BeeDetailResponse;
import com.lieslee.bee_29.bean.labour.BeeListResponse;
import com.lieslee.bee_29.http.manager.RetrofitManager;

import java.util.HashMap;
import java.util.Map;

import rx.Observable;

/**
 * Created by LiesLee on 17/6/27.
 */

public class HomeProtocol extends BaseProtocol {


    /**
     * bee list
     * @return
     */
    public static Observable<HttpResult<BeeDetailResponse>> projectView(String project_id){
        Map<String, Object> params = new HashMap<>();
        params.put("user_id", BeeApplication.getInstance().getUser().getUser().getUser_id());
        params.put("project_id", project_id);
        return RetrofitManager.getInstance(HostType.USER_HOST).getHomeService()
                .projectView(createPatams(params,"projectView"));
    }

    /**
     * bee list
     * @return
     */
    public static Observable<HttpResult<BeeListResponse>> projectPage(int page){
        Map<String, Object> params = new HashMap<>();
        params.put("user_id", BeeApplication.getInstance().getUser().getUser().getUser_id());
        params.put("page", page);
        return RetrofitManager.getInstance(HostType.USER_HOST).getHomeService()
                .projectPage(createPatams(params,"projectPage"));
    }

    /**
     * question list
     * @return
     */
    public static Observable<HttpResult<NewsListResponse>> helpPage(int page){
        Map<String, Object> params = new HashMap<>();
        params.put("user_id", BeeApplication.getInstance().getUser().getUser().getUser_id());
        params.put("page", page);
        return RetrofitManager.getInstance(HostType.USER_HOST).getHomeService()
                .articlePage(createPatams(params,"helpPage"));
    }

    /**
     * news info
     * @return
     */
    public static Observable<HttpResult<CommonInfoResponse>> articleView(String id){
        Map<String, Object> params = new HashMap<>();
        params.put("user_id", BeeApplication.getInstance().getUser().getUser().getUser_id());
        params.put("id", id);
        return RetrofitManager.getInstance(HostType.USER_HOST).getCommonService()
                .infoView(createPatams(params,"articleView"));
    }

    /**
     * news info
     * @return
     */
    public static Observable<HttpResult<CommonInfoResponse>> helpView(String id){
        Map<String, Object> params = new HashMap<>();
        params.put("user_id", BeeApplication.getInstance().getUser().getUser().getUser_id());
        params.put("id", id);
        return RetrofitManager.getInstance(HostType.USER_HOST).getCommonService()
                .infoView(createPatams(params,"helpView"));
    }
    /**
     * news列表
     * @return
     */
    public static Observable<HttpResult<NewsListResponse>> articlePage(int page){
        Map<String, Object> params = new HashMap<>();
        params.put("user_id", BeeApplication.getInstance().getUser().getUser().getUser_id());
        params.put("page", page);
        return RetrofitManager.getInstance(HostType.USER_HOST).getHomeService()
                .articlePage(createPatams(params,"articlePage"));
    }

    /**
     * 银行卡列表
     * @return
     */
    public static Observable<HttpResult<BankcardListResponse>> bankcardPage(int page){
        Map<String, Object> params = new HashMap<>();
        params.put("user_id", BeeApplication.getInstance().getUser().getUser().getUser_id());
        params.put("page", page);
        return RetrofitManager.getInstance(HostType.USER_HOST).getHomeService()
                .bankcardPage(createPatams(params,"bankcardPage"));
    }


    /**
     * 删除银行卡
     * @return
     */
    public static Observable<HttpResult<String>> bankcardDelete(String bankcard_id){
        Map<String, Object> params = new HashMap<>();
        params.put("user_id", BeeApplication.getInstance().getUser().getUser().getUser_id());
        params.put("bankcard_id", bankcard_id);
        return RetrofitManager.getInstance(HostType.USER_HOST).getCommonService()
                .commonString(createPatams(params,"bankcardDelete"));
    }

    /**
     * 添加银行卡
     * @return
     */
    public static Observable<HttpResult<String>> bankcardCreate(String card_user, String card_no, String bank_id, String bank_region, String card_mobile){
        Map<String, Object> params = new HashMap<>();
        params.put("user_id", BeeApplication.getInstance().getUser().getUser().getUser_id());
        params.put("card_user", card_user);
        params.put("card_no", card_no);
        params.put("bank_id", bank_id);
        params.put("bank_region", bank_region);
        params.put("card_mobile", card_mobile);
        return RetrofitManager.getInstance(HostType.USER_HOST).getCommonService()
                .commonString(createPatams(params,"bankcardCreate"));
    }


    /**
     * 提现记录
     * @return
     */
    public static Observable<HttpResult<WithdrawalsRecordResponse>> withdrawPage(int page){
        Map<String, Object> params = new HashMap<>();
        params.put("user_id", BeeApplication.getInstance().getUser().getUser().getUser_id());
        params.put("page", page);
        return RetrofitManager.getInstance(HostType.USER_HOST).getHomeService()
                .withdrawPage(createPatams(params,"withdrawPage"));
    }

    /**
     * 交易记录
     * @return
     */
    public static Observable<HttpResult<TransactionRecordResponse>> walletPage(int page){
        Map<String, Object> params = new HashMap<>();
        params.put("user_id", BeeApplication.getInstance().getUser().getUser().getUser_id());
        params.put("page", page);
        return RetrofitManager.getInstance(HostType.USER_HOST).getHomeService()
                .walletPage(createPatams(params,"walletPage"));
    }

    /**
     * 钱包
     * @return
     */
    public static Observable<HttpResult<WalletResponse>> getWallet(){
        Map<String, Object> params = new HashMap<>();
        params.put("user_id", BeeApplication.getInstance().getUser().getUser().getUser_id());
        return RetrofitManager.getInstance(HostType.USER_HOST).getHomeService()
                .getWallet(createPatams(params,"getWallet"));
    }

    /**
     * 提现首页
     * @return
     */
    public static Observable<HttpResult<WithdrawIndexResponse>> withdrawIndex(){
        Map<String, Object> params = new HashMap<>();
        params.put("user_id", BeeApplication.getInstance().getUser().getUser().getUser_id());
        return RetrofitManager.getInstance(HostType.USER_HOST).getHomeService()
                .withdrawIndex(createPatams(params,"withdrawIndex"));
    }

    /**
     * 提现
     * @return
     */
    public static Observable<HttpResult<String>> withdrawApply(String bankcard_id, double withdraw_money, String pay_password){
        Map<String, Object> params = new HashMap<>();
        params.put("user_id", BeeApplication.getInstance().getUser().getUser().getUser_id());
        params.put("bankcard_id", bankcard_id);
        params.put("withdraw_money", withdraw_money);
        params.put("pay_password", MD5Util.MD5Encode(pay_password,"utf-8"));
        return RetrofitManager.getInstance(HostType.USER_HOST).getCommonService()
                .commonString(createPatams(params,"withdrawApply"));
    }


}
