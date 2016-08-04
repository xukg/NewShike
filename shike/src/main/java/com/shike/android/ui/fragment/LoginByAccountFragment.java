package com.shike.android.ui.fragment;

import android.view.View;

import com.android.core.base.AbsBaseFragment;
import com.shike.android.R;
import com.shike.android.ui.activity.ForgetPwdActivity;
import com.shike.android.ui.activity.MainActivity;
import com.shike.android.ui.activity.RegisterActivity;

import butterknife.OnClick;

/**
 * Created by user on 16/8/3.
 */
public class LoginByAccountFragment extends AbsBaseFragment {

    public static LoginByAccountFragment newInstance() {
        LoginByAccountFragment mFragment = new LoginByAccountFragment();
        return mFragment;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_login_by_account;
    }

    @Override
    protected void onInitView() {

    }

    @Override
    protected void onInitData() {

    }

    @OnClick({R.id.tvReg, R.id.tvForgetPwd, R.id.btnLogin})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvReg:
                openActivity(RegisterActivity.class);
                break;
            case R.id.tvForgetPwd:
                openActivity(ForgetPwdActivity.class);
                break;
            case R.id.btnLogin:
                openActivity(MainActivity.class);
                break;
        }
    }
}
