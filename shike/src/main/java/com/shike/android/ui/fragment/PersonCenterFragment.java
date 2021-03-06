package com.shike.android.ui.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.android.core.base.AbsBaseFragment;
import com.android.core.control.Glides;
import com.android.core.control.ScreenUtil;
import com.android.core.control.ToastUtil;
import com.android.core.widget.UiScrollView;
import com.shike.android.R;
import com.shike.android.ui.activity.AuthenticationActivity;
import com.shike.android.ui.activity.MyIncomeActivity;
import com.shike.android.ui.activity.RechargeActivity;
import com.shike.android.ui.activity.SettingActivity;
import com.shike.android.ui.activity.UserDetailActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by user on 16/8/3.
 */
public class PersonCenterFragment extends AbsBaseFragment {

    @Bind(R.id.ivAvatar)
    ImageView mUserAvatar;

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
        Glides.getInstance().loadCircle(getActivity(), R.drawable.abc_adv_3, mUserAvatar);
    }

    @Override
    protected void onInitData() {

    }


    @OnClick({R.id.tvRecharge,R.id.ivAvatar,
            R.id.llMyIncome, R.id.llMyAuction, R.id.llMyLive,
            R.id.rlMsg, R.id.rlMoneyhistory, R.id.rlRealName, R.id.rlHs,
            R.id.rlUplondBanner, R.id.rlShare, R.id.rlSetting})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvRecharge:
                openActivity(RechargeActivity.class);
                break;
            case R.id.ivAvatar:
                openActivity(UserDetailActivity.class);
                break;
            case R.id.llMyIncome:
                openActivity(MyIncomeActivity.class);
                break;
            case R.id.llMyAuction:
                ToastUtil.show("我的拍卖");
                break;
            case R.id.llMyLive:
                ToastUtil.show("我的直播");
                break;
            case R.id.rlMsg:
                ToastUtil.show("我的消息");
                break;
            case R.id.rlMoneyhistory:
                ToastUtil.show("资金记录");
                break;
            case R.id.rlRealName:
                openActivity(AuthenticationActivity.class);
                break;
            case R.id.rlHs:
                ToastUtil.show("我的呼声");
                break;
            case R.id.rlUplondBanner:
                ToastUtil.show("广告图片上传");
                break;
            case R.id.rlShare:
                ToastUtil.show("邀请好友");
                break;
            case R.id.rlSetting:
                openActivity(SettingActivity.class);
                break;

        }
    }
}
