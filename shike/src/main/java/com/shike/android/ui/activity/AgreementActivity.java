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
public class AgreementActivity extends AbsBaseActivity {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_agreement;
    }

    @Override
    protected void onInitView(Bundle savedInstanceState) {
        addActionBar(mToolbar, "用户协议");
    }

    @Override
    protected void onInitData() {

    }
}
