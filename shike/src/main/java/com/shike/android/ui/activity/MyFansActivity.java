package com.shike.android.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.android.core.base.AbsBaseActivity;
import com.android.core.control.Glides;
import com.shike.android.R;

import butterknife.Bind;

/**
 * 作者：joyo on 16/8/6 10:25
 * 邮箱：59296309@qq.com
 */
public class MyFansActivity extends AbsBaseActivity{

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.ivAvatar)
    ImageView ivAvatar;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_my_attention;
    }

    @Override
    protected void onInitView(Bundle savedInstanceState) {
        addActionBar(mToolbar, "我的粉丝");
        Glides.getInstance().loadCircle(getApplicationContext(), R.drawable.app_logo, ivAvatar);
    }

    @Override
    protected void onInitData() {

    }
}
