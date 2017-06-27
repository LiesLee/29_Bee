package com.lieslee.bee_29.module.home.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.common.annotation.ActivityFragmentInject;
import com.common.base.ui.BaseActivity;
import com.common.base.ui.BaseView;
import com.lieslee.bee_29.R;
import com.lieslee.bee_29.bean.common.CommonInfoResponse;
import com.lieslee.bee_29.module.common.persenter.InfoPresenter;
import com.lieslee.bee_29.module.common.view.InfoView;
import com.views.ProgressWebView;
import com.views.ProgressWheel;
import com.views.util.ViewUtil;

import butterknife.Bind;

/**
 * Created by LiesLee on 17/6/7.
 */
@ActivityFragmentInject(contentViewId = R.layout.act_content)
public class ContentActivity extends BaseActivity<InfoPresenter> implements InfoView {
    @Bind(R.id.webview)
    ProgressWebView webview;
    @Bind(R.id.pw_loding)
    ProgressWheel pw_loding;

    /** 5-关于29蜜蜂 6-联系我们 */
    private int type;


    @Override
    public void onClick(View v) {

    }


    @Override
    public void initData() {
        mPresenter.getInfo(type);
    }

    @Override
    protected void initView() {
        mPresenter = new InfoPresenter(this);
        type = getIntent().getIntExtra("type", 0);
        switch (type) {
            case 5 :
                tv_title.setText("关于" + getString(R.string.app_name));
                break;

            case 6 :
                tv_title.setText("联系我们");
                break;

            default:
                tv_title.setText("详情");
                break;
        }


        //圈圈进度条
        pw_loding.setBarWidth(ViewUtil.dp2px(baseActivity, 5));
        pw_loding.setBarColor(Color.parseColor("#eaa52a"));
        pw_loding.spin();
        webview.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webview.setHorizontalScrollbarOverlay(true);
        webview.setHorizontalScrollBarEnabled(true);
        webview.requestFocus();
        webview.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        webview.getSettings().setDefaultTextEncodingName("utf-8");
        webview.setWebChromeClient(new WebChromeClient());
        if (webview.getSettings() != null) {
            webview.getSettings().setJavaScriptEnabled(true);
        }
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (TextUtils.isEmpty(url)) return true;

                if (url.startsWith("tel:")) {
                    Intent intent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse(url));
                    startActivity(intent);
                } else {
                    view.loadUrl(url);
                }
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

            }


        });


    }


    public class WebChromeClient extends android.webkit.WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            if (newProgress == 100) {
                webview.progressbar.setVisibility(View.GONE);

                if(pw_loding.getVisibility() == View.VISIBLE) {
                    pw_loding.startAnimation(AnimationUtils.loadAnimation(baseActivity, R.anim.activity_close));
                    pw_loding.setVisibility(View.GONE);
                }
            } else {
                if (pw_loding.getVisibility() == View.GONE){
                    pw_loding.startAnimation(AnimationUtils.loadAnimation(baseActivity, R.anim.activity_open));
                    pw_loding.setVisibility(View.VISIBLE);
                }
                if (webview.progressbar.getVisibility() == View.GONE)
                    webview.progressbar.setVisibility(View.VISIBLE);
                webview.progressbar.setProgress(newProgress);
            }
            super.onProgressChanged(view, newProgress);
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
        }
    }



    @Override
    public void getInfoSuccess(CommonInfoResponse data) {
        webview.loadDataWithBaseURL(null,data.getInfo_data().getHtml(), "text/html", "utf-8",null);
    }
}
