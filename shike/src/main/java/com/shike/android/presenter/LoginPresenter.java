package com.shike.android.presenter;

import com.android.core.model.LoadEveryLogicImpl;
import com.shike.android.api.Factory;
import com.shike.android.model.repo.Classify;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter extends LoadEveryLogicImpl<Classify> implements LoginContract {

    @Override
    public void onLogin(String username, String password) {
        Factory.provideHttpService().getImageClassify(1).enqueue(new Callback<Classify>() {
            @Override
            public void onResponse(Call<Classify> call, Response<Classify> response) {
                onLoadCompleteData(response);
            }

            @Override
            public void onFailure(Call<Classify> call, Throwable t) {
                onFailer(t.getMessage());
            }
        });
    }
}
