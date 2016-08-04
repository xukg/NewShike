package com.shike.android.ui.fragment;

import android.view.View;

import com.android.core.base.AbsBaseFragment;
import com.android.core.model.LoadEveryLogic;
import com.shike.android.R;
import com.shike.android.model.repo.Classify;
import com.shike.android.presenter.LoginContract;
import com.shike.android.ui.activity.ForgetPwdActivity;
import com.shike.android.ui.activity.MainActivity;
import com.shike.android.ui.activity.RegisterActivity;

import butterknife.OnClick;

/**
 * Created by user on 16/8/3.
 */
public class LoginByAccountFragment extends AbsBaseFragment implements LoadEveryLogic.LoadEveryView<Classify>{

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
        mPresenter = getLogicImpl(LoginContract.class, this);
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
                showProgress("正在登陆");
                ((LoginContract) mPresenter).onLogin("zhangsan", "456");
                break;
        }
    }

    @Override
    public void onLoadComplete(Classify body) {
        hideProgress();
        openActivity(MainActivity.class);
    }

    @Override
    public void onLoadFailer(String msg) {
        showErrorMessage("登录错误", msg);
    }
}
