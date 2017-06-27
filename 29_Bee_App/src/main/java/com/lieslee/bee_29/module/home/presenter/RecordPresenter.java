package com.lieslee.bee_29.module.home.presenter;

import com.common.base.presenter.BasePresenterImpl;
import com.common.callback.RequestCallback;
import com.lieslee.bee_29.bean.home.WithdrawalsRecordResponse;
import com.lieslee.bee_29.common.Constant;
import com.lieslee.bee_29.http.HttpUtil;
import com.lieslee.bee_29.http.protocol.HomeProtocol;
import com.lieslee.bee_29.module.home.view.RecordView;

/**
 * Created by LiesLee on 2017/6/27.
 * Email: LiesLee@foxmail.com
 */

public class RecordPresenter extends BasePresenterImpl<RecordView> {

    public RecordPresenter(RecordView view) {
        super(view);
    }

    public void loadRecordList(int page){
        HttpUtil.requestDefault(HomeProtocol.withdrawPage(page), mView, new RequestCallback<WithdrawalsRecordResponse>() {
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
            public void requestSuccess(WithdrawalsRecordResponse data) {
                mView.loadWithdrawalsRecordSuccessed(data);
            }
        });
    }
}
