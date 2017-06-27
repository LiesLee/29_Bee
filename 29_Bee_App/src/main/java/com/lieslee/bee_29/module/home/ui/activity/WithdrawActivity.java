package com.lieslee.bee_29.module.home.ui.activity;

import android.app.Dialog;
import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.common.annotation.ActivityFragmentInject;
import com.common.base.ui.BaseActivity;
import com.common.base.ui.BaseView;
import com.lai.library.ButtonStyle;
import com.lieslee.bee_29.R;
import com.lieslee.bee_29.bean.home.WithdrawIndexResponse;
import com.lieslee.bee_29.module.home.presenter.WithdrawPresenter;
import com.lieslee.bee_29.module.home.view.WithDrawView;
import com.lieslee.bee_29.utils.DialogHelper;

import java.math.BigDecimal;

import butterknife.Bind;

/**
 * Created by LiesLee on 2017/6/7.
 * Email: LiesLee@foxmail.com
 */
@ActivityFragmentInject(contentViewId = R.layout.act_withdraw, toolbarTitle = R.string.withdraw)
public class WithdrawActivity extends BaseActivity<WithdrawPresenter> implements WithDrawView {

    @Bind(R.id.rl_select_bankcard)
    RelativeLayout rl_select_bankcard;
    @Bind(R.id.tv_bankcard)
    TextView tv_bankcard;


    @Bind(R.id.et_money)
    EditText et_money;

    @Bind(R.id.bts_withdraw)
    ButtonStyle bts_withdraw;

    @Bind(R.id.ll_drawout_info_list)
    LinearLayout ll_drawout_info_list;
    private String mBankcardId;
    private WithdrawIndexResponse withdrawData;

