package com.lieslee.bee_29.module.common.persenter;

import com.common.base.presenter.BasePresenterImpl;
import com.common.callback.RequestCallback;
import com.lieslee.bee_29.application.BeeApplication;
import com.lieslee.bee_29.bean.common.User;
import com.lieslee.bee_29.common.Constant;
import com.lieslee.bee_29.http.HttpUtil;
import com.lieslee.bee_29.http.protocol.CommonProtocol;
import com.lieslee.bee_29.module.common.view.UserView;

/**
 * Created by LiesLee on 17/6/8.
 */

public class LoginPresenter extends BasePresenterImpl<UserView> {
    public LoginPresenter(UserView view) {
        super(view);
    }

    public void login(String mobile, String login_password){
        HttpUtil.requestDefault(CommonProtocol.login(mobile, login_password), mView, new RequestCallback<User>() {
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
            public void requestSuccess(User data) {
                if(data!=null){
                    BeeApplication.getInstance().setUser(data);
                    mView.getUserSuccess(data);
                }

            }
        });
    }
}
