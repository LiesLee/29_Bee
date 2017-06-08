package com.lieslee.bee_29.application;

import android.os.Handler;
import android.support.multidex.MultiDexApplication;
import android.text.TextUtils;

import com.alibaba.fastjson.JSONObject;
import com.common.utils.FastJsonUtil;
import com.karumi.dexter.Dexter;
import com.lieslee.bee_29.BuildConfig;
import com.lieslee.bee_29.bean.common.User;
import com.lieslee.bee_29.common.Constant;
import com.lieslee.bee_29.utils.SpUtil;
import com.socks.library.KLog;

/**
 * Created by LiesLee on 2017/5/24.
 * Email: LiesLee@foxmail.com
 */

public class BeeApplication extends MultiDexApplication {
    public static volatile BeeApplication instance;
    private Handler handler;
    private User user;
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




    /**
     * 是否登录过
     * @return
     */
    public boolean isLogin(){

        return (getUser() != null && getUser().getUser() != null);
    }

    public void setUser(User user) {
        if(user == null){
            this.user = null;
            SpUtil.remove(Constant.USER);
        }else{
            this.user = user;
            SpUtil.writeString(Constant.USER, FastJsonUtil.t2Json2(user));
        }

    }



    public User getUser(){
        if(user == null || user.getUser() ==null){
            String js = SpUtil.readString(Constant.USER);
            if(TextUtils.isEmpty(js)){
                return null;
            }else{
                user = JSONObject.parseObject(js, User.class);
                if(user!=null && user.getUser() != null){
                    return user;
                }else{
                    return null;
                }

            }
        }else{
            return user;
        }
    }

}
