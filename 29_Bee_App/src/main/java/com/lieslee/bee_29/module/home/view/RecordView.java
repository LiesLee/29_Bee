package com.lieslee.bee_29.module.home.view;

import com.common.base.ui.BaseView;
import com.lieslee.bee_29.bean.home.WithdrawalsRecordResponse;

/**
 * Created by LiesLee on 2017/6/27.
 * Email: LiesLee@foxmail.com
 */

public interface RecordView extends BaseView {
    void loadWithdrawalsRecordSuccessed(WithdrawalsRecordResponse data);
}
