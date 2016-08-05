package com.shike.android.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.android.core.base.AbsBaseActivity;
import com.shike.android.R;

import butterknife.Bind;

/**
 * Created by user on 16/8/5.
 */
public class MyIncomeActivity extends AbsBaseActivity{

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_my_income;
    }

    @Override
    protected void onInitView(Bundle savedInstanceState) {
        addActionBar(mToolbar, "我的收益");
    }

    @Override
    protected void onInitData() {

    }
}
