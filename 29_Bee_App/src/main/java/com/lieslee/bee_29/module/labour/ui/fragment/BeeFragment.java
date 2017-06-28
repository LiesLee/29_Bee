package com.lieslee.bee_29.module.labour.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.common.annotation.ActivityFragmentInject;
import com.common.base.presenter.BasePresenterImpl;
import com.common.base.ui.BaseFragment;
import com.common.base.ui.BaseView;
import com.lieslee.bee_29.R;
import com.lieslee.bee_29.bean.labour.BeeListResponse;
import com.lieslee.bee_29.common.Constant;
import com.lieslee.bee_29.module.labour.presenter.BeeListPresenter;
import com.lieslee.bee_29.module.labour.ui.adapter.BeeListAdapter;
import com.lieslee.bee_29.module.labour.view.BeeListView;
import com.views.util.RefreshUtil;

import butterknife.Bind;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * Created by LiesLee on 2017/5/25.
 * Email: LiesLee@foxmail.com
 */
@ActivityFragmentInject(contentViewId = R.layout.fra_bee)
public class BeeFragment extends BaseFragment<BeeListPresenter> implements BeeListView {


    @Bind(R.id.rv_list)
    RecyclerView rv_list;
    @Bind(R.id.pcfl_pull_to_refresh)
    PtrClassicFrameLayout pcfl_pull_to_refresh;
    private BeeListAdapter mAdapter;
    private int pageNumber = 1;

    @Override
    protected void initView(View fragmentRootView) {
        mPresenter = new BeeListPresenter(this);
        mAdapter = new BeeListAdapter(baseActivity, null);
        //initialize Refresh layout
        RefreshUtil.init_material_pull(baseActivity, pcfl_pull_to_refresh, new RefreshUtil.PtrRefreshListener() {
            @Override
            public void OnRefresh(final PtrFrameLayout frame) {
                pageNumber = 1;
                mPresenter.getBeeList(pageNumber);
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
    public void hideProgress(int type) {
        super.hideProgress(type);
        if (type == Constant.PROGRESS_TYPE_LIST) {
            if (pageNumber == 1) {
                pcfl_pull_to_refresh.refreshComplete();
            }
        }
    }


    @Override
    public void onClick(View v) {

    }


    @Override
    public void getBeeListSuccessed(BeeListResponse data) {
        if(pageNumber == 1){
            if(data != null)mAdapter.setData(data.getLists());
            if(mAdapter.getData().size() > 10){
                mAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
                    @Override
                    public void onLoadMoreRequested() {
                        ++pageNumber;
                        mPresenter.getBeeList(pageNumber);
                    }
                });
            }
        }else{
            if(data !=null && data.getLists()!=null && data.getLists().size() > 0){
                mAdapter.addNewData(data.getLists());
            }else{
                --pageNumber;
                if (pageNumber < 1) {
                    pageNumber = 1;
                }
                mAdapter.addNewData(null);
            }
        }
    }
}
