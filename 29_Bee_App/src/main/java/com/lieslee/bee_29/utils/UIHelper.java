package com.lieslee.bee_29.utils;


import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.common.base.ui.BaseActivity;
import com.common.utils.UUID;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.lieslee.bee_29.R;
import com.views.util.ToastUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiesLee on 16/9/29.
 */
public class UIHelper {

    public static final int INTENT_REQUEST_GET_IMAGES = 13;

    public static void showShakeAnim(Context context, View view, String toast) {
        Animation shake = AnimationUtils.loadAnimation(context, R.anim.shake_x);
        view.startAnimation(shake);
        view.requestFocus();
        if(!TextUtils.isEmpty(toast)){
            ToastUtil.showShortToast(context, toast);
        }

    }

    public static boolean phoneNumberValid(String number) {
        // 手机号固定在5-20范围内
        if (number.length() < 5 || number.length() > 20) {
            return false;
        }

        String match = "";
        if (number.length() != 11) {
            return false;
        } else {
            // match = "^[1]{1}[0-9]{2}[0-9]{8}$";
            match = "^(1[3456789])\\d{9}$";
        }

        // 正则匹配
        if (!"".equals(match)) {
            return number.matches(match);
        }
        return true;
    }




}
