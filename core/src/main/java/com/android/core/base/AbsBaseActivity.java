package com.android.core.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TextView;

import com.android.core.R;
import com.android.core.control.ToastUtil;
import com.android.core.model.LogicProxy;
import com.android.core.widget.dialog.DialogManager;

import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;


public abstract class AbsBaseActivity extends AppCompatActivity implements BaseView {

    private final String TAG = "AbsBaseActivity";
    protected Context mContext = null;//context
    protected BasePresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, String.format("Activity Location (%s.java:0)", getClass().getSimpleName()));
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        mContext = this;
        setContentView(getLayoutResource());
        ButterKnife.bind(this);
        onInitView(savedInstanceState);
        onInitData();
    }

    protected abstract int getLayoutResource();

    protected abstract void onInitView(Bundle savedInstanceState);

    protected abstract void onInitData();


    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        // 打开Activity动画
    }

    //获得该页面的实例
    public <T> T getLogicImpl(Class cls, BaseView o) {
        return LogicProxy.getInstance().bind(cls, o);
    }

    @Override
    public void finish() {
        super.finish();
        // 关闭动画
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
        if (mPresenter != null)
            mPresenter.detachView();
    }

    @Override
    public void showMessage(String msg) {
        ToastUtil.show(msg);
    }

    public void showProgress(String message) {
        DialogManager.showProgressDialog(mContext, message);
    }

    @Override
    public void showProgress(String message, int progress) {
        DialogManager.showProgressDialog(mContext, message, progress);
    }

    @Override
    public void hideProgress() {
        DialogManager.hideProgressDialog();
    }

    @Override
    public void showErrorMessage(String msg, String content) {
        DialogManager.showErrorDialog(mContext, msg, content, new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {
                sweetAlertDialog.dismissWithAnimation();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return true;
    }

    /**
     * 通过类名启动Activity
     *
     * @param pClass
     */
    public void openActivity(Class<?> pClass) {
        openActivity(pClass, null);
    }

    /**
     * 通过类名启动Activity，并且含有Bundle数据
     *
     * @param pClass
     * @param pBundle
     */
    public void openActivity(Class<?> pClass, Bundle pBundle) {
        Intent intent = new Intent(this, pClass);
        if (pBundle != null) {
            intent.putExtras(pBundle);
        }
        startActivity(intent);
    }
    /**
     * 通过类名启动Activity
     *
     * @param pClass
     */
    public void openActivityForResult(Class<?> pClass, int requestCode) {
        openActivityForResult(pClass, null,requestCode);
    }

    /**
     * 通过类名启动Activity，并且含有Bundle数据
     *
     * @param pClass
     * @param pBundle
     */
    public void openActivityForResult(Class<?> pClass, Bundle pBundle, int requestCode) {
        Intent intent = new Intent(this, pClass);
        if (pBundle != null) {
            intent.putExtras(pBundle);
        }
        startActivityForResult(intent, requestCode);
    }

    /**
     * 通过Action启动Activity
     *
     * @param pAction
     */
    protected void openActivity(String pAction) {
        openActivity(pAction, null);
    }

    /**
     * 通过Action启动Activity，并且含有Bundle数据
     *
     * @param pAction
     * @param pBundle
     */
    public void openActivity(String pAction, Bundle pBundle) {
        Intent intent = new Intent(pAction);
        if (pBundle != null) {
            intent.putExtras(pBundle);
        }
        startActivity(intent);
    }

    protected void addActionBar(Toolbar mToolbar, final int strResId){
        TextView mTitle = (TextView) mToolbar.findViewById(R.id.toolbar_title);
        String title = getString(strResId);
        mTitle.setText(title);
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.icon_back);
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.colorPrimary));
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    protected void addActionBar(Toolbar mToolbar, final String strTitle){
        TextView mTitle = (TextView) mToolbar.findViewById(R.id.toolbar_title);
        mTitle.setText(strTitle);
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.icon_back);
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.colorPrimary));
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    protected void addActionBar(Toolbar mToolbar, final String strTitle, boolean showBack){
        TextView mTitle = (TextView) mToolbar.findViewById(R.id.toolbar_title);
        mTitle.setText(strTitle);
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.icon_back);
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.colorPrimary));
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(showBack);
    }

}
