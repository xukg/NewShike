package com.shike.android.ui.fragment;

import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.android.core.base.AbsBaseFragment;
import com.shike.android.R;

import butterknife.Bind;

/**
 * Created by user on 16/8/3.
 */
public class HomeFragment extends AbsBaseFragment {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.toolbarTitle)
    TextView toolbarTitle;


    public static HomeFragment newInstance() {
        HomeFragment mFragment = new HomeFragment();
        return mFragment;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_home;
    }

    @Override
    protected void onInitView() {
        toolbarTitle.setText(R.string.strHome);
    }

    @Override
    protected void onInitData() {

    }
}
