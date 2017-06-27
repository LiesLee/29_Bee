package com.lieslee.bee_29.module.home.presenter;

import com.common.base.presenter.BasePresenterImpl;
import com.common.callback.RequestCallback;
import com.lieslee.bee_29.bean.home.WithdrawIndexResponse;
import com.lieslee.bee_29.common.Constant;
import com.lieslee.bee_29.http.HttpUtil;
import com.lieslee.bee_29.http.protocol.HomeProtocol;
import com.lieslee.bee_29.module.home.view.WithDrawView;

/**
 * Created by LiesLee on 17/6/27.
 */

public class WithdrawPresenter extends BasePresenterImpl<WithDrawView> {

    public WithdrawPresenter(WithDrawView view) {
        super(view);
    }

    public void getWithdrawIndex(){
        HttpUtil.requestDefault(HomeProtocol.withdrawIndex(), mView, new RequestCallback<WithdrawIndexResponse>() {
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
            public void requestSuccess(WithdrawIndexResponse data) {
                mView.getWithdrawSuccessed(data);
            }
        });
    }
    public void withdrawApply(double withdraw_money, String bankcard_id,  String pay_password){
        HttpUtil.requestDefault(HomeProtocol.withdrawApply(bankcard_id, withdraw_money, pay_password), mView, new RequestCallback<String>() {
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
                mView.withdrawSuccessed();
            }
        });
    }
}
