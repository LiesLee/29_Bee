package com.lieslee.bee_29.module.common.persenter;

import com.common.base.presenter.BasePresenterImpl;
import com.common.callback.RequestCallback;
import com.lieslee.bee_29.bean.common.CommonInfoResponse;
import com.lieslee.bee_29.common.Constant;
import com.lieslee.bee_29.http.HttpUtil;
import com.lieslee.bee_29.http.protocol.CommonProtocol;
import com.lieslee.bee_29.http.protocol.HomeProtocol;
import com.lieslee.bee_29.module.common.view.InfoView;

/**
 * Created by LiesLee on 17/6/27.
 */

public class InfoPresenter extends BasePresenterImpl<InfoView> {
    public InfoPresenter(InfoView view) {
        super(view);
    }

    public void getInfo(int id){
        HttpUtil.requestDefault(CommonProtocol.infoView(id), mView, new RequestCallback<CommonInfoResponse>() {
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
            public void requestSuccess(CommonInfoResponse data) {
                mView.getInfoSuccess(data);
            }
        });
    }
    public void getNewsInfo(String id){
        HttpUtil.requestDefault(HomeProtocol.articleView(id), mView, new RequestCallback<CommonInfoResponse>() {
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
            public void requestSuccess(CommonInfoResponse data) {
                mView.getInfoSuccess(data);
            }
        });
    }

    public void getHeplInfo(String id){
        HttpUtil.requestDefault(HomeProtocol.helpView(id), mView, new RequestCallback<CommonInfoResponse>() {
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
            public void requestSuccess(CommonInfoResponse data) {
                mView.getInfoSuccess(data);
            }
        });
    }
    public void getBulletinInfo(String id){
        HttpUtil.requestDefault(HomeProtocol.bulletinView(id), mView, new RequestCallback<CommonInfoResponse>() {
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
            public void requestSuccess(CommonInfoResponse data) {
                mView.getInfoSuccess(data);
            }
        });
    }
}
