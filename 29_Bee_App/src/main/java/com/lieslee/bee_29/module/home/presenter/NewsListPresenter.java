package com.lieslee.bee_29.module.home.presenter;

import com.common.base.presenter.BasePresenterImpl;
import com.common.callback.RequestCallback;
import com.lieslee.bee_29.bean.home.NewsListResponse;
import com.lieslee.bee_29.common.Constant;
import com.lieslee.bee_29.http.HttpUtil;
import com.lieslee.bee_29.http.protocol.HomeProtocol;
import com.lieslee.bee_29.module.home.view.NewsListView;

/**
 * Created by LiesLee on 17/6/28.
 */

public class NewsListPresenter extends BasePresenterImpl<NewsListView> {

    public NewsListPresenter(NewsListView view) {
        super(view);
    }

    public void getNewsList(int page) {
        HttpUtil.requestDefault(HomeProtocol.articlePage(page), mView, new RequestCallback<NewsListResponse>() {
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
            public void requestSuccess(NewsListResponse data) {
                mView.getListDone(data);
            }
        });
    }

    public void getQuestionList(int page) {
        HttpUtil.requestDefault(HomeProtocol.helpPage(page), mView, new RequestCallback<NewsListResponse>() {
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
            public void requestSuccess(NewsListResponse data) {
                mView.getListDone(data);
            }
        });
    }


}
