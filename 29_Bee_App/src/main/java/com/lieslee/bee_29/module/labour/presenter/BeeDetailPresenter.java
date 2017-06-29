package com.lieslee.bee_29.module.labour.presenter;

import com.common.base.presenter.BasePresenterImpl;
import com.common.callback.RequestCallback;
import com.lieslee.bee_29.bean.labour.BeeDetailResponse;
import com.lieslee.bee_29.bean.labour.OrderComfirmResponse;
import com.lieslee.bee_29.bean.labour.OrderPaymentResponse;
import com.lieslee.bee_29.common.Constant;
import com.lieslee.bee_29.http.HttpUtil;
import com.lieslee.bee_29.http.protocol.HomeProtocol;
import com.lieslee.bee_29.module.labour.view.BeeDetailView;

/**
 * Created by LiesLee on 17/6/28.
 */

public class BeeDetailPresenter extends BasePresenterImpl<BeeDetailView> {

    public BeeDetailPresenter(BeeDetailView view) {
        super(view);
    }

    public void getBeeDetail(String project_id){
        HttpUtil.requestDefault(HomeProtocol.projectView(project_id), mView, new RequestCallback<BeeDetailResponse>() {
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
            public void requestSuccess(BeeDetailResponse data) {
                mView.getBeedetailSuccessed(data);
            }
        });
    }

    public void orderConfirm(String project_id, int count){
        HttpUtil.requestDefault(HomeProtocol.orderConfirm(project_id, count), mView, new RequestCallback<OrderComfirmResponse>() {
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
            public void requestSuccess(OrderComfirmResponse data) {
                mView.onOrderConfirm(data);
            }
        });
    }

    public void orderPayment(String project_id, int buy_num, int pay_type, String pay_password){
        HttpUtil.requestDefault(HomeProtocol.orderPayment(project_id, buy_num, pay_type, pay_password ), mView, new RequestCallback<OrderPaymentResponse>() {
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
            public void requestSuccess(OrderPaymentResponse data) {
                mView.onOrderPaymentSuccessed(data);
            }
        });
    }


}
