package com.lieslee.bee_29.module.home.ui;

import android.view.View;
import android.widget.LinearLayout;

import com.common.annotation.ActivityFragmentInject;
import com.common.base.presenter.BasePresenterImpl;
import com.common.base.ui.BaseFragment;
import com.common.base.ui.BaseView;
import com.lieslee.bee_29.R;

import butterknife.Bind;

/**
 * Created by LiesLee on 2017/5/25.
 * Email: LiesLee@foxmail.com
 */
@ActivityFragmentInject(contentViewId = R.layout.fra_main)
public class MainFragment extends BaseFragment<BasePresenterImpl> implements BaseView {
    @Bind(R.id.ll_bee)
    LinearLayout ll_bee;
    @Bind(R.id.ll_notice)
    LinearLayout ll_notice;
    @Bind(R.id.ll_my_wallet)
    LinearLayout ll_my_wallet;
    @Bind(R.id.ll_buy_bee)
    LinearLayout ll_buy_bee;
    @Bind(R.id.ll_my_bee)
    LinearLayout ll_my_bee;
    @Bind(R.id.ll_news)
    LinearLayout ll_news;
    @Bind(R.id.ll_bankcard)
    LinearLayout ll_bankcard;
    @Bind(R.id.ll_question)
    LinearLayout ll_question;



    @Override
    protected void initView(View fragmentRootView) {

    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {

    }
}
