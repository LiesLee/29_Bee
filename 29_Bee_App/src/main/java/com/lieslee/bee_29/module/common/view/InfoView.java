package com.lieslee.bee_29.module.common.view;

import com.common.base.ui.BaseView;
import com.lieslee.bee_29.bean.common.CommonInfoResponse;

/**
 * Created by LiesLee on 17/6/27.
 */

public interface InfoView extends BaseView {
    void getInfoSuccess(CommonInfoResponse data);
}
