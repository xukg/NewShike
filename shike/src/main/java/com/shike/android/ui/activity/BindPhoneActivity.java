package com.shike.android.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.android.core.base.AbsBaseActivity;
import com.shike.android.R;

import butterknife.Bind;

/**
 * Created by user on 16/8/3.
 */
public class BindPhoneActivity extends AbsBaseActivity {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_bind_phone;
    }

    @Override
    protected void onInitView(Bundle savedInstanceState) {
        addActionBar(mToolbar, "绑定手机");
    }

    @Override
    protected void onInitData() {

    }
}
