package com.shike.android;

import com.android.core.MainApp;
import com.android.core.control.crash.AndroidCrash;
import com.android.core.control.crash.HttpReportCallback;
import com.android.core.control.logcat.Logcat;
import com.android.core.model.LogicProxy;

import java.io.File;

/**
 * 作者：joyo on 16/8/2 22:39
 * 邮箱：59296309@qq.com
 */
public class ShiKeApplication extends MainApp {

    @Override
    public void onCreate() {
        super.onCreate();

//        LogicProxy.getInstance().init(
//                LoginContract.class, MainContract.class);

        //Android crash 上传服务器回掉
        HttpReportCallback report = new HttpReportCallback() {
            @Override
            public void uploadException2remote(File file) {
                //可以直接上传文件
            }
        };
        AndroidCrash.getInstance().setCrashReporter(report).init(this);
        if (BuildConfig.DEBUG)
            Logcat.init("com.android.racofix").hideThreadInfo().methodCount(3);
    }

}
