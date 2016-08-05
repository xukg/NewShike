package com.shike.android.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.android.core.base.AbsBaseActivity;
import com.android.core.control.ToastUtil;
import com.shike.android.R;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by user on 16/8/5.
 */
public class AboutActivity extends AbsBaseActivity{

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_about;
    }

    @Override
    protected void onInitView(Bundle savedInstanceState) {
        addActionBar(mToolbar, "关于我们");
    }

    @Override
    protected void onInitData() {

    }

    @OnClick({R.id.rlCheckUpdate, R.id.rlAgreement})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rlCheckUpdate:
                ToastUtil.show("检查更新");
                break;
            case R.id.rlAgreement:
                openActivity(AgreementActivity.class);
                break;

        }
    }
}
