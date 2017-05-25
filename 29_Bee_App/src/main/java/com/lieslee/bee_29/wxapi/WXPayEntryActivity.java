package com.lieslee.bee_29.wxapi;

import android.content.Intent;
import android.view.View;

import com.common.annotation.ActivityFragmentInject;
import com.common.base.ui.BaseActivity;
import com.lieslee.bee_29.R;
import com.tencent.mm.sdk.constants.ConstantsAPI;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

/**
 * Created by rrsh on 16/11/16.
 */

@ActivityFragmentInject(contentViewId = R.layout.act_test)
public class WXPayEntryActivity extends BaseActivity implements IWXAPIEventHandler {

    private IWXAPI api;

    @Override
    protected void initView() {

        api = WXAPIFactory.createWXAPI(this, getString(com.paysdk.R.string.weixin_appkey));
        api.handleIntent(getIntent(), this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        super.onNewIntent(intent);
        setIntent(intent);
        api.handleIntent(intent, this);
    }

    @Override
    public void onReq(BaseReq baseReq) {

    }

    @Override
    public void onResp(BaseResp baseResp) {
        if (baseResp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {
            switch (baseResp.errCode) {
                case 0:
                    toast("支付成功");
                    finish();
                    break;
                case -1:
                    toast("支付失败");
                    finish();
                    break;
                case -2:
                    toast("取消支付");
                    finish();
                    break;
            }
        }
    }
}
