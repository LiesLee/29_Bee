package com.lieslee.bee_29.module.home.presenter;

import com.common.base.presenter.BasePresenterImpl;
import com.common.callback.RequestCallback;
import com.lieslee.bee_29.bean.home.OrderListResponse;
import com.lieslee.bee_29.common.Constant;
import com.lieslee.bee_29.http.HttpUtil;
import com.lieslee.bee_29.http.protocol.HomeProtocol;
import com.lieslee.bee_29.module.home.view.MyBeeView;

/**
 * Created by LiesLee on 17/6/29.
 */

public class MyBeePresenter extends BasePresenterImpl<MyBeeView> {

    public MyBeePresenter(MyBeeView view) {
        super(view);
    }

    public void getOrderList(int page) {
        HttpUtil.requestDefault(HomeProtocol.orderPage(page), mView, new RequestCallback<OrderListResponse>() {
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
                mView.hideProgress(Constant.PROGRESS_TYPE_LIST);
            }

            @Override
            public void requestComplete() {
                mView.hideProgress(Constant.PROGRESS_TYPE_LIST);
            }

            @Override
            public void requestSuccess(OrderListResponse data) {
                mView.loadOrderListSuccessed(data);
            }
        });
    }

}
