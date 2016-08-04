package com.shike.android.ui.activity;

import android.os.Bundle;

import com.android.core.base.AbsBaseActivity;
import com.android.core.widget.TabStripView;
import com.shike.android.R;
import com.shike.android.ui.fragment.AuctionFragment;
import com.shike.android.ui.fragment.HomeFragment;
import com.shike.android.ui.fragment.LiveFragment;
import com.shike.android.ui.fragment.PersonCenterFragment;

import butterknife.Bind;

public class MainActivity extends AbsBaseActivity {

    @Bind(R.id.navigateTabBar)
    TabStripView navigateTabBar;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    protected void onInitView(Bundle savedInstanceState) {

        navigateTabBar.setFrameLayoutId(R.id.mainContainer);
        navigateTabBar.setTabTextColor(getResources().getColor(R.color.abc_tab_text_normal));
        navigateTabBar.setSelectedTabTextColor(getResources().getColor(R.color.colorPrimary));
        navigateTabBar.onRestoreInstanceState(savedInstanceState);

        navigateTabBar.addTab(HomeFragment.class, new TabStripView.TabParam(R.drawable.ic_tab_bar_home, R.drawable.ic_tab_bar_home_selected, R.string.strHome));
        navigateTabBar.addTab(AuctionFragment.class, new TabStripView.TabParam(R.drawable.ic_tab_bar_home, R.drawable.ic_tab_bar_find_selected, R.string.strAuction));
        navigateTabBar.addTab(LiveFragment.class, new TabStripView.TabParam(R.drawable.ic_tab_bar_home, R.drawable.ic_tab_bar_person_selected, R.string.strLive));
        navigateTabBar.addTab(PersonCenterFragment.class, new TabStripView.TabParam(R.drawable.ic_tab_bar_home, R.drawable.ic_tab_bar_person_selected, R.string.strMine));

    }

    @Override
    protected void onInitData() {

    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //保存当前选中的选项状态
        navigateTabBar.onSaveInstanceState(outState);
    }
}
