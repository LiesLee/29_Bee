package com.lieslee.bee_29.module.home.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.common.annotation.ActivityFragmentInject;
import com.common.base.ui.BaseActivity;
import com.common.base.ui.BaseView;
import com.lieslee.bee_29.R;
import com.lieslee.bee_29.bean.home.OrderListResponse;
import com.lieslee.bee_29.common.Constant;
import com.lieslee.bee_29.module.home.presenter.MyBeePresenter;
import com.lieslee.bee_29.module.home.view.MyBeeView;
import com.lieslee.bee_29.module.labour.presenter.BeeDetailPresenter;
import com.lieslee.bee_29.module.labour.ui.adapter.BeeListAdapter;
import com.lieslee.bee_29.module.labour.ui.adapter.OrderListAdapter;
import com.lieslee.bee_29.module.labour.view.BeeDetailView;
import com.views.util.RefreshUtil;

import butterknife.Bind;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * Created by LiesLee on 17/6/12.
 */
@ActivityFragmentInject(contentViewId = R.layout.fra_bee, toolbarTitle = R.string.my_bee)
public class MyBeeActivity extends BaseActivity<MyBeePresenter> implements MyBeeView {

    @Bind(R.id.rv_list)
    RecyclerView rv_list;
    @Bind(R.id.pcfl_pull_to_refresh)
    PtrClassicFrameLayout pcfl_pull_to_refresh;
    private OrderListAdapter mAdapter;
    private int pageNumber = 1;

    @Override
    protected void initView() {
        mPresenter = new MyBeePresenter(this);
        mAdapter = new OrderListAdapter(baseActivity, null);
        //initialize Refresh layout
        RefreshUtil.init_material_pull(baseActivity, pcfl_pull_to_refresh, new RefreshUtil.PtrRefreshListener() {
            @Override
            public void OnRefresh(final PtrFrameLayout frame) {
                pageNumber = 1;
                mPresenter.getOrderList(pageNumber);
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

    @Override
    public void loadOrderListSuccessed(OrderListResponse data) {

        if (pageNumber == 1) {
            if (data != null) mAdapter.setData(data.getLists());
            if (mAdapter.getData().size() > 10) {
                mAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
                    @Override
                    public void onLoadMoreRequested() {
                        ++pageNumber;
                        mPresenter.getOrderList(pageNumber);
                    }
                });
            }
        } else {
            if (data != null && data.getLists() != null && data.getLists().size() > 0) {
                mAdapter.addNewData(data.getLists());
            } else {
                --pageNumber;
                if (pageNumber < 1) {
                    pageNumber = 1;
                }
                mAdapter.addNewData(null);
            }
        }

    }
}
