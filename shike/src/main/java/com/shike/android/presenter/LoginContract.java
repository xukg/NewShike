package com.shike.android.presenter;

import com.android.core.model.annotation.Implement;

@Implement(LoginPresenter.class)
public interface LoginContract {
    void onLogin(String username, String password);
}
