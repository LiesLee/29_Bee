package com.lieslee.bee_29.module.my.ui;

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
@ActivityFragmentInject(contentViewId = R.layout.fra_my)
public class MyFragment extends BaseFragment<BasePresenterImpl> implements BaseView{
    @Bind(R.id.ll_modify_password)
    LinearLayout ll_modify_password;
    @Bind(R.id.ll_modify_pay_password)
    LinearLayout ll_modify_pay_password;
    @Bind(R.id.ll_about)
    LinearLayout ll_about;
    @Bind(R.id.ll_contactus)
    LinearLayout ll_contactus;
    @Bind(R.id.ll_exit)
    LinearLayout ll_exit;

    @Override
    protected void initView(View fragmentRootView) {
        ll_modify_password.setOnClickListener(this);
        ll_modify_pay_password.setOnClickListener(this);
        ll_about.setOnClickListener(this);
        ll_contactus.setOnClickListener(this);
        ll_exit.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_modify_password :

                break;

            case R.id.ll_modify_pay_password :

                break;

            case R.id.ll_about :

                break;

            case R.id.ll_contactus :

                break;

            case R.id.ll_exit :

                break;

            default:
                break;
        }
    }
}
