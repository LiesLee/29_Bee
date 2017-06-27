package com.lieslee.bee_29.module.home.presenter;

import com.common.base.presenter.BasePresenterImpl;
import com.common.base.ui.BaseView;
import com.common.callback.RequestCallback;
import com.lieslee.bee_29.common.Constant;
import com.lieslee.bee_29.http.HttpUtil;
import com.lieslee.bee_29.http.protocol.HomeProtocol;
import com.lieslee.bee_29.module.home.view.AddBankCardView;
import com.lieslee.bee_29.module.home.view.BankCardView;

/**
 * Created by LiesLee on 17/6/7.
 */

public class AddBankCardPresenter extends BasePresenterImpl<AddBankCardView> {
    public AddBankCardPresenter(AddBankCardView view) {
        super(view);
    }

    public void addCard(String card_user, String card_no, String bank_id, String bank_region, String card_mobile){
        HttpUtil.requestDefault(HomeProtocol.bankcardCreate(card_user, card_no, bank_id, bank_region, card_mobile), mView, new RequestCallback<String>() {
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
                mView.addBankCardGone();
            }
        });
    }

    public void delete(String bankcard_id){
        HttpUtil.requestDefault(HomeProtocol.bankcardDelete(bankcard_id), mView, new RequestCallback<String>() {
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
                mView.deleteBankCardGone();
            }
        });
    }


}
