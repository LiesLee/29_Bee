package com.lieslee.bee_29.module.home.ui.activity;

import android.app.Dialog;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.common.annotation.ActivityFragmentInject;
import com.common.base.ui.BaseActivity;
import com.lieslee.bee_29.R;
import com.lieslee.bee_29.bean.home.Bankcard;
import com.lieslee.bee_29.bean.home.BankcardListResponse;
import com.lieslee.bee_29.module.home.presenter.AddBankCardPresenter;
import com.lieslee.bee_29.module.home.view.AddBankCardView;
import com.lieslee.bee_29.utils.DialogHelper;
import com.lieslee.bee_29.utils.UIHelper;

import java.util.List;

import butterknife.Bind;

/**
 * Created by LiesLee on 16/11/3.
 */
@ActivityFragmentInject(contentViewId = R.layout.act_add_bank_card,
        toolbarTitle = R.string.add_bank_card)
public class AddBankCardActivity extends BaseActivity<AddBankCardPresenter> implements AddBankCardView {
    @Bind(R.id.et_name)
    EditText et_name;
    @Bind(R.id.et_card_number)
    EditText et_card_number;
    @Bind(R.id.et_bank_info)
    EditText et_bank_info;
    @Bind(R.id.et_phone)
    EditText et_phone;
    @Bind(R.id.tv_card_type)
    TextView tv_card_type;
    @Bind(R.id.tv_add)
    TextView tv_add;
    @Bind(R.id.ll_instructions)
    LinearLayout ll_instructions;

    private List<BankcardListResponse.BankType> banktype_lists;
    private String bank_id;
    private String name;
    private String cardNumber;
    private String bankInfo;
    private String phone;
    /**
     * 0添加  1信息  2提现中添加
     */
    int showType = -1;
    Bankcard bankcard;

    @Override
    protected void initView() {
        showType = getIntent().getIntExtra("showType", -1);
        if (showType == -1) {
            toast("显示类型为不对: -1");
            finish();
            return;
        }

        banktype_lists = (List<BankcardListResponse.BankType>) getIntent().getSerializableExtra("type_list");

        mPresenter = new AddBankCardPresenter(this);
        //mPresenter.getTypeList();
        tv_card_type.setOnClickListener(this);
        tv_add.setOnClickListener(this);

        if (showType == 0 || showType == 2) {
            setTitleString("添加银行卡");
            tv_add.setBackgroundResource(R.drawable.sele_btn_golden_white_5dp);
            ll_instructions.setVisibility(View.VISIBLE);
        } else if (showType == 1) {
            setTitleString("银行卡信息");
            bankcard = (Bankcard) getIntent().getSerializableExtra("bankcard");
            et_name.setEnabled(false);
            et_card_number.setEnabled(false);
            et_bank_info.setEnabled(false);
            et_phone.setEnabled(false);
            tv_card_type.setEnabled(false);
            tv_add.setText("删除");
            ll_instructions.setVisibility(View.GONE);
            tv_add.setBackgroundResource(R.drawable.sele_btn_red_white_5dp);

            if (bankcard == null) {
                toast("银行卡空");
                finish();
                return;
            }

            et_name.setText(bankcard.getCard_user());
            et_phone.setText(bankcard.getCard_mobile());
            et_card_number.setText(bankcard.getCard_no());
            et_bank_info.setText(bankcard.getBank_region());
            tv_card_type.setText(bankcard.getBank_name());
        }
    }

    @Override
    public void initData() {

    }

    public boolean check() {
        name = et_name.getText().toString();
        cardNumber = et_card_number.getText().toString();
        bankInfo = et_bank_info.getText().toString();
        phone = et_phone.getText().toString();
        if (TextUtils.isEmpty(name)) {
            UIHelper.showShakeAnim(baseActivity, et_name, "请输入您的银行卡开户名");
            return false;
        } else if (TextUtils.isEmpty(cardNumber)) {
            UIHelper.showShakeAnim(baseActivity, et_card_number, "请输入您的银行卡号");
            return false;
        } else if (TextUtils.isEmpty(bankInfo)) {
            UIHelper.showShakeAnim(baseActivity, et_bank_info, "请输入您的开户行信息");
            return false;
        } else if (TextUtils.isEmpty(phone)) {
            UIHelper.showShakeAnim(baseActivity, et_phone, "请输入您的银行预留电话");
            return false;
        } else if (TextUtils.isEmpty(bank_id)) {
            UIHelper.showShakeAnim(baseActivity, tv_card_type, "请点击选择您的银行卡类型");
            return false;
        }
        return true;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_card_type:
                showBankType();
                break;

            case R.id.tv_add:
                if (showType == 0 || showType == 2) {
                    if (check()) {
                        mPresenter.addCard(name, cardNumber, bank_id, bankInfo , phone);
                    }
                } else {
                    if (bankcard == null) break;
                    mPresenter.delete(bankcard.getBankcard_id());
                }
                break;

            default:
                break;
        }
    }

    public void showBankType() {
        if (banktype_lists != null && banktype_lists.size() > 0) {
            String[] bankNames = new String[banktype_lists.size()];
            for (int i = 0; i < banktype_lists.size(); i++) {
                bankNames[i] = banktype_lists.get(i).getBank_name();
            }

            DialogHelper.showPickBankDialog(baseActivity, bankNames, null, new DialogHelper.DialogOnclickSelectCallback() {
                @Override
                public void onButtonClick(Dialog dialog, int position) {
                    tv_card_type.setText(banktype_lists.get(position).getBank_name());
                    bank_id = banktype_lists.get(position).getBank_id();
                }
            });
        }
    }

    @Override
    public void addBankCardGone() {
        setResult(RESULT_OK);
        toast("添加成功");
        finish();

    }


    @Override
    public void deleteBankCardGone() {
        setResult(RESULT_OK);
        toast("删除成功");
        finish();
    }

}

