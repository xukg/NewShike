package com.shike.android.ui.activity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.android.core.base.AbsBaseActivity;
import com.android.core.control.Glides;
import com.android.core.control.HandlerTip;
import com.android.core.control.StatusBarUtil;
import com.shike.android.R;

import butterknife.Bind;

/**
 * Created by user on 16/8/3.
 */
public class WelcomeActivity extends AbsBaseActivity {

    @Bind(R.id.splash_view)
    ImageView splashView;

    private int milliseconds = 1500;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void onInitView(Bundle savedInstanceState) {
        //设置状态栏透明
        StatusBarUtil.setTranslucentBackground(this);
        //开始执行动画,开始跳转
        startScaleAnimation();
    }

    @Override
    protected void onInitData() {

    }

    private void startScaleAnimation() {

        ScaleAnimation animation = new ScaleAnimation(1f, 1.1f, 1f, 1.1f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(milliseconds);//设置动画持续时间
        animation.setFillAfter(true);
        splashView.setAnimation(animation);
        Glides.getInstance().loadAnima(this, R.drawable.splash_background, animation, splashView);
        HandlerTip.getInstance().postDelayed(milliseconds, new HandlerTip.HandlerCallback() {
            @Override
            public void postDelayed() {
                openActivity(LoginActivity.class);
                finish();
            }
        });
    }
}
