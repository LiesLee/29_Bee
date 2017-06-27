package com.lieslee.bee_29.module.home.ui.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.common.annotation.ActivityFragmentInject;
import com.common.base.presenter.BasePresenterImpl;
import com.common.base.ui.BaseFragment;
import com.common.base.ui.BaseView;
import com.lieslee.bee_29.R;
import com.lieslee.bee_29.module.common.ui.activity.MainActivity;
import com.lieslee.bee_29.module.home.ui.activity.BankCardAcitvity;
import com.lieslee.bee_29.module.home.ui.activity.MyBeeActivity;
import com.lieslee.bee_29.module.home.ui.activity.NewsActivity;
import com.lieslee.bee_29.module.home.ui.activity.QuestionActivity;
import com.lieslee.bee_29.module.home.ui.activity.WalletActivity;
import com.lieslee.bee_29.module.labour.ui.activity.BeeDetailActivity;
import com.views.MarqueeTextView;

import butterknife.Bind;

/**
 * Created by LiesLee on 2017/5/25.
 * Email: LiesLee@foxmail.com
 */
@ActivityFragmentInject(contentViewId = R.layout.fra_main)
public class MainFragment extends BaseFragment<BasePresenterImpl> implements BaseView {
    @Bind(R.id.ll_bee)
    LinearLayout ll_bee;
    @Bind(R.id.ll_notice)
    LinearLayout ll_notice;
    @Bind(R.id.ll_my_wallet)
    LinearLayout ll_my_wallet;
    @Bind(R.id.ll_buy_bee)
    LinearLayout ll_buy_bee;
    @Bind(R.id.ll_my_bee)
    LinearLayout ll_my_bee;
    @Bind(R.id.ll_news)
    LinearLayout ll_news;
    @Bind(R.id.ll_bankcard)
    LinearLayout ll_bankcard;
    @Bind(R.id.ll_question)
    LinearLayout ll_question;


    @Bind(R.id.tv_no)
    TextView tv_no;
    @Bind(R.id.tv_bee_title)
    TextView tv_bee_title;
    @Bind(R.id.tv_income)
    TextView tv_income;
    @Bind(R.id.tv_price)
    TextView tv_price;
    @Bind(R.id.tv_deadline)
    TextView tv_deadline;
    @Bind(R.id.tv_tips)
    TextView tv_tips;

    @Bind(R.id.mtv_notice)
    MarqueeTextView mtv_notice;


    @Override
    protected void initView(View fragmentRootView) {
        ll_bee.setOnClickListener(this);
        ll_notice.setOnClickListener(this);
        ll_my_wallet.setOnClickListener(this);
        ll_buy_bee.setOnClickListener(this);
        ll_my_bee.setOnClickListener(this);
        ll_news.setOnClickListener(this);
        ll_bankcard.setOnClickListener(this);
        ll_question.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_bee:
                Intent beeIntent = new Intent(baseActivity, BeeDetailActivity.class);
                startActivity(beeIntent);
                break;

            case R.id.ll_notice:

                break;
            case R.id.ll_my_wallet:
                Intent walletIntent = new Intent(baseActivity, WalletActivity.class);
                baseActivity.startActivity(walletIntent);
                break;
            case R.id.ll_buy_bee:
                ((MainActivity) baseActivity).seleteFragment(1);
                break;
            case R.id.ll_my_bee:
                baseActivity.startActivity(new Intent(baseActivity, MyBeeActivity.class));
                break;
            case R.id.ll_news:
                Intent newsIntent = new Intent(baseActivity, NewsActivity.class);
                startActivity(newsIntent);
                break;
            case R.id.ll_bankcard:
                Intent bankcardIntent = new Intent(baseActivity, BankCardAcitvity.class);
                startActivity(bankcardIntent);
                break;

            case R.id.ll_question:
                Intent questionIntent = new Intent(baseActivity, QuestionActivity.class);
                startActivity(questionIntent);
                break;

            default:
                break;
        }
    }


}
