package com.lieslee.bee_29.module.common.persenter;

import com.common.base.presenter.BasePresenterImpl;
import com.common.base.ui.BaseView;
import com.common.callback.RequestCallback;
import com.common.http.HttpSubscibe;

import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by LiesLee on 17/2/27.
 */

public class MainActivityPresenter extends BasePresenterImpl<BaseView> {

    public MainActivityPresenter(BaseView view) {
        super(view);
    }


}
