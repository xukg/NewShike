package com.shike.android.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.android.core.base.AbsBaseActivity;
import com.android.core.control.Glides;
import com.android.core.control.ToastUtil;
import com.shike.android.R;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 作者：joyo on 16/8/5 23:25
 * 邮箱：59296309@qq.com
 */
public class UserDetailActivity extends AbsBaseActivity{

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.ivAvatar)
    ImageView ivAvatar;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_user_detail;
    }

    @Override
    protected void onInitView(Bundle savedInstanceState) {
        addActionBar(mToolbar, "个人资料");

        Glides.getInstance().loadCircle(getApplicationContext(), R.drawable.app_logo, ivAvatar);
    }

    @Override
    protected void onInitData() {

    }

    @OnClick({R.id.rlModifyAvatar, R.id.rlNickname, R.id.rlPwd, R.id.rlPayPwd, R.id.rlPhone,
    R.id.rlAttention, R.id.rlFans, R.id.rlWork, R.id.rlIntroduce, R.id.rlSkill, R.id.rlOtherInfo})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.rlModifyAvatar:
                ToastUtil.show("修改头像");
                break;
            case R.id.rlNickname:
                openActivity(AddNicknameActivity.class);
                break;
            case R.id.rlPwd:
                openActivity(ModifyPwdActivity.class);
                break;
            case R.id.rlPayPwd:
                openActivity(ModifyPayPwdActivity.class);
                break;
            case R.id.rlPhone:
                openActivity(BindPhoneActivity.class);
                break;
            case R.id.rlAttention:
                openActivity(MyAttentionActivity.class);
                break;
            case R.id.rlFans:
                openActivity(MyFansActivity.class);
                break;
            case R.id.rlWork:
                openActivity(AddWorkActivity.class);
                break;
            case R.id.rlIntroduce:
                openActivity(AddIntroduceActivity.class);
                break;
            case R.id.rlSkill:
                openActivity(AddSkillActivity.class);
                break;
            case R.id.rlOtherInfo:
                openActivity(AddOtherInfoActivity.class);
                break;

        }
    }
}
