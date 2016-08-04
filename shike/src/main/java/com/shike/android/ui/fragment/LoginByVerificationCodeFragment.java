package com.shike.android.ui.fragment;

import android.view.View;

import com.android.core.base.AbsBaseFragment;
import com.android.core.control.ToastUtil;
import com.shike.android.R;
import com.shike.android.ui.activity.ForgetPwdActivity;
import com.shike.android.ui.activity.RegisterActivity;

import butterknife.OnClick;

/**
 * Created by user on 16/8/3.
 */
public class LoginByVerificationCodeFragment extends AbsBaseFragment {

    public static LoginByVerificationCodeFragment newInstance() {
        LoginByVerificationCodeFragment mFragment = new LoginByVerificationCodeFragment();
        return mFragment;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_login_by_code;
    }

    @Override
    protected void onInitView() {

    }

    @Override
    protected void onInitData() {

    }


    @OnClick({R.id.tvReg, R.id.tvForgetPwd, R.id.tvGetCode, R.id.btnLogin})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvReg:
                openActivity(RegisterActivity.class);
                break;
            case R.id.tvForgetPwd:
                openActivity(ForgetPwdActivity.class);
                break;
            case R.id.tvGetCode:
                ToastUtil.show("我要获取验证码");
                break;
            case R.id.btnLogin:
                ToastUtil.show("我要登录");
                break;
        }
    }
}
