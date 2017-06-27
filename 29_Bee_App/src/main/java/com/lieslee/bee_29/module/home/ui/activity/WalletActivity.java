package com.lieslee.bee_29.module.home.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.common.annotation.ActivityFragmentInject;
import com.common.base.ui.BaseActivity;
import com.lai.library.ButtonStyle;
import com.lieslee.bee_29.R;
import com.lieslee.bee_29.bean.home.WalletResponse;
import com.lieslee.bee_29.module.home.presenter.WalletPresenter;
import com.lieslee.bee_29.module.home.view.WalletView;

import butterknife.Bind;

/**
 * Created by LiesLee on 2017/6/6.
 * Email: LiesLee@foxmail.com
 */
@ActivityFragmentInject(contentViewId = R.layout.act_wallet, toolbarTitle = R.string.my_wallet)
public class WalletActivity extends BaseActivity<WalletPresenter> implements WalletView {

    @Bind(R.id.tv_balance)
    TextView tv_balance;
    @Bind(R.id.bts_withdraw)
    ButtonStyle bts_withdraw;
    @Bind(R.id.bts_withdrawals_record)
    ButtonStyle bts_withdrawals_record;

    @Override
    protected void initView() {
        mPresenter = new WalletPresenter(this);
        bts_withdraw.setOnClickListener(this);
        bts_withdrawals_record.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.getWallet();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bts_withdraw :
                Intent withdrawIntent = new Intent(baseActivity, WithdrawActivity.class);
                startActivity(withdrawIntent);
                break;

            case R.id.bts_withdrawals_record :
                Intent recordIntent = new Intent(baseActivity, TransactionRecordActivity.class);
                startActivity(recordIntent);
                break;

            default:
                break;
        }
    }

    @Override
    public void getWalletSuccess(WalletResponse data) {
        tv_balance.setText(data.getUser_wallet().getMoney());
    }
}
