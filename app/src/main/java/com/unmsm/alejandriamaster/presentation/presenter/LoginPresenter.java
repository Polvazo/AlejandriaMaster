package com.unmsm.alejandriamaster.presentation.presenter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.unmsm.alejandriamaster.data.entities.LoginData;
import com.unmsm.alejandriamaster.data.remote.request.LoginRequest;
import com.unmsm.alejandriamaster.data.remote.ServiceGenerator;
import com.unmsm.alejandriamaster.presentation.constans.ConstansGlobal;
import com.unmsm.alejandriamaster.presentation.contracs.LoginContract;
import com.unmsm.alejandriamaster.presentation.utils.Preferences;
import com.unmsm.alejandriamaster.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginPresenter implements LoginContract.Presenter {
    private final LoginContract.View mLoginView;
    private Context context;
    private ArrayList<LoginData> loginOpen;


    public LoginPresenter(LoginContract.View mLoginView, @NonNull Context context) {
        this.mLoginView = mLoginView;
        this.context = context;
        this.mLoginView.setPresenter(this);
    }

    @Override
    public void loginUser(final String username, final String password) {
        mLoginView.setLoadingIndicator(true);
        final LoginRequest loginService = ServiceGenerator.createService(LoginRequest.class);
        Call<ArrayList<LoginData>> call = loginService.getLogin(username, password);
        call.enqueue(new Callback<ArrayList<LoginData>>() {
            @Override
            public void onResponse(Call<ArrayList<LoginData>> call, Response<ArrayList<LoginData>> response) {
                if (response.isSuccessful()) {
                    loginOpen = response.body();
                    Log.i("Estado", "entro por aca");
                    Log.i(username, String.valueOf(password));

                    if (!loginOpen.isEmpty()) {
                        Log.i("Usuario", String.valueOf(loginOpen.get(0).getUsuarioId()));
                        Preferences.guardar(ConstansGlobal.idUser, String.valueOf(loginOpen.get(0).getUsuarioId()), context);
                        mLoginView.successLoginUser();
                        mLoginView.setDialogMessage(context.getString(R.string.Welcome));
                    }
                }
                mLoginView.setLoadingIndicator(false);
                mLoginView.errorLogin(context.getString(R.string.incorrecto));
            }

            @Override
            public void onFailure(Call<ArrayList<LoginData>> call, Throwable t) {
                mLoginView.setLoadingIndicator(false);
                mLoginView.errorLogin(context.getString(R.string.errorLoging));
            }
        });
    }

    @Override
    public void start() {

    }
}
