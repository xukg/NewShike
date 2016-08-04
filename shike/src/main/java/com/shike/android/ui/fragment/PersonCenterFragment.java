package com.shike.android.ui.fragment;

import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.android.core.base.AbsBaseFragment;
import com.shike.android.R;

import butterknife.Bind;

/**
 * Created by user on 16/8/3.
 */
public class PersonCenterFragment extends AbsBaseFragment {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.toolbarTitle)
    TextView toolbarTitle;

    public static PersonCenterFragment newInstance() {
        PersonCenterFragment mFragment = new PersonCenterFragment();
        return mFragment;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_person_center;
    }

    @Override
    protected void onInitView() {
        toolbarTitle.setText(R.string.strPersonCenter);
    }

    @Override
    protected void onInitData() {

    }
}
