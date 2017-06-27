package com.lieslee.bee_29.module.my.ui;

import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import com.common.ShiHuiActivityManager;
import com.common.annotation.ActivityFragmentInject;
import com.common.base.presenter.BasePresenterImpl;
import com.common.base.ui.BaseFragment;
import com.common.base.ui.BaseView;
import com.lieslee.bee_29.R;
import com.lieslee.bee_29.application.BeeApplication;
import com.lieslee.bee_29.module.common.ui.activity.ForgotPasswordActivity;
import com.lieslee.bee_29.module.common.ui.activity.LoginActivity;
import com.lieslee.bee_29.module.common.ui.activity.ModifyPayPasswordActivity;
import com.lieslee.bee_29.module.home.ui.activity.ContentActivity;
import com.lieslee.bee_29.utils.DialogHelper;

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
                Intent intentFoget = new Intent(baseActivity, ForgotPasswordActivity.class);
                intentFoget.putExtra("type",1);
                startActivity(intentFoget);
                break;

            case R.id.ll_modify_pay_password :
                startActivity(new Intent(baseActivity, ModifyPayPasswordActivity.class));
                break;

            case R.id.ll_about : //关于
                Intent intent = new Intent(baseActivity, ContentActivity.class);
                intent.putExtra("type", 5);
                baseActivity.startActivity(intent);
                break;

            case R.id.ll_contactus : //联系
                Intent intentcontactus = new Intent(baseActivity, ContentActivity.class);
                intentcontactus.putExtra("type", 6);
                baseActivity.startActivity(intentcontactus);
                break;

            case R.id.ll_exit :
                DialogHelper.show2btnDialog(baseActivity, "你确定要退出吗？", "取消", "退出", false, null, new DialogHelper.DialogOnclickCallback() {
                    @Override
                    public void onButtonClick(Dialog dialog) {
                        ShiHuiActivityManager.getInstance().cleanActivity(baseActivity);
                        Intent intentExit = new Intent(baseActivity, LoginActivity.class);
                        startActivity(intentExit);
                        BeeApplication.getInstance().setUser(null);
                        baseActivity.finish();
                    }
                });

                break;

            default:
                break;
        }
    }
}
