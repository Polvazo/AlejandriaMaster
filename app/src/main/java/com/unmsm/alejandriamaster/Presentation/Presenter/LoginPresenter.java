package com.unmsm.alejandriamaster.Presentation.Presenter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.unmsm.alejandriamaster.Data.Entities.loginData;
import com.unmsm.alejandriamaster.Data.Remote.Request.LoginRequest;
import com.unmsm.alejandriamaster.Data.Remote.ServiceGenerator;
import com.unmsm.alejandriamaster.Presentation.Constans.ConstansGlobal;
import com.unmsm.alejandriamaster.Presentation.Contracs.LoginContract;
import com.unmsm.alejandriamaster.Presentation.Utils.Preferences;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginPresenter implements LoginContract.Presenter {
    private final LoginContract.View mLoginView;
    private Context context;
    private ArrayList<loginData> loginOpen;


    public LoginPresenter(LoginContract.View mLoginView, @NonNull Context context) {
        this.mLoginView = mLoginView;
        this.context = context;
        this.mLoginView.setPresenter(this);
    }

    @Override
    public void loginUser(final String username, final String password) {
        mLoginView.setLoadingIndicator(true);
        final LoginRequest loginService = ServiceGenerator.createService(LoginRequest.class);
        final Long contrasenha = Long.parseLong(password);
        Call<ArrayList<loginData>> call = loginService.getLogin(username, password);
        call.enqueue(new Callback<ArrayList<loginData>>() {
            @Override
            public void onResponse(Call<ArrayList<loginData>> call, Response<ArrayList<loginData>> response) {
                if (response.isSuccessful()) {
                    loginOpen = response.body();
                    Log.i("Estado", "entro por aca");
                    Log.i(username, String.valueOf(password));

                        if (!loginOpen.isEmpty()) {
                            Log.i("Usuario",String.valueOf(loginOpen.get(0).getUsuarioId()));
                            Preferences.Guardar(ConstansGlobal.idUser,String.valueOf(loginOpen.get(0).getUsuarioId()),context);
                            mLoginView.successLoginUser();
                            mLoginView.setDialogMessage("Bienvenido");

                        }


                }
                mLoginView.setLoadingIndicator(false);
                mLoginView.errorLogin("Email o contraseña incorrecto(s)");
            }

            @Override
            public void onFailure(Call<ArrayList<loginData>> call, Throwable t) {
                mLoginView.setLoadingIndicator(false);
                mLoginView.errorLogin("Ocurrió un error al tratar de ingresar, por favor intente de nuevo");
            }
        });
    }

    @Override
    public void start() {

    }
}
