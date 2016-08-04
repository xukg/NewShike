package com.shike.android.presenter;

import com.android.core.model.annotation.Implement;

@Implement(MainPresenter.class)
public interface MainContract {
    void onLoadRemoteData(boolean isMore, int page);
}
