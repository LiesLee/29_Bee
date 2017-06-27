package com.lieslee.bee_29.module.home.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.common.annotation.ActivityFragmentInject;
import com.common.base.ui.BaseActivity;
import com.common.base.ui.BaseView;
import com.lieslee.bee_29.R;
import com.lieslee.bee_29.common.Constant;
import com.lieslee.bee_29.module.labour.ui.adapter.BeeListAdapter;
import com.views.util.RefreshUtil;

import butterknife.Bind;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * Created by LiesLee on 17/6/12.
 */
@ActivityFragmentInject(contentViewId = R.layout.fra_bee, toolbarTitle = R.string.my_bee)
public class MyBeeActivity extends BaseActivity implements BaseView {

    @Bind(R.id.rv_list)
    RecyclerView rv_list;
    @Bind(R.id.pcfl_pull_to_refresh)
    PtrClassicFrameLayout pcfl_pull_to_refresh;
    private BeeListAdapter mAdapter;
    private int pageNumber = 1;

    @Override
    protected void initView() {
        mAdapter = new BeeListAdapter(baseActivity, null);
        //initialize Refresh layout
        RefreshUtil.init_material_pull(baseActivity, pcfl_pull_to_refresh, new RefreshUtil.PtrRefreshListener() {
            @Override
            public void OnRefresh(final PtrFrameLayout frame) {
                pageNumber = 1;
                pcfl_pull_to_refresh.refreshComplete();
            }
        });

        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(baseActivity);
        rv_list.setLayoutManager(mLinearLayoutManager);
        rv_list.setAdapter(mAdapter);

        RefreshUtil.autoRefresh(pcfl_pull_to_refresh);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {

    }


    @Override
    public void hideProgress(int type) {
        super.hideProgress(type);
        if (type == Constant.PROGRESS_TYPE_LIST) {
            if (pageNumber == 1) {
                pcfl_pull_to_refresh.refreshComplete();
            }
        }
    }

}
