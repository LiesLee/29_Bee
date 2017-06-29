package com.lieslee.bee_29.module.home.view;

import com.common.base.ui.BaseView;
import com.lieslee.bee_29.bean.home.OrderListResponse;

/**
 * Created by LiesLee on 17/6/29.
 */

public interface MyBeeView extends BaseView {
    void loadOrderListSuccessed(OrderListResponse data);
}
