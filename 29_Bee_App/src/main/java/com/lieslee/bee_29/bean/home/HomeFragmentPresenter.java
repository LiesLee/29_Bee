package com.lieslee.bee_29.bean.home;

import com.common.base.presenter.BasePresenterImpl;
import com.common.callback.RequestCallback;
import com.lieslee.bee_29.common.Constant;
import com.lieslee.bee_29.http.HttpUtil;
import com.lieslee.bee_29.http.protocol.HomeProtocol;
import com.lieslee.bee_29.module.common.view.HomeView;

/**
 * Created by LiesLee on 17/6/29.
 */

public class HomeFragmentPresenter extends BasePresenterImpl<HomeView> {
    public HomeFragmentPresenter(HomeView view) {
        super(view);
    }


    public void loadHomeData(){
        HttpUtil.requestDefault(HomeProtocol.appIndex(), mView, new RequestCallback<HomeResponse>() {
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
            public void requestSuccess(HomeResponse data) {
                mView.loadHomeDataSuccessed(data);

            }
        });
    }
}
