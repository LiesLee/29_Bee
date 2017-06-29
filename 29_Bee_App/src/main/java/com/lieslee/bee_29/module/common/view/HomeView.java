package com.lieslee.bee_29.module.common.view;

import com.common.base.ui.BaseView;
import com.lieslee.bee_29.bean.home.HomeResponse;

/**
 * Created by LiesLee on 17/6/29.
 */

public interface HomeView extends BaseView {

    void loadHomeDataSuccessed(HomeResponse data);
}
