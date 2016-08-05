package com.shike.android.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.android.core.adapter.MyPagerAdapter;
import com.android.core.base.AbsBaseActivity;
import com.shike.android.R;
import com.shike.android.ui.fragment.LoginByAccountFragment;
import com.shike.android.ui.fragment.LoginByVerificationCodeFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * 作者：joyo on 16/8/2 21:59
 * 邮箱：59296309@qq.com
 */
public class LoginActivity extends AbsBaseActivity {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.tablayout)
    TabLayout tabLayout;

    @Bind(R.id.viewpager)
    ViewPager viewPager;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_login;
    }

    @Override
    protected void onInitView(Bundle savedInstanceState) {
        addActionBar(mToolbar, "登录", false);

        List<Fragment> fragmetnList = new ArrayList<>();
        LoginByAccountFragment fragment0 = LoginByAccountFragment.newInstance();
        LoginByVerificationCodeFragment fragment1 = LoginByVerificationCodeFragment.newInstance();
        fragmetnList.add(fragment0);
        fragmetnList.add(fragment1);

        List<CharSequence> titleList = new ArrayList<>();
        titleList.add("账号登录");
        titleList.add("验证码登录");

        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(), fragmetnList, titleList);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected void onInitData() {

    }
}
