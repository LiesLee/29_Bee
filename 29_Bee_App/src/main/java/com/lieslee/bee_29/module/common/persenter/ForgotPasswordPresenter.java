package com.lieslee.bee_29.module.common.persenter;

import com.common.base.presenter.BasePresenterImpl;
import com.common.base.ui.BaseView;
import com.common.callback.RequestCallback;
import com.lieslee.bee_29.bean.common.SmsCodeTestResponse;
import com.lieslee.bee_29.http.HttpUtil;
import com.lieslee.bee_29.http.protocol.CommonProtocol;
import com.lieslee.bee_29.module.common.view.ForgotPasswordView;

/**
 * Created by LiesLee on 17/6/9.
 */

public class ForgotPasswordPresenter extends BasePresenterImpl<ForgotPasswordView>{

    public ForgotPasswordPresenter(ForgotPasswordView view) {
        super(view);
    }


    public void getSmsCode(String mobile, int sms_type, int is_encrypt){
        HttpUtil.requestDefault(CommonProtocol.getSmsCode(mobile, sms_type, is_encrypt), mView, new RequestCallback<SmsCodeTestResponse>() {
            @Override
            public void beforeRequest() {

            }

            @Override
            public void requestError(int code, String msg) {
                if (mView == null) return;
                if (code == 0) {
                    mView.toast("网络失败异常,请稍后再试");
                } else {
                    mView.toast(msg);
                }
                mView.getSmsCodeError();
            }

            @Override
            public void requestComplete() {

            }

            @Override
            public void requestSuccess(SmsCodeTestResponse data) {
                mView.toast("验证码发送成功");
                mView.testSmsCode(data);
            }
        });
    }

    public void modifyPassword(boolean isForgot, String sms_code,String mobile, String password){
        //HttpUtil.requestDefault(CommonProtocol.forgetLoginPwd())
    }



}
