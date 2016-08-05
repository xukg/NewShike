package com.shike.android.ui.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.android.core.adapter.MyPagerAdapter;
import com.android.core.base.AbsBaseFragment;
import com.shike.android.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by user on 16/8/3.
 */
public class AuctionFragment extends AbsBaseFragment {

    @Bind(R.id.toolbarTitle)
    TextView toolbarTitle;

    @Bind(R.id.tablayout)
    TabLayout tabLayout;

    @Bind(R.id.viewpager)
    ViewPager viewPager;

    public static AuctionFragment newInstance() {
        AuctionFragment mFragment = new AuctionFragment();
        return mFragment;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_auction;
    }

    @Override
    protected void onInitView() {
        toolbarTitle.setText(R.string.strAuction);

        List<Fragment> fragmetnList = new ArrayList<>();
        AuctionItemFragment fragment0 = AuctionItemFragment.newInstance();
        AuctionItemFragment fragment1 = AuctionItemFragment.newInstance();
        AuctionItemFragment fragment2 = AuctionItemFragment.newInstance();
        AuctionItemFragment fragment3 = AuctionItemFragment.newInstance();
        AuctionItemFragment fragment4 = AuctionItemFragment.newInstance();
        AuctionItemFragment fragment5 = AuctionItemFragment.newInstance();
        AuctionItemFragment fragment6 = AuctionItemFragment.newInstance();
        fragmetnList.add(fragment0);
        fragmetnList.add(fragment1);
        fragmetnList.add(fragment2);
        fragmetnList.add(fragment3);
        fragmetnList.add(fragment4);
        fragmetnList.add(fragment5);
        fragmetnList.add(fragment6);

        List<CharSequence> titleList = new ArrayList<>();
        titleList.add("全部");
        titleList.add("娱乐");
        titleList.add("会议");
        titleList.add("活动");
        titleList.add("医疗");
        titleList.add("其他");
        titleList.add("其他2");

        MyPagerAdapter adapter = new MyPagerAdapter(getChildFragmentManager(), fragmetnList, titleList);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    @Override
    protected void onInitData() {

    }
}
