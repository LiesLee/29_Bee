package com.lieslee.bee_29.module.labour.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.chad.library.adapter.base.BaseViewHolder;
import com.common.base.ui.BaseAdapter;
import com.lieslee.bee_29.R;
import com.lieslee.bee_29.module.labour.ui.activity.BeeDetailActivity;

import java.util.Arrays;
import java.util.List;

/**
 * Created by LiesLee on 17/6/6.
 */

public class BeeListAdapter extends BaseAdapter<String> {
    public BeeListAdapter(Context ctx, List<String> data) {
        super(ctx, R.layout.item_buy_bee, Arrays.asList(new String[20]));
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, String s) {
        baseViewHolder.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent beeIntent = new Intent(mContext, BeeDetailActivity.class);
                mContext.startActivity(beeIntent);
            }
        });
    }
}
