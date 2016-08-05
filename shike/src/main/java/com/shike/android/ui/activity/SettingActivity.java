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
public class SettingActivity extends AbsBaseActivity {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_setting;
    }

    @Override
    protected void onInitView(Bundle savedInstanceState) {
        addActionBar(mToolbar, "设置");
    }

    @Override
    protected void onInitData() {

    }

    @OnClick({R.id.rlFeedback, R.id.rlQuestion, R.id.rlCleanCache, R.id.rlAbout, R.id.rlLogout})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rlFeedback:
                openActivity(FeedbackActivity.class);
                break;
            case R.id.rlQuestion:
                openActivity(SystemQuestionActivity.class);
                break;
            case R.id.rlCleanCache:
                ToastUtil.show("清除缓存");
                break;
            case R.id.rlAbout:
                openActivity(AboutActivity.class);
                break;
            case R.id.rlLogout:
                ToastUtil.show("退出登录");
                break;

        }
    }
}
