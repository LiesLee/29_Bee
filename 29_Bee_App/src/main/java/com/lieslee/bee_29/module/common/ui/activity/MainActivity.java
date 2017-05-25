package com.lieslee.bee_29.module.common.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.common.ShiHuiActivityManager;
import com.common.annotation.ActivityFragmentInject;
import com.common.base.ui.BaseActivity;
import com.common.base.ui.BaseFragment;
import com.common.base.ui.BaseView;
import com.lieslee.bee_29.R;
import com.lieslee.bee_29.module.common.persenter.MainActivityPresenter;
import com.lieslee.bee_29.module.common.ui.adapter.MainFragmentAdapter;
import com.lieslee.bee_29.module.home.ui.MainFragment;
import com.lieslee.bee_29.module.labour.ui.LabourFragment;
import com.lieslee.bee_29.module.my.ui.MyFragment;
import com.views.NonSwipeableViewPager;
import com.views.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

@ActivityFragmentInject(contentViewId = R.layout.activity_main, toolbarTitle = R.string.app_name)
public class MainActivity extends BaseActivity<MainActivityPresenter> implements BaseView {
    /**
     * 主页存放3个模块的ViewPager
     */
    @Bind(R.id.vp_main)
    NonSwipeableViewPager vp_main;

    @Bind(R.id.rg_main)
    RadioGroup rg_main;
    @Bind(R.id.rb_home)
    RadioButton rb_home;
    @Bind(R.id.rb_find)
    RadioButton rb_find;
    @Bind(R.id.rb_person)
    RadioButton rb_person;

    List<BaseFragment> fragments;
    MainFragmentAdapter fragmentAdapter;

    MainFragment mainFragment;
    LabourFragment labourFragment;
    MyFragment myFragment;

    /**
     * 点击返回键退出时间记录
     */
    private long exitTime = 0;


    @Override
    protected void initView() {
        fragments = new ArrayList<>();

        mainFragment = new MainFragment();
        labourFragment = new LabourFragment();
        myFragment = new MyFragment();

        fragments.add(mainFragment);
        fragments.add(labourFragment);
        fragments.add(myFragment);

        fragmentAdapter = new MainFragmentAdapter(getSupportFragmentManager(), fragments);
        vp_main.setAdapter(fragmentAdapter);
        vp_main.setOffscreenPageLimit(fragmentAdapter.getCount());


        rg_main.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_home:
                        vp_main.setCurrentItem(0);
                        break;
                    case R.id.rb_find:
                        vp_main.setCurrentItem(1);
                        break;
                    case R.id.rb_person:
                        vp_main.setCurrentItem(2);
                        break;
                }
            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                ToastUtil.showShortToast(baseActivity, "再按一次退出应用");
                exitTime = System.currentTimeMillis();
            } else {
                ShiHuiActivityManager.getInstance().cleanActivity();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
