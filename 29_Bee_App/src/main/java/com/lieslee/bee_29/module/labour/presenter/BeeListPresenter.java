package com.lieslee.bee_29.module.labour.presenter;

import com.common.base.presenter.BasePresenterImpl;
import com.common.callback.RequestCallback;
import com.lieslee.bee_29.bean.labour.BeeListResponse;
import com.lieslee.bee_29.common.Constant;
import com.lieslee.bee_29.http.HttpUtil;
import com.lieslee.bee_29.http.protocol.HomeProtocol;
import com.lieslee.bee_29.module.labour.view.BeeListView;

/**
 * Created by LiesLee on 17/6/28.
 */

public class BeeListPresenter extends BasePresenterImpl<BeeListView> {

    public BeeListPresenter(BeeListView view) {
        super(view);
    }

    public void getBeeList(int page){
        HttpUtil.requestDefault(HomeProtocol.projectPage(page), mView, new RequestCallback<BeeListResponse>() {
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
            public void requestSuccess(BeeListResponse data) {
                mView.getBeeListSuccessed(data);
            }
        });
    }
}
