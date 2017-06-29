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
import com.lieslee.bee_29.bean.home.HomeFragmentPresenter;
import com.lieslee.bee_29.bean.home.HomeResponse;
import com.lieslee.bee_29.bean.labour.Bee;
import com.lieslee.bee_29.module.common.ui.activity.MainActivity;
import com.lieslee.bee_29.module.common.view.HomeView;
import com.lieslee.bee_29.module.home.ui.activity.BankCardAcitvity;
import com.lieslee.bee_29.module.home.ui.activity.ContentActivity;
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
public class MainFragment extends BaseFragment<HomeFragmentPresenter> implements HomeView {
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
    private Bee bee;
    private HomeResponse.BulletinRecommend recomend;


    @Override
    protected void initView(View fragmentRootView) {
        mPresenter = new HomeFragmentPresenter(this);
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
        mPresenter.loadHomeData();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_bee:
                if(bee == null) break;
                Intent beeIntent = new Intent(baseActivity, BeeDetailActivity.class);
                beeIntent.putExtra("id", bee.getProject_id());
                startActivity(beeIntent);
                break;

            case R.id.ll_notice:
                if (recomend == null) return;
                Intent intent = new Intent(baseActivity, ContentActivity.class);
                intent.putExtra("id", recomend.getId());
                intent.putExtra("type", 4);
                startActivity(intent);
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


    @Override
    public void loadHomeDataSuccessed(HomeResponse data) {
        if(data!=null){
            if(data.getProject_recommend()!=null && data.getProject_recommend().size() >0){
                bee = data.getProject_recommend().get(0);
                if(bee != null){
                    tv_no.setText(bee.getSimple_title());
                    tv_bee_title.setText(bee.getTitle());
                    tv_income.setText(bee.getIncome_percent()+"%");
                    tv_price.setText(bee.getPrice()+"");
                    tv_deadline.setText(bee.getIncome_cycle()+"");
                    tv_tips.setText(bee.getStatus_title());
                    ll_bee.setVisibility(View.VISIBLE);
                }else{
                    ll_bee.setVisibility(View.GONE);
                }
            }else{
                ll_bee.setVisibility(View.GONE);
            }

            if(data.getBulletin_recommend()!=null && data.getBulletin_recommend().size() > 0){

                recomend = data.getBulletin_recommend().get(0);
                if(recomend!=null){
                    ll_notice.setVisibility(View.VISIBLE);
                    mtv_notice.setText(recomend.getTitle());
                }else{
                    ll_notice.setVisibility(View.GONE);
                }

            }else{
                ll_notice.setVisibility(View.GONE);
            }
        }
    }
}
