package com.lieslee.bee_29.module.home.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.chad.library.adapter.base.BaseViewHolder;
import com.common.base.ui.BaseAdapter;
import com.lieslee.bee_29.R;
import com.lieslee.bee_29.module.home.ui.activity.ContentActivity;

import java.util.Arrays;
import java.util.List;

/**
 * Created by LiesLee on 17/6/7.
 */

public class QuestionAdapter extends BaseAdapter<String> {
    public QuestionAdapter(Context ctx, List<String> data) {
        super(ctx, R.layout.item_question, Arrays.asList(new String[10]));
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, String s) {
        baseViewHolder.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ContentActivity.class);
                mContext.startActivity(intent);
            }
        });
    }
}
