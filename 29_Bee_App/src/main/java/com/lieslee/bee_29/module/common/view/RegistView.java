package com.lieslee.bee_29.module.common.view;

import com.common.base.ui.BaseView;
import com.lieslee.bee_29.bean.common.SmsCodeTestResponse;

/**
 * Created by LiesLee on 17/6/8.
 */

public interface RegistView extends BaseView {
    void registSuccess();
    void getSmsCodeError();

    void testSmsCode(SmsCodeTestResponse data);
}
