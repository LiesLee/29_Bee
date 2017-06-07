package com.lieslee.bee_29.utils;

import android.app.Dialog;
import android.graphics.Color;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.transition.TransitionSet;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.common.base.ui.BaseActivity;
import com.lieslee.bee_29.R;
import com.views.wheel.adapters.ArrayWheelAdapter;
import com.views.wheel.widget.OnWheelChangedListener;
import com.views.wheel.widget.WheelView;

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


}
