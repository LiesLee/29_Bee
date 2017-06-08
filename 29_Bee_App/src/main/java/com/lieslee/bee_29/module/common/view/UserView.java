package com.lieslee.bee_29.module.common.view;

import com.common.base.ui.BaseView;
import com.lieslee.bee_29.bean.common.User;

/**
 * Created by LiesLee on 17/6/8.
 */

public interface UserView  extends BaseView{
    void getUserSuccess(User data);
}
