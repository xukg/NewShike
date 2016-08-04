package com.shike.android.ui.fragment;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.android.core.base.AbsBaseFragment;
import com.android.core.control.Glides;
import com.android.core.control.ScreenUtil;
import com.android.core.widget.UiScrollView;
import com.shike.android.R;

import butterknife.Bind;

/**
 * Created by user on 16/8/3.
 */
public class PersonCenterFragment extends AbsBaseFragment {

    @Bind(R.id.iv_user_avatar)
    ImageView mUserAvatar;

    @Bind(R.id.iv_global_adv)
    TextView mGlobalAdv;

    @Bind(R.id.rlt_navi_top)
    RelativeLayout mNaviView;

    @Bind(R.id.slv_user)
    UiScrollView mSlvView;

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
//        Glides.getInstance().load(getActivity(), R.drawable.abc_welcome_bg, mGlobalAdv);
        mNaviView.getBackground().mutate().setAlpha(0);
        mSlvView.setCallback(new UiScrollView.Callback() {
            @Override
            public void onScrollChanged(ScrollView who, int l, int t, int oldl, int oldt) {
                int height = ScreenUtil.dp2px(getActivity(), 200);
                double ratio = Math.min(1.0, t * 1.0 / height);
                double moveY = ratio * 255.0;
                mNaviView.getBackground().setAlpha((int) moveY);
            }
        });
    }

    @Override
    protected void onInitData() {

    }
}
