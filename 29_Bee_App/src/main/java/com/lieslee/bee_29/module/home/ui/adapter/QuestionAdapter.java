package com.lieslee.bee_29.module.home.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.chad.library.adapter.base.BaseViewHolder;
import com.common.base.ui.BaseAdapter;
import com.lieslee.bee_29.R;
import com.lieslee.bee_29.bean.home.NewsListResponse;
import com.lieslee.bee_29.module.home.ui.activity.ContentActivity;

import java.util.Arrays;
import java.util.List;

/**
 * Created by LiesLee on 17/6/7.
 */

public class QuestionAdapter extends BaseAdapter<NewsListResponse.News> {
    public QuestionAdapter(Context ctx, List<NewsListResponse.News> data) {
        super(ctx, R.layout.item_question, null);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, final NewsListResponse.News data) {
        baseViewHolder.setText(R.id.tv_item_title, data.getTitle());

        baseViewHolder.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ContentActivity.class);
                intent.putExtra("id", data.getId());
                intent.putExtra("type", 3);
                mContext.startActivity(intent);
            }
        });
    }
}
