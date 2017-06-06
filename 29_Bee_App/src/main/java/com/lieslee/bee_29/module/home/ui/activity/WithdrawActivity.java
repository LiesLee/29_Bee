package com.lieslee.bee_29.module.home.ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.common.annotation.ActivityFragmentInject;
import com.common.base.ui.BaseActivity;
import com.common.base.ui.BaseView;
import com.lai.library.ButtonStyle;
import com.lieslee.bee_29.R;

import butterknife.Bind;

/**
 * Created by LiesLee on 2017/6/7.
 * Email: LiesLee@foxmail.com
 */
@ActivityFragmentInject(contentViewId = R.layout.act_withdraw, toolbarTitle = R.string.withdraw)
public class WithdrawActivity extends BaseActivity implements BaseView {

    @Bind(R.id.rl_select_bankcard)
    RelativeLayout rl_select_bankcard;
    @Bind(R.id.tv_bankcard)
    TextView tv_bankcard;

    @Bind(R.id.tv_all_money)
    TextView tv_all_money;

    @Bind(R.id.tv_take_all)
    TextView tv_take_all;

    @Bind(R.id.et_money)
    EditText et_money;

    @Bind(R.id.bts_withdraw)
    ButtonStyle bts_withdraw;

    @Bind(R.id.ll_introductions)
    LinearLayout ll_introductions;
    @Override
    protected void initView() {
        bts_withdraw.setOnClickListener(this);
        rl_select_bankcard.setOnClickListener(this);
        tv_take_all.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_take_all :

                break;
            case R.id.rl_select_bankcard :

                break;
            case R.id.bts_withdraw :

                break;

            default:
                break;
        }
    }
}
