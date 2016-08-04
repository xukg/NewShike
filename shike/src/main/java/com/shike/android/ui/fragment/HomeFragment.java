package com.shike.android.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.android.core.adapter.RecyclerAdapter;
import com.android.core.base.AbsBaseFragment;
import com.android.core.control.XRecyclerViewHelper;
import com.android.core.model.LoadListDataLogic;
import com.android.core.widget.CustomViewpager;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.shike.android.R;
import com.shike.android.model.repo.Classify;
import com.shike.android.presenter.MainContract;
import com.shike.android.presenter.MainPresenter;
import com.shike.android.ui.adapter.CustomViewPageAdapter;
import com.shike.android.ui.adapter.HomeRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by user on 16/8/3.
 */
public class HomeFragment extends AbsBaseFragment implements LoadListDataLogic.LoadListView<Classify>, XRecyclerView.LoadingListener {

    @Bind(R.id.toolbarTitle)
    TextView toolbarTitle;

    @Bind(R.id.recly_view)
    XRecyclerView mRecyclerView;

    private List<Classify.TngouEntity> classifys = new ArrayList<>();
    private CustomViewpager mViewpage;
    private RecyclerAdapter recyclerAdapter;
    private int page = 1;

    // 广告数据
    public static List<Integer> getAdData() {
        List<Integer> adList = new ArrayList<>();
        adList.add(R.drawable.abc_adv_1);
        adList.add(R.drawable.abc_adv_2);
        adList.add(R.drawable.abc_adv_3);
        return adList;
    }

    public static HomeFragment newInstance() {
        HomeFragment mFragment = new HomeFragment();
        return mFragment;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_home;
    }

    @Override
    protected void onInitView() {
        toolbarTitle.setText(R.string.strHome);
        mPresenter = getLogicImpl(MainContract.class, this);
    }

    @Override
    protected void onInitData() {

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        XRecyclerViewHelper.init().setLinearLayout(getActivity(), mRecyclerView);

        View header = View.inflate(getActivity(), R.layout.abc_viewpager_view, null);
        mViewpage = (CustomViewpager) header.findViewById(R.id.viewpager);
        mRecyclerView.addHeaderView(header);

        CustomViewPageAdapter adapter = new CustomViewPageAdapter(getActivity(), getAdData());
        mViewpage.updateIndicatorView(getAdData().size(), 0);
        mViewpage.setAdapter(adapter);
        mViewpage.startScorll();

        recyclerAdapter = new HomeRecyclerAdapter(getActivity(), R.layout.item_compete_classitfy, classifys);
        mRecyclerView.setAdapter(recyclerAdapter);
        mRecyclerView.setLoadingListener(this);
        showProgress("正在加载");
        onRefresh();
    }

    @Override
    public void onLoadCompleteData(Classify body, boolean isMore) {
        if (body.isStatus()) {
            if (!isMore) {
                classifys.clear();
            }
            classifys.addAll(body.getTngou());
            recyclerAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onLoadComplete(boolean isMore) {
        //加载完成需要做的操作
        hideProgress();
        if (isMore) {
            mRecyclerView.loadMoreComplete();
        } else {
            mRecyclerView.refreshComplete();
        }

    }

    @Override
    public void onRefresh() {
        ((MainPresenter) mPresenter).onLoadRemoteData(false, 1);
    }

    @Override
    public void onLoadMore() {
        page++;
        ((MainPresenter) mPresenter).onLoadRemoteData(true, page);
    }


}
