package com.shike.android.ui.fragment;

import android.widget.TextView;

import com.android.core.base.AbsBaseFragment;
import com.shike.android.R;

import butterknife.Bind;

/**
 * Created by user on 16/8/3.
 */
public class AuctionItemFragment extends AbsBaseFragment {

    @Bind(R.id.toolbarTitle)
    TextView toolbarTitle;

    public static AuctionItemFragment newInstance() {
        AuctionItemFragment mFragment = new AuctionItemFragment();
        return mFragment;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_auction;
    }

    @Override
    protected void onInitView() {
        toolbarTitle.setText(R.string.strAuction);
    }

    @Override
    protected void onInitData() {

    }
}
