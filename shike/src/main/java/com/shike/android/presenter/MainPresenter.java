package com.shike.android.presenter;

import com.android.core.model.LoadListDataLogicImpl;
import com.shike.android.api.Factory;
import com.shike.android.model.repo.Classify;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter extends LoadListDataLogicImpl<Classify> implements MainContract {
    @Override
    public void onLoadRemoteData(final boolean isMore, int page) {
        Factory.provideHttpService().getImageClassify(page).enqueue(new Callback<Classify>() {
            @Override
            public void onResponse(Call<Classify> call, Response<Classify> response) {
                onLoadComplete(response, isMore);
            }

            @Override
            public void onFailure(Call<Classify> call, Throwable t) {
                onFailer(t.getLocalizedMessage());
            }
        });
    }
}
