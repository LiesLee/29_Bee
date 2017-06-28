package com.lieslee.bee_29.module.labour.ui.activity;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.common.annotation.ActivityFragmentInject;
import com.common.base.ui.BaseActivity;
import com.common.base.ui.BaseView;
import com.lai.library.ButtonStyle;
import com.lieslee.bee_29.R;
import com.lieslee.bee_29.bean.labour.BeeDetailResponse;
import com.lieslee.bee_29.module.labour.presenter.BeeDetailPresenter;
import com.lieslee.bee_29.module.labour.view.BeeDetailView;
import com.lieslee.bee_29.utils.GlideUtil;

import java.math.BigDecimal;

import butterknife.Bind;

/**
 * Created by LiesLee on 2017/6/6.
 * Email: LiesLee@foxmail.com
 */
@ActivityFragmentInject(contentViewId = R.layout.act_bee_detail, toolbarTitle = R.string.buy_bee)
public class BeeDetailActivity extends BaseActivity<BeeDetailPresenter> implements BeeDetailView {
    @Bind(R.id.tv_bee_title)
    TextView tv_bee_title;
    @Bind(R.id.tv_dividends)
    TextView tv_dividends;
    @Bind(R.id.tv_price)
    TextView tv_price;
    @Bind(R.id.tv_period)
    TextView tv_period;
    @Bind(R.id.tv_type)
    TextView tv_type;
    @Bind(R.id.tv_total_price)
    TextView tv_total_price;
    @Bind(R.id.et_count)
    EditText et_count;
    @Bind(R.id.bts_buy)
    ButtonStyle bts_buy;
    @Bind(R.id.iv_img)
    ImageView iv_img;
    private String id;
    private BeeDetailResponse mData;


    @Override
    protected void initView() {
        id = getIntent().getStringExtra("id");
        mPresenter = new BeeDetailPresenter(this);
        bts_buy.setOnClickListener(this);
    }

    @Override
    public void initData() {
        mPresenter.getBeeDetail(id);
    }

    @Override
    public void onClick(View v) {
      switch (v.getId()) {
          case R.id.bts_buy :

              break;

          default:
              break;
      }
    }

    @Override
    public void getBeedetailSuccessed(BeeDetailResponse data) {
        if(data!=null){
            mData = data;
            GlideUtil.loadImage(baseActivity, data.getProject_info().getProject_image(), iv_img);
            tv_bee_title.setText(data.getProject_info().getTitle());
            tv_dividends.setText(data.getProject_info().getIncome_percent()+"%");
            tv_price.setText(data.getProject_info().getPrice()+"");
            tv_period.setText(data.getProject_info().getIncome_cycle()+"");
            tv_type.setText(data.getProject_info().getType_title());
            initListener();
            et_count.setText(data.getProject_info().getBuy_min()+"");
        }else{
            finish();
        }
    }

    void initListener(){
        et_count.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {

                if(TextUtils.isEmpty(charSequence)){
                    et_count.setText("0");
                    return;
                }

                //如果输入的第一个和第二个字符都为0，则消除第1个0
                if (charSequence.toString().startsWith("0")
                        && charSequence.toString().trim().length() > 1) {
                    if (!charSequence.toString().substring(1, 2).equals(".")) {
                        et_count.setText(charSequence.subSequence(1, 2));
                        return;
                    }
                }

                if(mData == null) return;



                int mCount = Integer.parseInt(charSequence.toString());
                int select = charSequence.length() > 0 ? charSequence.length() : 0 ;

                et_count.setSelection(select);
                BigDecimal p = new BigDecimal(mData.getProject_info().getPrice());
                BigDecimal c = new BigDecimal(count);
                double amount = p.multiply(c).setScale(2, BigDecimal.ROUND_HALF_EVEN).doubleValue();
                tv_total_price.setText("￥ "+amount);

                if(mCount < mData.getProject_info().getBuy_min()){
                    et_count.setText(mData.getProject_info().getBuy_min()+"");
                    return;
                }

                if(mCount > mData.getProject_info().getBuy_max()){
                    et_count.setText(mData.getProject_info().getBuy_max()+"");
                    return;
                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
