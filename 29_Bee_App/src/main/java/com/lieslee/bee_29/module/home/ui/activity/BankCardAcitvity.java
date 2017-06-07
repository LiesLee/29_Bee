package com.lieslee.bee_29.module.home.ui.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.common.annotation.ActivityFragmentInject;
import com.common.base.ui.BaseActivity;
import com.lieslee.bee_29.R;
import com.lieslee.bee_29.common.Constant;
import com.lieslee.bee_29.module.home.presenter.BankCardPresenter;
import com.lieslee.bee_29.module.home.ui.adapter.BankCardAdapter;
import com.lieslee.bee_29.module.home.view.BankCardView;
import com.views.util.RefreshUtil;

import butterknife.Bind;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * Created by LiesLee on 16/11/2.
 */
@ActivityFragmentInject(contentViewId = R.layout.act_bank_card,
        toolbarTitle = R.string.bank_card)
public class BankCardAcitvity extends BaseActivity<BankCardPresenter> implements BankCardView {

    @Bind(R.id.store_house_ptr_frame)
    PtrClassicFrameLayout store_house_ptr_frame;

    @Bind(R.id.rv_list)
    RecyclerView rv_list;
    @Bind(R.id.ll_no_bankcard)
    LinearLayout ll_no_bankcard;
    @Bind(R.id.tv_add_bankcard)
    TextView tv_add_bankcard;
    BankCardAdapter mAdapter;
    private LinearLayoutManager mLinearLayoutManager;

    //BankCardResponse data;

    @Override
    protected void initView() {
        mPresenter = new BankCardPresenter(this);
        mAdapter = new BankCardAdapter(baseActivity, null);
        //initialize Refresh layout
        RefreshUtil.init(baseActivity, store_house_ptr_frame, new RefreshUtil.PtrRefreshListener() {
            @Override
            public void OnRefresh(final PtrFrameLayout frame) {
                mPresenter.loadBankCardList();
            }
        });

        mLinearLayoutManager = new LinearLayoutManager(baseActivity);
        rv_list.setLayoutManager(mLinearLayoutManager);
        rv_list.setAdapter(mAdapter);
        tv_add_bankcard.setOnClickListener(this);
    }

    @Override
    public void initData() {
        RefreshUtil.autoRefresh(store_house_ptr_frame);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_add_bankcard :
                //if(this.data == null)break;
                Intent intent = new Intent(this, AddBankCardActivity.class);
                intent.putExtra("showType", 0);
                startActivityForResult(intent, 1);
                break;

            default:
                break;
        }
    }
//
//    @Override
//    public void loadBankCardListDone(BankCardResponse data) {
//        this.data = data;
//        if(this.data != null && data.getBankcard_lists() != null && data.getBankcard_lists().size() > 0){
//            mAdapter.setData(data.getBankcard_lists());
//            ll_no_bankcard.setVisibility(View.GONE);
//        }else{
//            mAdapter.setData(null);
//            ll_no_bankcard.setVisibility(View.VISIBLE);
//        }
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            mPresenter.loadBankCardList();
        }
    }


    @Override
    public void hideProgress(int type) {
        super.hideProgress(type);
        if (type == Constant.PROGRESS_TYPE_LIST) {
            store_house_ptr_frame.refreshComplete();
        }
    }
}
