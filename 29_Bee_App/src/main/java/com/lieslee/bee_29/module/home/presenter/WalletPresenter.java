package com.lieslee.bee_29.module.home.presenter;

import com.common.base.presenter.BasePresenterImpl;
import com.common.callback.RequestCallback;
import com.lieslee.bee_29.bean.home.WalletResponse;
import com.lieslee.bee_29.common.Constant;
import com.lieslee.bee_29.http.HttpUtil;
import com.lieslee.bee_29.http.protocol.HomeProtocol;
import com.lieslee.bee_29.module.home.view.WalletView;

/**
 * Created by LiesLee on 17/6/27.
 */

public class WalletPresenter extends BasePresenterImpl<WalletView> {
    public WalletPresenter(WalletView view) {
        super(view);
    }

    public void getWallet(){
        HttpUtil.requestDefault(HomeProtocol.getWallet(), mView, new RequestCallback<WalletResponse>() {
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
            public void requestSuccess(WalletResponse data) {
                mView.getWalletSuccess(data);
            }
        });
    }
}
