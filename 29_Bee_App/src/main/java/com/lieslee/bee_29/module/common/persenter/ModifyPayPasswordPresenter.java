package com.lieslee.bee_29.module.common.persenter;

import com.common.base.presenter.BasePresenterImpl;
import com.common.callback.RequestCallback;
import com.lieslee.bee_29.bean.common.SmsCodeTestResponse;
import com.lieslee.bee_29.common.Constant;
import com.lieslee.bee_29.http.HttpUtil;
import com.lieslee.bee_29.http.protocol.CommonProtocol;
import com.lieslee.bee_29.module.common.view.ForgotPasswordView;

/**
 * Created by LiesLee on 17/6/27.
 */

public class ModifyPayPasswordPresenter extends BasePresenterImpl<ForgotPasswordView>{

    public ModifyPayPasswordPresenter(ForgotPasswordView view) {
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

    public void modifyPayPassword(String sms_code,String mobile, String password){
        HttpUtil.requestDefault(CommonProtocol.forgetPayPwd(sms_code, mobile, password), mView, new RequestCallback<String>() {
            @Override
            public void beforeRequest() {
                mView.showProgress(Constant.PROGRESS_TYPE_DIALOG);
            }

            @Override
            public void requestError(int code, String msg) {
                if (mView == null) return;
                if (code == 0) {
                    mView.toast("网络失败异常,请稍后再试");
                } else {
                    mView.toast(msg);
                }
                mView.hideProgress(Constant.PROGRESS_TYPE_DIALOG);
            }

            @Override
            public void requestComplete() {
                if(mView == null) return;
                mView.hideProgress(Constant.PROGRESS_TYPE_DIALOG);
            }



            @Override
            public void requestSuccess(String data) {
                mView.modifySuccess();
            }
        });
    }




}
