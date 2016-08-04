package com.shike.android.ui.fragment;

import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.android.core.base.AbsBaseFragment;
import com.shike.android.R;

import butterknife.Bind;

/**
 * Created by user on 16/8/3.
 */
public class LiveFragment extends AbsBaseFragment {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.toolbarTitle)
    TextView toolbarTitle;

    public static LiveFragment newInstance() {
        LiveFragment mFragment = new LiveFragment();
        return mFragment;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_live;
    }

    @Override
    protected void onInitView() {
        toolbarTitle.setText(R.string.strLive);
    }

    @Override
    protected void onInitData() {

    }
}
