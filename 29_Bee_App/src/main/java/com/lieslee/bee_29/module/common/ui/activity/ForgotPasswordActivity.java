package com.lieslee.bee_29.module.common.ui.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.common.ShiHuiActivityManager;
import com.common.annotation.ActivityFragmentInject;
import com.common.base.ui.BaseActivity;
import com.common.base.ui.BaseView;
import com.lieslee.bee_29.R;
import com.lieslee.bee_29.application.BeeApplication;
import com.lieslee.bee_29.bean.common.SmsCodeTestResponse;
import com.lieslee.bee_29.module.common.persenter.ForgotPasswordPresenter;
import com.lieslee.bee_29.module.common.view.ForgotPasswordView;
import com.lieslee.bee_29.utils.UIHelper;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.Bind;

/**
 * Created by LiesLee on 2017/6/7.
 * Email: LiesLee@foxmail.com
 */
@ActivityFragmentInject(contentViewId = R.layout.act_forgot_password, toolbarTitle = R.string.forgot_password)
public class ForgotPasswordActivity extends BaseActivity<ForgotPasswordPresenter> implements ForgotPasswordView {


    @Bind(R.id.et_phone)
    EditText et_phone;
    @Bind(R.id.et_verification_code)
    EditText et_verification_code;
    @Bind(R.id.et_password)
    EditText et_password;
    @Bind(R.id.tv_get_verification_code)
    TextView tv_get_verification_code;
    @Bind(R.id.tv_finish)
    TextView tv_finish;

    private String phone;
    private String password;
    private String verification_code;
    /** 0忘记密码、1修改密码 */
    int type = 0;
    @Override
    protected void initView() {
        mPresenter = new ForgotPasswordPresenter(this);
        type = getIntent().getIntExtra("type", 0);
        if(type == 1){
            BeeApplication.getInstance().getUser().getUser().getUser_mobile();
            et_phone.setText(BeeApplication.getInstance().getUser().getUser().getUser_mobile());
            et_phone.setEnabled(false);
            tv_title.setText("修改密码");
        }



        tv_finish.setOnClickListener(this);
        tv_get_verification_code.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_get_verification_code:
                if(type == 0){
                    if(checkPhone()){
                        startTimerTask();
                        mPresenter.getSmsCode(phone, 2, type);
                    }

                }

                if(type == 1){
                    startTimerTask();
                    mPresenter.getSmsCode(BeeApplication.getInstance().getUser().getUser().getUser_mobile_encrypt(), 3, type);

                }

                break;
            case R.id.tv_finish:
                if(type == 0){
                    if(checkPhone()&&check()){
                        mPresenter.modifyPassword(type == 0, verification_code, type == 0 ? phone : BeeApplication.getInstance().getUser().getUser().getUser_mobile_encrypt(), password);
                    }
                }else{
                    if(check()){
                        mPresenter.modifyPassword(type == 0, verification_code, type == 0 ? phone : BeeApplication.getInstance().getUser().getUser().getUser_mobile_encrypt(), password);
                    }
                }

                break;

            default:
                break;
        }
    }


    boolean checkPhone() {
        phone = et_phone.getText().toString();
        if (TextUtils.isEmpty(phone)) {
            UIHelper.showShakeAnim(this, et_phone, "手机号码不能为空");
            et_phone.requestFocus();
            return false;
        } else if (!UIHelper.phoneNumberValid(phone)) {
            UIHelper.showShakeAnim(this, et_phone, "请输入正确手机号码");
            et_phone.requestFocus();
            return false;
        }
        return true;
    }

    boolean check() {
        phone = et_phone.getText().toString();
        password = et_password.getText().toString();
        verification_code = et_verification_code.getText().toString();
        if (TextUtils.isEmpty(phone)) {
            UIHelper.showShakeAnim(this, et_phone, "手机号码不能为空");
            et_phone.requestFocus();
            return false;
        } else if (!UIHelper.phoneNumberValid(phone) && type == 0) {
            UIHelper.showShakeAnim(this, et_phone, "请输入正确手机号码");
            et_phone.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(password)
                || et_password.getText().toString().length() < 6 || et_password.getText().toString().length() > 14) {
            UIHelper.showShakeAnim(this, et_password, "请输入6到14位的密码");
            et_password.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(verification_code)) {
            UIHelper.showShakeAnim(this, et_verification_code, "请输入您收到的短信验证码");
            et_verification_code.requestFocus();
            return false;
        }
        return true;
    }

    private static final int TIME_LOW = 1;
    private static final int TOTAL_TIME = 60;// 验证码有效时间(单位:s)
    private int time = TOTAL_TIME;
    private Timer mTimer;
    private TimerTask mTask;
    private boolean hadExpired = false;


    private void startTimerTask() {
        mTimer = new Timer(true);
        mTask = new CodeTimerTask();
        mTimer.schedule(mTask, 0, 1000);// 延时0s后执行，1s执行一次
    }




    /**
     * 倒计时TimerTask
     **/
    private class CodeTimerTask extends TimerTask {
        @Override
        public void run() {
            Message message = new Message();
            message.what = TIME_LOW;
            handler.sendMessage(message);
        }
    }

    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case TIME_LOW:
                    if (time > TIME_LOW) {
                        updateTimeText();
                    } else {
                        cancelTimeText();
                    }
                    break;
                default:
                    break;
            }
        }

        ;
    };

    /**
     * 更新时间显示文本
     **/
    private void updateTimeText() {
        time--;
        tv_get_verification_code.setEnabled(false);
        tv_get_verification_code.setText(getFormatString(baseActivity, R.string.fetch_again, time));
    }

    /**
     * 取消文字显示文本设置为按钮可点击状态
     **/
    private void cancelTimeText() {
        time = TOTAL_TIME;
        tv_get_verification_code.setEnabled(true);
        tv_get_verification_code.setText("重新获取");
        mTimer.cancel();
        mTask.cancel();
        hadExpired = true;
    }

    /**
     * 根据传入的格式，获取对应格式化话的字符串
     *
     * @param context     上下文对象
     * @param formatResId 传入的格式resId
     * @param args        替换的操作列表
     * @return 格式化后的字符串
     */
    public static String getFormatString(Context context, int formatResId, Object... args) {
        String format = context.getString(formatResId);
        String result = String.format(format, args);
        return result;
    }

    @Override
    public void modifySuccess() {
        toast("修改成功, 请重新登录");
        ShiHuiActivityManager.getInstance().cleanActivity(this);
        startActivity(new Intent(baseActivity, LoginActivity.class));
        BeeApplication.getInstance().setUser(null);
        finish();
    }

    @Override
    public void getSmsCodeError() {
        cancelTimeText();
    }

    @Override
    public void testSmsCode(SmsCodeTestResponse data) {
        et_verification_code.setText(data.getSms_code());
    }
}