    @Override
    protected void initView() {
        mPresenter = new WithdrawPresenter(this);
        bts_withdraw.setOnClickListener(this);
        rl_select_bankcard.setOnClickListener(this);


        et_money.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                final CharSequence c = charSequence;
                //消除小数点后超过两位的字符​
                if (charSequence.toString().contains(".")) {
                    if (charSequence.length() - 1 - charSequence.toString().indexOf(".") > 2) {
                        charSequence = charSequence.toString().subSequence(0,
                                charSequence.toString().indexOf(".") + 3);
                        et_money.setText(charSequence);
                        et_money.setSelection(et_money.getText().toString().length());
                    }
                }
                //输入的第一个字符为小数点时，自动在小数点前面补一个零
                if (charSequence.toString().trim().substring(0).equals(".")) {
                    charSequence = "0" + charSequence;
                    et_money.setText(charSequence);
                    et_money.setSelection(2);
                }
                //如果输入的第一个和第二个字符都为0，则消除第1个0
                if (charSequence.toString().startsWith("0")
                        && charSequence.toString().trim().length() > 1) {
                    if (!charSequence.toString().substring(1, 2).equals(".")) {
                        et_money.setText(charSequence.subSequence(1, 2));
                        et_money.setSelection(1);
                        return;
                    }
                }
                //输入金额过大
                if (charSequence.length() != 0) {
                    if (new BigDecimal(charSequence.toString()).doubleValue() > withdrawData.getWallet_info().getMoney()) {
                        //charSequence = charSequence.subSequence(0, charSequence.length() - 1);
                        et_money.setText(withdrawData.getWallet_info().getMoney()+"");
                        et_money.setSelection(et_money.getText().toString().length());

                    }
                }

//                if (c.length() > 0) {
//                    et_money.setTextSize(25);
//
//                    Double amount = Double.parseDouble(et_money.getText().toString().trim());
//                    if (amount >= 0) {
//
//                    }
//                } else {
//                    et_money.setTextSize(14);
//
//                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public void initData() {
        mPresenter.getWithdrawIndex();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_select_bankcard :
                DialogHelper.showSelectBankcardDialog(baseActivity, withdrawData.getBankcard_lists(), new DialogHelper.DialogOnclickSelectCallback() {
                    @Override
                    public void onButtonClick(Dialog dialog, int position) {
                        if (position == -1) {
                            Intent addIntent = new Intent(baseActivity, AddBankCardActivity.class);
                            addIntent.putExtra("showType", 0);
                            startActivity(addIntent);
                        } else {
                            mBankcardId = withdrawData.getBankcard_lists().get(position).getBankcard_id();
                            String cardNo = withdrawData.getBankcard_lists().get(position).getCard_no();
                            tv_bankcard.setText(withdrawData.getBankcard_lists().get(position).getBank_name() + "(" + cardNo.substring(cardNo.length() - 4, cardNo.length()) + ")");
                        }
                    }
                });
                break;
            case R.id.bts_withdraw :

                if (checkInput(et_money.getText().toString().trim())) {
                    DialogHelper.showPayPasswordDialog(baseActivity,"请输入支付密码", null, new DialogHelper.DialogOnclickTextCallback() {
                        @Override
                        public void onButtonClick(Dialog dialog, String text) {
                            mPresenter.withdrawApply(Double.parseDouble(et_money.getText().toString().trim()), mBankcardId, text);
                        }
                    });
                }
                break;

            default:
                break;
        }
    }


    public boolean checkInput(String inputMoney) {
        if (TextUtils.isEmpty(inputMoney)) {
            toast("请输入提现金额");
            return false;
        } else {
            if (Double.parseDouble(inputMoney) < Double.parseDouble("100")) {
                toast("提现金额必须大于100");
                return false;
            } else {
                if (Double.parseDouble(inputMoney) > withdrawData.getWallet_info().getMoney()) {
                    toast("账户所剩余额不足本次提现");
                    return false;
                }
            }

        }
        return true;
    }


    @Override
    public void getWithdrawSuccessed(WithdrawIndexResponse data) {
        if(data!=null){

            withdrawData = data;

            if(data.getBankcard_lists() != null && data.getBankcard_lists().size()>0){

                String cardNo = data.getBankcard_lists().get(0).getCard_no();
                if (cardNo.length() < 5) {
                    tv_bankcard.setText(data.getBankcard_lists().get(0).getBank_name() + "(" + cardNo + ")");
                } else {
                    tv_bankcard.setText(data.getBankcard_lists().get(0).getBank_name() + "(" + cardNo.substring(cardNo.length() - 4, cardNo.length()) + ")");
                }
                mBankcardId = data.getBankcard_lists().get(0).getBankcard_id();

            }else{
                DialogHelper.show2btnDialog(baseActivity, "您尚未添加银行卡，马上去添加 ？", "取消", "添加银行卡", false, new DialogHelper.DialogOnclickCallback() {
                    @Override
                    public void onButtonClick(Dialog dialog) {
                        finish();
                    }
                }, new DialogHelper.DialogOnclickCallback() {
                    @Override
                    public void onButtonClick(Dialog dialog) {
                        startActivityForResult(new Intent(baseActivity, AddBankCardActivity.class), 0);
                    }
                }).setCancelable(false);
            }

            addListBalance(data);
        }else{
            finish();
        }
    }

    @Override
    public void withdrawSuccessed() {
        toast("提现成功");
        setResult(RESULT_OK);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RESULT_OK){
            mPresenter.getWithdrawIndex();
        }
    }


    private void addListBalance(final WithdrawIndexResponse data){
        ll_drawout_info_list.removeAllViews();
        /**
         * title : 可提现余额
         * explain : 全部提现
         * money : 3234.84
         * flag_withdraw : 1
         * remark : []
         */
        if (data.getWallet_balance() != null && data.getWallet_balance().size() > 0) {
            for(int i = 0; i< data.getWallet_balance().size(); i++){
                //一整行的图片布局
                View viewItem = LayoutInflater.from(baseActivity).inflate(R.layout.item_withdraw, null);
                TextView tv_1 = (TextView) viewItem.findViewById(R.id.tv_1);
                TextView tv_2 = (TextView) viewItem.findViewById(R.id.tv_2);
                TextView tv_3 = (TextView) viewItem.findViewById(R.id.tv_3);
                tv_1.setText(data.getWallet_balance().get(i).getTitle());
                tv_2.setText("￥" + data.getWallet_balance().get(i).getMoney());
                tv_3.setText(data.getWallet_balance().get(i).getExplain());
                if (data.getWallet_balance().get(i).getFlag_withdraw() == 0 && data.getWallet_balance().get(i).getRemark() != null
                        && data.getWallet_balance().get(i).getRemark().size() > 0) {

                    tv_3.setTag(data.getWallet_balance().get(i));
                    tv_3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            WithdrawIndexResponse.WalletBalance tag = (WithdrawIndexResponse.WalletBalance) v.getTag();
                            String str = "";
                            for (int j = 0; j < tag.getRemark().size(); j++) {
                                str += (tag.getRemark().get(j) + "\n");
                            }

                            DialogHelper.showTipsDialog(baseActivity, str, "好的", null);
                        }
                    });
                }else if(data.getWallet_balance().get(i).getFlag_withdraw() == 1){
                    tv_3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (checkInput(withdrawData.getWallet_info().getMoney()+"")) {
                                et_money.setText(withdrawData.getWallet_info().getMoney()+"");
                            }
                        }
                    });
                }
                ll_drawout_info_list.addView(viewItem);
            }

        }

    }
}
