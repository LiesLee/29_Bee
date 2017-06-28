package com.lieslee.bee_29.module.home.ui.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseViewHolder;
import com.common.base.ui.BaseAdapter;
import com.lieslee.bee_29.R;
import com.lieslee.bee_29.bean.home.TransactionRecordResponse;
import com.lieslee.bee_29.bean.home.WithdrawalsRecordResponse;

import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by LiesLee on 17/6/7.
 */

public class TransactionRecordAdapter extends BaseAdapter<TransactionRecordResponse.TransctionRecord> {
    public TransactionRecordAdapter(Context ctx, List<TransactionRecordResponse.TransctionRecord> data) {
        super(ctx, R.layout.item_transaction_record, null);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, TransactionRecordResponse.TransctionRecord data) {
        baseViewHolder.setText(R.id.tv_item_title, data.getTitle());
        baseViewHolder.setText(R.id.tv_item_content, data.getRemark());
        baseViewHolder.setText(R.id.textView5, data.getAdd_time());
    }
}
