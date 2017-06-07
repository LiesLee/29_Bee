package com.lieslee.bee_29.module.home.presenter;


import com.common.base.presenter.BasePresenterImpl;
import com.lieslee.bee_29.common.Constant;
import com.lieslee.bee_29.http.HttpUtil;
import com.lieslee.bee_29.module.home.view.BankCardView;

/**
 * Created by LiesLee on 16/11/3.
 */
public class BankCardPresenter extends BasePresenterImpl<BankCardView> {
    public BankCardPresenter(BankCardView view) {
        super(view);
    }

    public void loadBankCardList() {

//        HttpUtil.requestDefault(MyProtocol.getBankcardList(), mView, new RequestCallback<BankCardResponse>() {
//            @Override
//            public void beforeRequest() {
//
//            }
//
//            @Override
//            public void requestError(int code, String msg) {
//                if (mView == null) return;
//                if (code == 0) {
//                    mView.toast("网络失败异常,请稍后再试");
//                } else {
//                    mView.toast(msg);
//                }
//                mView.hideProgress(Constant.PROGRESS_TYPE_LIST);
//            }
//
//            @Override
//            public void requestComplete() {
//                mView.hideProgress(Constant.PROGRESS_TYPE_LIST);
//            }
//
//            @Override
//            public void requestSuccess(BankCardResponse data) {
//                mView.loadBankCardListDone(data);
//            }
//        });

    }
}
