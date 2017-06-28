package com.lieslee.bee_29.module.home.view;

import com.common.base.ui.BaseView;
import com.lieslee.bee_29.bean.home.NewsListResponse;

/**
 * Created by LiesLee on 17/6/28.
 */

public interface NewsListView extends BaseView {
    void getListDone(NewsListResponse data);
}
