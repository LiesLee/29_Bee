package com.lieslee.bee_29.utils;

import android.app.Dialog;
import android.graphics.Color;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.text.TextUtils;
import android.transition.TransitionSet;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.common.base.ui.BaseActivity;
import com.lieslee.bee_29.R;
import com.lieslee.bee_29.bean.home.Bankcard;
import com.lieslee.bee_29.bean.labour.OrderComfirmResponse;
import com.views.wheel.adapters.ArrayWheelAdapter;
import com.views.wheel.widget.OnWheelChangedListener;
import com.views.wheel.widget.WheelView;

import java.util.List;

/**
 * Created by LiesLee on 16/10/31.
 */
public class DialogHelper {
    public interface DialogOnclickCallback {
        void onButtonClick(Dialog dialog);
    }

    public interface DialogOnclickSelectCallback {
        void onButtonClick(Dialog dialog, int position);
    }

    public interface DialogOnclickTextCallback {
        void onButtonClick(Dialog dialog, String text);
    }

    /**
     * 提示小弹窗
     *
     * @param context
     * @param callback
     * @return
     */
    public static Dialog showTipsDialog(BaseActivity context, String tips, String btnText, final DialogOnclickCallback callback) {

        final Dialog dialog = new Dialog(context, R.style.custom_dialog);
        dialog.setContentView(R.layout.dialog_tips);
        TextView tv_tips = (TextView) dialog.findViewById(R.id.tv_tips);
        TextView tv_ok = (TextView) dialog.findViewById(R.id.tv_ok);

        tv_tips.setText(tips);
        tv_ok.setText(btnText);
        dialog.setCanceledOnTouchOutside(false);
        tv_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callback != null) {
                    callback.onButtonClick(dialog);
                }
                dialog.dismiss();
            }
        });

        Window dialogWindow = dialog.getWindow();
        WindowManager m = context.getWindowManager();
        Display d = m.getDefaultDisplay();
        WindowManager.LayoutParams p = dialogWindow.getAttributes();
        //p.height = (int) (d.getHeight()*0.6);
        p.width = (int) (d.getWidth() * 0.80);
        dialogWindow.setAttributes(p);

        if (!dialog.isShowing()) {
            dialog.show();
        }
        return dialog;
    }

    /**
     * 显示两个按钮的dialog
     *
     * @param context
     * @param tips
     * @param leftText
     * @param rightText
     * @param isLeftColor   是否是右边的文字有颜色,别的灰色(通常右手习惯,确认键在右边)
     * @param leftCallback
     * @param rightCallback
     * @return
     */
    public static Dialog show2btnDialog(BaseActivity context, String tips, String leftText, String rightText, boolean isLeftColor,
                                        final DialogOnclickCallback leftCallback, final DialogOnclickCallback rightCallback) {

        final Dialog dialog = new Dialog(context, R.style.custom_dialog);
        dialog.setContentView(R.layout.dialog_2_button);
        TextView tv_tips = (TextView) dialog.findViewById(R.id.tv_tips);
        TextView tv_left = (TextView) dialog.findViewById(R.id.tv_left);
        TextView tv_right = (TextView) dialog.findViewById(R.id.tv_right);
        tv_tips.setText(tips);
        tv_left.setText(leftText);
        tv_right.setText(rightText);
        tv_left.setTextColor(isLeftColor ? context.getResources().getColor(R.color.colorPrimary) : context.getResources().getColor(R.color.text_grey_light));
        tv_right.setTextColor(isLeftColor ? context.getResources().getColor(R.color.text_grey_light) : context.getResources().getColor(R.color.colorPrimary));
        dialog.setCanceledOnTouchOutside(false);
        tv_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (leftCallback != null) {
                    leftCallback.onButtonClick(dialog);
                }
                dialog.dismiss();
            }
        });

        tv_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rightCallback.onButtonClick(dialog);
                dialog.dismiss();
            }
        });

        Window dialogWindow = dialog.getWindow();
        WindowManager m = context.getWindowManager();
        Display d = m.getDefaultDisplay();
        WindowManager.LayoutParams p = dialogWindow.getAttributes();
        //p.height = (int) (d.getHeight()*0.6);
        p.width = (int) (d.getWidth() * 0.80);
        dialogWindow.setAttributes(p);

        if (!dialog.isShowing()) {
            dialog.show();
        }
        return dialog;
    }


    /**
     * 选择银行卡dialog
     *
     * @param context
     * @param leftCallback
     * @param rightCallback
     * @return
     */
    public static Dialog showPickBankDialog(final BaseActivity context, String[] list, final DialogOnclickCallback leftCallback, final DialogOnclickSelectCallback rightCallback) {

        final Dialog dialog = new Dialog(context, R.style.custom_dialog);
        dialog.setContentView(R.layout.dialog_pick_bank);
        TextView tv_left = (TextView) dialog.findViewById(R.id.tv_left);
        TextView tv_right = (TextView) dialog.findViewById(R.id.tv_right);
        final WheelView wheel = (WheelView) dialog.findViewById(R.id.dialog_wheelview);
        dialog.setCanceledOnTouchOutside(false);


        ArrayWheelAdapter<String> adapter = new ArrayWheelAdapter<String>(context, list);

        final float defSize = adapter.getTextSize();
        final float selectedSize = defSize + 3;
        adapter.setTextColor(context.getResources().getColor(R.color.golden));
        wheel.setViewAdapter(adapter);
        wheel.setWheelBackground(R.color.transparent);
        wheel.setWheelForeground(R.color.transparent);
        wheel.setVisibleItems(3);
        wheel.addChangingListener(new OnWheelChangedListener() {

            @Override
            public void onChanged(WheelView wheel, int oldValue, int newValue) {
                LinearLayout itemsView = wheel.getItems();
                if (itemsView != null) {
                    for (int i = 0; i < itemsView.getChildCount(); i++) {
                        TextView tv = (TextView) itemsView.getChildAt(i);
                        if (i == (newValue - wheel.getFristItemIndex())) { //设置选中的样式
                            tv.getPaint().setFakeBoldText(true);
                            tv.setTextColor(context.getResources().getColor(R.color.golden));
                            tv.setTextSize(selectedSize);
                        } else {   //还原样式
                            tv.getPaint().setFakeBoldText(false);
                            tv.setTextColor(context.getResources().getColor(R.color.grey));
                            tv.setTextSize(defSize);
                        }
                    }

                }
            }
        });
        //选中
        wheel.setCurrentItem(list.length > 1 ? 1 : 0);
        tv_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (leftCallback != null) {
                    leftCallback.onButtonClick(dialog);
                }
                dialog.dismiss();
            }
        });

        tv_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rightCallback.onButtonClick(dialog, wheel.getCurrentItem());
                dialog.dismiss();
            }
        });

        Window dialogWindow = dialog.getWindow();
        WindowManager m = context.getWindowManager();
        Display d = m.getDefaultDisplay();
        WindowManager.LayoutParams p = dialogWindow.getAttributes();
        //p.height = (int) (d.getHeight()*0.6);
        p.width = (int) (d.getWidth() * 0.85);
        dialogWindow.setAttributes(p);
        if (!dialog.isShowing()) {
            dialog.show();
        }
        return dialog;
    }

    /**
     * 选择银行卡 dialog
     *
     * @param context
     * @param callback
     * @return
     */
    public static Dialog showSelectBankcardDialog(BaseActivity context, List<Bankcard> bankcards, final DialogOnclickSelectCallback callback) {

        final Dialog dialog = new Dialog(context, R.style.custom_dialog);
        dialog.setContentView(R.layout.dialog_select_bankcard);

        ImageView exit = (ImageView) dialog.findViewById(R.id.exit);
        LinearLayout use_new = (LinearLayout) dialog.findViewById(R.id.ll_use_new);
        LinearLayout ll_add_view = (LinearLayout) dialog.findViewById(R.id.ll_add_view);

        /**
         * 银行卡 item
         * */
        for (int i = 0; i < bankcards.size(); i++) {
            LinearLayout ll_bankcard = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.view_select_bankcard_item, null);
            TextView tv_bank = (TextView) ll_bankcard.findViewById(R.id.tv_bank);
            String cardNo = bankcards.get(i).getCard_no();
            tv_bank.setText(bankcards.get(i).getBank_name() + "(" + cardNo.substring(cardNo.length() - 4, cardNo.length()) + ")");
            final int finalI = i;
            ll_bankcard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callback.onButtonClick(dialog, finalI);
                    dialog.dismiss();
                }
            });


            ll_add_view.addView(ll_bankcard);
        }


        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        use_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onButtonClick(dialog, -1);
                dialog.dismiss();
            }
        });


        dialog.setCanceledOnTouchOutside(false);
        Window dialogWindow = dialog.getWindow();
        WindowManager m = context.getWindowManager();
        Display d = m.getDefaultDisplay();
        WindowManager.LayoutParams p = dialogWindow.getAttributes();
        //p.height = (int) (d.getHeight()*0.6);
        p.width = (int) (d.getWidth() * 0.80);
        dialogWindow.setAttributes(p);

        if (!dialog.isShowing()) {
            dialog.show();
        }
        return dialog;
    }




    /**
     * 支付密码dialog
     *
     * @param context
     * @param leftCallback
     * @param rightCallback
     * @return
     */
    public static Dialog showPayPasswordDialog(final BaseActivity context, String tips, final DialogOnclickTextCallback leftCallback, final DialogOnclickTextCallback rightCallback) {

        final Dialog dialog = new Dialog(context, R.style.custom_dialog);
        dialog.setContentView(R.layout.dialog_withdraw_password);
        TextView tv_left = (TextView) dialog.findViewById(R.id.tv_left);
        TextView tv_right = (TextView) dialog.findViewById(R.id.tv_right);
        TextView tv_tips = (TextView) dialog.findViewById(R.id.tv_tips);
        final TextView et_new_pass = (EditText) dialog.findViewById(R.id.et_new_pass);
        tv_tips.setText(tips);
        dialog.setCanceledOnTouchOutside(false);
        tv_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (leftCallback != null) {
                    leftCallback.onButtonClick(dialog, null);
                }
                dialog.dismiss();
            }
        });

        tv_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(et_new_pass.getText().toString().trim()) || et_new_pass.getText().toString().trim().length() != 6) {
                    context.toast("请规范输入六位数密码");
                } else {
                    rightCallback.onButtonClick(dialog, et_new_pass.getText().toString().trim());
                    dialog.dismiss();
                }

            }
        });

        Window dialogWindow = dialog.getWindow();
        WindowManager m = context.getWindowManager();
        Display d = m.getDefaultDisplay();
        WindowManager.LayoutParams p = dialogWindow.getAttributes();
        //p.height = (int) (d.getHeight()*0.6);
        p.width = (int) (d.getWidth() * 0.80);
        dialogWindow.setAttributes(p);
        if (!dialog.isShowing()) {
            dialog.show();
        }
        return dialog;
    }



    /**
     * 支付弹窗
     *
     * @param context
     * @param count
     * @param dialogOnclickSelectCallback
     * @return
     */
    public static Dialog showPayTypeDialog(BaseActivity context, double count,List<OrderComfirmResponse.PayType> payTypes,
                                           final DialogOnclickCallback dialogOnclickCallback, final DialogOnclickSelectCallback dialogOnclickSelectCallback) {
        final Dialog dialog = new Dialog(context, R.style.custom_dialog);
        dialog.setContentView(R.layout.pop_choose_pay_type);
        TextView tv_count = (TextView) dialog.findViewById(R.id.tv_count);
        TextView tv_ok = (TextView) dialog.findViewById(R.id.tv_ok);
        RelativeLayout rl_weixin_type = (RelativeLayout) dialog.findViewById(R.id.rl_weixin_type);
        RelativeLayout rl_alipay_type = (RelativeLayout) dialog.findViewById(R.id.rl_alipay_type);
        RelativeLayout rl_balance_type = (RelativeLayout) dialog.findViewById(R.id.rl_balance_type);
        final View v_weixin_type = dialog.findViewById(R.id.v_weixin_type);
        final View v_alipay_type = dialog.findViewById(R.id.v_alipay_type);
        final View v_bank_type = dialog.findViewById(R.id.v_bank_type);
        if (count % 1 == 0) {
            int discount = (int) count;
            tv_count.setText("" + discount);
        } else {
            tv_count.setText("" + count);
        }

        final int[] payType = new int[1];

        v_weixin_type.setSelected(true);
        rl_weixin_type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                payType[0] = 1;
                v_weixin_type.setSelected(true);
                v_alipay_type.setSelected(false);
                v_bank_type.setSelected(false);
            }
        });
        rl_alipay_type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                payType[0] = 2;
                v_weixin_type.setSelected(false);
                v_bank_type.setSelected(false);
                v_alipay_type.setSelected(true);
            }
        });
        rl_balance_type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                payType[0] = 4;
                v_weixin_type.setSelected(false);
                v_bank_type.setSelected(true);
                v_alipay_type.setSelected(false);
            }
        });

        tv_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dialogOnclickSelectCallback != null) {
                    dialogOnclickSelectCallback.onButtonClick(dialog, payType[0]);
                }
                dialog.dismiss();
            }
        });

        dialog.findViewById(R.id.iv_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dialogOnclickCallback != null) {
                    dialogOnclickCallback.onButtonClick(dialog);
                }
                dialog.dismiss();
            }
        });

        rl_alipay_type.setVisibility(View.GONE);
        rl_balance_type.setVisibility(View.GONE);
        rl_weixin_type.setVisibility(View.GONE);

        for(OrderComfirmResponse.PayType type : payTypes){
            if(type.getPay_id() == 1){
                rl_weixin_type.setVisibility(View.VISIBLE);
            }
            if(type.getPay_id() == 2){
                rl_alipay_type.setVisibility(View.VISIBLE);
            }
            if(type.getPay_id() == 4){
                rl_balance_type.setVisibility(View.VISIBLE);
            }
        }

        Window dialogWindow = dialog.getWindow();
        dialogWindow.setGravity(Gravity.BOTTOM);
        WindowManager m = context.getWindowManager();
        Display d = m.getDefaultDisplay();
        WindowManager.LayoutParams p = dialogWindow.getAttributes();
        //p.height = (int) (d.getHeight()*0.6);
        p.width = (int) (d.getWidth() * 1);
        dialogWindow.setAttributes(p);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        return dialog;
    }



}
