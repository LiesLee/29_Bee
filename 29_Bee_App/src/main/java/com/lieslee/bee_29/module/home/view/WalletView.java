package com.lieslee.bee_29.module.home.view;

import com.common.base.ui.BaseView;
import com.lieslee.bee_29.bean.home.WalletResponse;

/**
 * Created by LiesLee on 17/6/27.
 */

public interface WalletView extends BaseView {
    void getWalletSuccess(WalletResponse data);
}
