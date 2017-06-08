package com.lieslee.bee_29.module.common.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.common.annotation.ActivityFragmentInject;
import com.common.base.presenter.BasePresenterImpl;
import com.common.base.ui.BaseActivity;
import com.common.base.ui.BaseView;
import com.lieslee.bee_29.R;
import com.lieslee.bee_29.application.BeeApplication;

import java.util.Timer;
import java.util.TimerTask;



@ActivityFragmentInject(contentViewId = R.layout.act_logo)
public class LogoActivity extends BaseActivity<BasePresenterImpl> implements BaseView {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);  // 隐藏状态栏
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initData() {

    }


    @Override
    protected void initView() {
        Timer timer = new Timer();// 实例化Timer类
        timer.schedule(new TimerTask() {
            public void run() {
                //if(BeeApplication.getInstance().isLogin()){
                    Intent intent = new Intent(baseActivity, MainActivity.class);
                    startActivity(intent);
//                }else{
//                    Intent intent = new Intent(baseActivity, LoginActivity.class);
//                    startActivity(intent);
//                }

                this.cancel();
            }
        }, 2000);// 这里百毫秒

    }

    @Override
    public void onClick(View v) {

    }



}
