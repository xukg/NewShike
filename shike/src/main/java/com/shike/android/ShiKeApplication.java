package com.shike.android;

import com.android.core.MainApp;
import com.android.core.model.LogicProxy;
import com.shike.android.presenter.LoginContract;
import com.shike.android.presenter.MainContract;

/**
 * 作者：joyo on 16/8/2 22:39
 * 邮箱：59296309@qq.com
 */
public class ShiKeApplication extends MainApp {

    @Override
    public void onCreate() {
        super.onCreate();

        LogicProxy.getInstance().init(LoginContract.class, MainContract.class);
    }

}
