package com.lieslee.bee_29.application;

import android.os.Handler;
import android.support.multidex.MultiDexApplication;

import com.karumi.dexter.Dexter;
import com.lieslee.bee_29.BuildConfig;
import com.socks.library.KLog;

/**
 * Created by LiesLee on 2017/5/24.
 * Email: LiesLee@foxmail.com
 */

public class BeeApplication extends MultiDexApplication {
    public static volatile BeeApplication instance;
    private Handler handler;
    //private User user;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        handler = new Handler();
        KLog.init(BuildConfig.DEBUG);
        Dexter.initialize(this); //权限封装类
    }

    public static BeeApplication getInstance() {
        return instance;
    }


    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

}
