package com.lieslee.bee_29.module.common.persenter;

import com.common.base.presenter.BasePresenterImpl;
import com.common.base.ui.BaseView;
import com.common.callback.RequestCallback;
import com.common.http.HttpSubscibe;
import com.lieslee.bee_29.application.BeeApplication;
import com.lieslee.bee_29.bean.home.HomeResponse;
import com.lieslee.bee_29.common.Constant;
import com.lieslee.bee_29.http.HttpUtil;
import com.lieslee.bee_29.http.protocol.HomeProtocol;
import com.lieslee.bee_29.module.common.view.HomeView;

import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by LiesLee on 17/2/27.
 */

public class MainActivityPresenter extends BasePresenterImpl<BaseView> {

    public MainActivityPresenter(BaseView view) {
        super(view);
    }

}
