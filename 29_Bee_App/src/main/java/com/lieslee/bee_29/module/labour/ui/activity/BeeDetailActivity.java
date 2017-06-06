package com.lieslee.bee_29.module.labour.ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.common.annotation.ActivityFragmentInject;
import com.common.base.ui.BaseActivity;
import com.common.base.ui.BaseView;
import com.lai.library.ButtonStyle;
import com.lieslee.bee_29.R;

import butterknife.Bind;

/**
 * Created by LiesLee on 2017/6/6.
 * Email: LiesLee@foxmail.com
 */
@ActivityFragmentInject(contentViewId = R.layout.act_bee_detail, toolbarTitle = R.string.buy_bee)
public class BeeDetailActivity extends BaseActivity implements BaseView {
    @Bind(R.id.tv_bee_title)
    TextView tv_bee_title;
    @Bind(R.id.tv_dividends)
    TextView tv_dividends;
    @Bind(R.id.tv_price)
    TextView tv_price;
    @Bind(R.id.tv_period)
    TextView tv_period;
    @Bind(R.id.tv_type)
    TextView tv_type;
    @Bind(R.id.tv_total_price)
    TextView tv_total_price;
    @Bind(R.id.et_count)
    EditText et_count;
    @Bind(R.id.bts_buy)
    ButtonStyle bts_buy;
    @Bind(R.id.iv_img)
    ImageView iv_img;


    @Override
    protected void initView() {
        bts_buy.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
      switch (v.getId()) {
          case R.id.bts_buy :

              break;

          default:
              break;
      }
    }
}
