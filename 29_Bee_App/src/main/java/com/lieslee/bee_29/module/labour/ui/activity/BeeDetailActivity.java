package com.lieslee.bee_29.module.labour.ui.activity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Handler;
import android.os.Message;
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
import com.lieslee.bee_29.bean.labour.OrderComfirmResponse;
import com.lieslee.bee_29.bean.labour.OrderPaymentResponse;
import com.lieslee.bee_29.module.labour.presenter.BeeDetailPresenter;
import com.lieslee.bee_29.module.labour.view.BeeDetailView;
import com.lieslee.bee_29.utils.DialogHelper;
import com.lieslee.bee_29.utils.GlideUtil;
import com.paysdk.payutil.AuthResult;
import com.paysdk.payutil.PayResult;
import com.paysdk.payutil.PayUtil;
import com.tencent.mm.sdk.modelpay.PayReq;

import java.math.BigDecimal;
import java.util.Map;

import butterknife.Bind;

/**
 * Created by LiesLee on 2017/6/6.
 * Email: LiesLee@foxmail.com
 */
@ActivityFragmentInject(contentViewId = R.layout.act_bee_detail, toolbarTitle = R.string.buy_bee)
public class BeeDetailActivity extends BaseActivity<BeeDetailPresenter> implements BeeDetailView {

    private static final int SDK_PAY_FLAG = 1;
    private static final int SDK_AUTH_FLAG = 2;

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
    private OrderComfirmResponse finalPayData;
    private int payType = 0;


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
            case R.id.bts_buy:
                if (mData != null) {
                    if (!TextUtils.isEmpty(et_count.getText()) && Integer.parseInt(et_count.getText().toString()) >= mData.getProject_info().getBuy_min()) {
                        mPresenter.orderConfirm(mData.getProject_info().getProject_id(), Integer.parseInt(et_count.getText().toString()));
                    } else {
                        DialogHelper.showTipsDialog(baseActivity, "该项目购买数量最少为：" + mData.getProject_info().getBuy_min(), "好的", new DialogHelper.DialogOnclickCallback() {
                            @Override
                            public void onButtonClick(Dialog dialog) {
                                et_count.setText(mData.getProject_info().getBuy_min() + "");
                            }
                        });
                    }
                }
                break;

            default:
                break;
        }
    }

    @Override
    public void getBeedetailSuccessed(BeeDetailResponse data) {
        if (data != null) {
            mData = data;
            GlideUtil.loadImage(baseActivity, data.getProject_info().getProject_image(), iv_img);
            tv_bee_title.setText(data.getProject_info().getTitle());
            tv_dividends.setText(data.getProject_info().getIncome_percent() + "%");
            tv_price.setText(data.getProject_info().getPrice() + "");
            tv_period.setText(data.getProject_info().getIncome_cycle() + "");
            tv_type.setText(data.getProject_info().getType_title());
            initListener();
            et_count.setText(data.getProject_info().getBuy_min() + "");
        } else {
            finish();
        }
    }

    @Override
    public void onOrderConfirm(OrderComfirmResponse data) {
        finalPayData = data;
        if (finalPayData != null) {
            DialogHelper.showPayTypeDialog(baseActivity, data.getOrder_info().getOrder_promote(), data.getPay_type(), null, new DialogHelper.DialogOnclickSelectCallback() {
                @Override
                public void onButtonClick(Dialog dialog, int position) { //0微信 1支付宝 2余额
                    payType = position;
                    if (position == 4) {
                        if (finalPayData.getUser_wallet().getMoney() >= finalPayData.getOrder_info().getOrder_promote()) {
                            DialogHelper.showPayPasswordDialog(baseActivity, "输入支付密码", null, new DialogHelper.DialogOnclickTextCallback() {
                                @Override
                                public void onButtonClick(Dialog dialog, String text) {
                                    mPresenter.orderPayment(finalPayData.getProject_inof().getProject_id(), finalPayData.getOrder_info().getBuy_num(), payType, text);
                                }
                            });
                        } else {
                            DialogHelper.showTipsDialog(baseActivity, "您钱包的余额不足以支付本次订单哟！", "好的", null);
                        }
                    }
                }
            });
        }

    }

    @Override
    public void onOrderPaymentSuccessed(OrderPaymentResponse data) {

        switch (payType) {
            case 1:  // 微信
                PayReq payReq = new PayReq();
                payReq.appId = data.getWeixin_data().getAppid();
                payReq.partnerId = data.getWeixin_data().getPartnerid();
                payReq.prepayId = data.getWeixin_data().getPrepayid();
                payReq.packageValue = data.getWeixin_data().getWeixinpackage();
                payReq.nonceStr = data.getWeixin_data().getNoncestr();
                payReq.timeStamp = data.getWeixin_data().getTimestamp();
                payReq.sign = data.getWeixin_data().getSign();

                PayUtil.WXPay(baseActivity, payReq);
                break;
            case 2:  // 支付宝
                PayUtil.AliPay(baseActivity, mHandler, data.getAlipay_data().getApp_param());
                break;
            case 4:
                toast("支付成功！");
                break;
        }

    }

    void initListener() {
        et_count.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {

                if (TextUtils.isEmpty(charSequence)) {
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

                if (mData == null) return;


                int mCount = Integer.parseInt(charSequence.toString());
                int select = charSequence.length() > 0 ? charSequence.length() : 0;


                if (mCount > mData.getProject_info().getBuy_max()) {
                    et_count.setText(mData.getProject_info().getBuy_max() + "");
                    return;
                }

                et_count.setSelection(select);
                BigDecimal p = new BigDecimal(mData.getProject_info().getPrice());
                BigDecimal c = new BigDecimal(mCount);
                double amount = p.multiply(c).setScale(2, BigDecimal.ROUND_HALF_EVEN).doubleValue();
                tv_total_price.setText("￥ " + amount);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    @SuppressWarnings("unchecked")
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    /**
                     对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为9000则代表支付成功
                    if (TextUtils.equals(resultStatus, "9000")) {
                        // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                        toast("支付成功");
                    } else {
                        // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                        toast("支付失败");
                    }
                    break;
                }
                case SDK_AUTH_FLAG: {
                    @SuppressWarnings("unchecked")
                    AuthResult authResult = new AuthResult((Map<String, String>) msg.obj, true);
                    String resultStatus = authResult.getResultStatus();

                    // 判断resultStatus 为“9000”且result_code
                    // 为“200”则代表授权成功，具体状态码代表含义可参考授权接口文档
                    if (TextUtils.equals(resultStatus, "9000") && TextUtils.equals(authResult.getResultCode(), "200")) {
                        // 获取alipay_open_id，调支付时作为参数extern_token 的value
                        // 传入，则支付账户为该授权账户
                        toast("授权成功\n" + String.format("authCode:%s", authResult.getAuthCode()));

                    } else {
                        // 其他状态值则为授权失败
                        toast("授权失败" + String.format("authCode:%s", authResult.getAuthCode()));
                    }
                    break;
                }
                default:
                    break;
            }
        }

        ;
    };

}
