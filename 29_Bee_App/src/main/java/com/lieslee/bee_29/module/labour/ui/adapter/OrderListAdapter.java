package com.lieslee.bee_29.module.labour.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.chad.library.adapter.base.BaseViewHolder;
import com.common.base.ui.BaseAdapter;
import com.lieslee.bee_29.R;
import com.lieslee.bee_29.bean.home.OrderListResponse;
import com.lieslee.bee_29.bean.labour.Bee;
import com.lieslee.bee_29.module.labour.ui.activity.BeeDetailActivity;

import java.util.List;

/**
 * Created by LiesLee on 17/6/6.
 */

public class OrderListAdapter extends BaseAdapter<OrderListResponse.Order> {
    public OrderListAdapter(Context ctx, List<OrderListResponse.Order> data) {
        super(ctx, R.layout.item_buy_bee, null);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, final OrderListResponse.Order data) {

        baseViewHolder.setText(R.id.tv_no, data.getProject_info().getSimple_title());
        baseViewHolder.setText(R.id.tv_bee_title, data.getProject_info().getTitle());
        baseViewHolder.setText(R.id.tv_income, data.getProject_info().getIncome_percent()+"%");
        baseViewHolder.setText(R.id.tv_price, data.getProject_info().getPrice()+"");
        baseViewHolder.setText(R.id.tv_deadline, data.getProject_info().getIncome_cycle()+"");
        baseViewHolder.setText(R.id.tv_tips, data.getProject_info().getStatus_title());

        baseViewHolder.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent beeIntent = new Intent(mContext, BeeDetailActivity.class);
                beeIntent.putExtra("id", data.getProject_info().getProject_id());
                mContext.startActivity(beeIntent);
            }
        });
    }
}
