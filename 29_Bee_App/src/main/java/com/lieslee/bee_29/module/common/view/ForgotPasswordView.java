package com.lieslee.bee_29.module.common.view;

import com.common.base.ui.BaseView;
import com.lieslee.bee_29.bean.common.SmsCodeTestResponse;

/**
 * Created by LiesLee on 17/6/9.
 */

public interface ForgotPasswordView extends BaseView {
    void modifySuccess();

    void getSmsCodeError();

    void testSmsCode(SmsCodeTestResponse data);
}
