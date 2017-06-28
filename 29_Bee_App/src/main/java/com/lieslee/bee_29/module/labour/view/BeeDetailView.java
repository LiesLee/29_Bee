package com.lieslee.bee_29.module.labour.view;

import com.common.base.ui.BaseView;
import com.lieslee.bee_29.bean.labour.BeeDetailResponse;

/**
 * Created by LiesLee on 17/6/28.
 */

public interface BeeDetailView extends BaseView {
    void getBeedetailSuccessed(BeeDetailResponse data);
}
