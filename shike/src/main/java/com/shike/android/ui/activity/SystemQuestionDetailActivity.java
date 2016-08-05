package com.shike.android.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.android.core.base.AbsBaseActivity;
import com.shike.android.R;

import butterknife.Bind;

/**
 * Created by user on 16/8/5.
 */
public class SystemQuestionDetailActivity extends AbsBaseActivity{

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_system_question_detail;
    }

    @Override
    protected void onInitView(Bundle savedInstanceState) {
        addActionBar(mToolbar, "问题详情");
    }

    @Override
    protected void onInitData() {

    }
}
