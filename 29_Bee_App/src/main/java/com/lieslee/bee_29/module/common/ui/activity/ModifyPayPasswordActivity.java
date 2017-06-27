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
import com.lieslee.bee_29.R;
import com.lieslee.bee_29.application.BeeApplication;
import com.lieslee.bee_29.bean.common.SmsCodeTestResponse;
import com.lieslee.bee_29.module.common.persenter.ModifyPayPasswordPresenter;
import com.lieslee.bee_29.module.common.view.ForgotPasswordView;
import com.lieslee.bee_29.utils.UIHelper;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.Bind;

/**
 * Created by LiesLee on 2017/6/7.
 * Email: LiesLee@foxmail.com
 */
@ActivityFragmentInject(contentViewId = R.layout.act_pay_password, toolbarTitle = R.string.pay_password)
public class ModifyPayPasswordActivity extends BaseActivity<ModifyPayPasswordPresenter> implements ForgotPasswordView {

    @Bind(R.id.et_phone)
    EditText et_phone;
    @Bind(R.id.et_verification_code)
    EditText et_verification_code;
    @Bind(R.id.tv_get_verification_code)
    TextView tv_get_verification_code;
    @Bind(R.id.tv_finish)
    TextView tv_finish;
    @Bind(R.id.et_new_pass)
    EditText et_new_pass;
    private String phone;
    private String verification_code;
    private String newPass;

    @Override
    protected void initView() {
        mPresenter = new ModifyPayPasswordPresenter(this);
        tv_finish.setOnClickListener(this);
        tv_get_verification_code.setOnClickListener(this);
        et_phone.setEnabled(false);

        et_phone.setText(BeeApplication.getInstance().getUser().getUser().getUser_mobile());
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_get_verification_code:
                startTimerTask();
                mPresenter.getSmsCode(BeeApplication.getInstance().getUser().getUser().getUser_mobile_encrypt(), 4, 1);
                break;
            case R.id.tv_finish:
                if(check()){
                    mPresenter.modifyPayPassword(verification_code, BeeApplication.getInstance().getUser().getUser().getUser_mobile_encrypt(), newPass);
                }
                break;

            default:
                break;
        }
    }



    boolean check() {
        phone = et_phone.getText().toString();
        newPass = et_new_pass.getText().toString();
        verification_code = et_verification_code.getText().toString();
        if (TextUtils.isEmpty(verification_code)) {
            UIHelper.showShakeAnim(this, et_verification_code, "请输入您收到的短信验证码");
            et_verification_code.requestFocus();
            return false;
        }else if (TextUtils.isEmpty(newPass)
                || et_new_pass.getText().toString().length() < 6 || et_new_pass.getText().toString().length() > 14) {
            UIHelper.showShakeAnim(this, et_new_pass, "请输入6位的支付密码");
            et_new_pass.requestFocus();
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
        toast("修改成功");
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
