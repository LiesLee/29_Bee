package com.lieslee.bee_29.module.home.ui.activity;

import android.view.View;
import android.widget.TextView;

import com.common.annotation.ActivityFragmentInject;
import com.common.base.ui.BaseActivity;
import com.common.base.ui.BaseView;
import com.lieslee.bee_29.R;

import butterknife.Bind;

/**
 * Created by LiesLee on 17/6/7.
 */
@ActivityFragmentInject(contentViewId = R.layout.act_content)
public class ContentActivity extends BaseActivity implements BaseView {

    @Bind(R.id.tv_content_title)
    TextView tv_content_title;
    @Bind(R.id.tv_time)
    TextView tv_time;
    @Bind(R.id.tv_content)
    TextView tv_content;

    @Override
    protected void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {

    }
}
