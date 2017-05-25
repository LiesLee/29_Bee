package com.paysdk.payutil;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.alipay.sdk.app.PayTask;
import com.alipay.sdk.auth.AlipaySDK;
import com.paysdk.R;
import com.tencent.mm.sdk.modelpay.PayReq;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

import java.util.Map;

/**
 * Created by rrsh on 16/11/15.
 */

public class PayUtil {

    private static final int SDK_PAY_FLAG = 1;





    /**
     * 微信支付
     */
    public static void WXPay(Context context, PayReq payReq) {
        final IWXAPI msgApi = WXAPIFactory.createWXAPI(context, null);
        msgApi.registerApp(context.getString(R.string.weixin_appkey));


        msgApi.sendReq(payReq);

    }


    /**
     * 支付宝支付
     */
    public static void AliPay(final Activity activity,final Handler mHandler,String info) {

        final String orderInfo = info;   // 订单信息

        Runnable payRunnable = new Runnable() {

            @Override
            public void run() {
                PayTask alipay = new PayTask(activity);
                Map<String, String> result = alipay.payV2(orderInfo, true);
                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };
        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();


    }



}
