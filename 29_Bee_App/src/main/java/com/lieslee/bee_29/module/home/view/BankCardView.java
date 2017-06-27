package com.lieslee.bee_29.module.home.view;

import com.common.base.ui.BaseView;
import com.lieslee.bee_29.bean.home.BankcardListResponse;

/**
 * Created by LiesLee on 16/11/3.
 */
public interface BankCardView extends BaseView {
    void loadBankCardListDone(BankcardListResponse data);
}
