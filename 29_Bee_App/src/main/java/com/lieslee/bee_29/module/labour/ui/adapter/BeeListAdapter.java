package com.lieslee.bee_29.module.labour.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.chad.library.adapter.base.BaseViewHolder;
import com.common.base.ui.BaseAdapter;
import com.lieslee.bee_29.R;
import com.lieslee.bee_29.bean.labour.BeeListResponse;
import com.lieslee.bee_29.module.labour.ui.activity.BeeDetailActivity;

import java.util.Arrays;
import java.util.List;

/**
 * Created by LiesLee on 17/6/6.
 */

public class BeeListAdapter extends BaseAdapter<BeeListResponse.Bee> {
    public BeeListAdapter(Context ctx, List<BeeListResponse.Bee> data) {
        super(ctx, R.layout.item_buy_bee, null);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, final BeeListResponse.Bee data) {

        baseViewHolder.setText(R.id.tv_no, data.getSimple_title());
        baseViewHolder.setText(R.id.tv_bee_title, data.getTitle());
        baseViewHolder.setText(R.id.tv_income, data.getIncome_percent()+"%");
        baseViewHolder.setText(R.id.tv_price, data.getPrice()+"");
        baseViewHolder.setText(R.id.tv_deadline, data.getIncome_cycle()+"");
        baseViewHolder.setText(R.id.tv_tips, data.getStatus_title());

        baseViewHolder.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent beeIntent = new Intent(mContext, BeeDetailActivity.class);
                beeIntent.putExtra("id", data.getProject_id());
                mContext.startActivity(beeIntent);
            }
        });
    }
}
