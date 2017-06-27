package com.lieslee.bee_29.module.home.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import com.chad.library.adapter.base.BaseViewHolder;
import com.common.base.ui.BaseAdapter;
import com.lieslee.bee_29.R;
import com.lieslee.bee_29.bean.home.Bankcard;
import com.lieslee.bee_29.module.home.ui.activity.AddBankCardActivity;
import com.lieslee.bee_29.utils.GlideUtil;
import com.views.CircleImageView;

import java.util.List;

/**
 * Created by LiesLee on 16/11/3.
 */
public class BankCardAdapter extends BaseAdapter<Bankcard> {

    public BankCardAdapter(Context ctx, List<Bankcard> data) {
        super(ctx, R.layout.item_bank_card, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, final Bankcard bankcard) {
        CardView cv_card_layout = baseViewHolder.getView(R.id.cv_card_layout);
        //CircleImageView civ_bank = baseViewHolder.getView(R.id.civ_bank);
        baseViewHolder.setText(R.id.tv_bank_name, bankcard.getBank_name());
        //baseViewHolder.setText(R.id.tv_card_type, bankcard.getBanktype_name());
        baseViewHolder.setText(R.id.tv_card_number, bankcard.getCard_no());
        //GlideUtil.loadImage((AppCompatActivity)mContext, bankcard.getBanktype_icon(), civ_bank);
        //cv_card_layout.setCardBackgroundColor(Color.parseColor(bankcard.getBanktype_color()));
        baseViewHolder.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, AddBankCardActivity.class);
                intent.putExtra("showType", 1);
                intent.putExtra("bankcard", bankcard);
                ((AppCompatActivity)mContext).startActivityForResult(intent, 1);
            }
        });
    }
}
