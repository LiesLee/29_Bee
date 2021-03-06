package com.lieslee.bee_29.module.common.ui.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.common.ShiHuiActivityManager;
import com.common.annotation.ActivityFragmentInject;
import com.common.base.ui.BaseActivity;
import com.common.base.ui.BaseView;
import com.lai.library.ButtonStyle;
import com.lieslee.bee_29.R;
import com.lieslee.bee_29.bean.common.User;
import com.lieslee.bee_29.module.common.persenter.LoginPresenter;
import com.lieslee.bee_29.module.common.view.UserView;
import com.lieslee.bee_29.utils.UIHelper;

import butterknife.Bind;

/**
 * Created by LiesLee on 17/6/7.
 */
@ActivityFragmentInject(contentViewId = R.layout.act_login)
public class LoginActivity extends BaseActivity<LoginPresenter> implements UserView {


    @Bind(R.id.et_phone)
    EditText et_phone;

    @Bind(R.id.et_pass)
    EditText et_pass;

    @Bind(R.id.bts_login)
    ButtonStyle bts_login;

    @Bind(R.id.tv_regist)
    TextView tv_regist;

    @Bind(R.id.tv_forget_pass)
    TextView tv_forget_pass;
    private String phone;
    private String password;

    @Override
    protected void initView() {
        mPresenter = new LoginPresenter(this);
        bts_login.setOnClickListener(this);
        tv_regist.setOnClickListener(this);
        tv_forget_pass.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.bts_login:
                if(check()){
                    mPresenter.login(phone, password);
                }

                break;

            case R.id.tv_regist:
                Intent intentRegist = new Intent(baseActivity, RegistActivity.class);
                startActivity(intentRegist);
                break;

            case R.id.tv_forget_pass:
                Intent intentFoget = new Intent(baseActivity, ForgotPasswordActivity.class);
                startActivity(intentFoget);
                break;
        }
    }


    boolean check() {
        phone = et_phone.getText().toString();
        password = et_pass.getText().toString();
        if (TextUtils.isEmpty(phone)) {
            UIHelper.showShakeAnim(this, et_phone, "手机号码不能为空");
            et_phone.requestFocus();
            return false;
        } else if (!UIHelper.phoneNumberValid(phone)) {
            UIHelper.showShakeAnim(this, et_phone, "请输入正确手机号码");
            et_phone.requestFocus();
            return false;
        }else if (TextUtils.isEmpty(password)
                || et_pass.getText().toString().length() < 6 || et_pass.getText().toString().length() > 14) {
            UIHelper.showShakeAnim(this, et_pass, "请输入6到14位的密码");
            et_pass.requestFocus();
            return false;
        }
        return true;
    }

    @Override
    public void getUserSuccess(User data) {
        toast("登录成功");
        ShiHuiActivityManager.getInstance().cleanActivity(this);
        startActivity(new Intent(baseActivity, MainActivity.class));
        finish();
    }
}
