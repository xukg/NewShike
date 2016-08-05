package com.android.core.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by user on 16/8/4.
 */
public class MyPagerAdapter  extends FragmentStatePagerAdapter {

    private List<Fragment> list;

    private List<CharSequence> titles;

    public MyPagerAdapter(FragmentManager fm, List<Fragment> list, List<CharSequence> titles) {
        super(fm);
        this.list = list;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
