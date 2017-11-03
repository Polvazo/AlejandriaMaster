package com.unmsm.alejandriamaster.Presentation.Presenter;

/**
 * Created by christian on 6/28/17.
 */

import android.content.Context;
import android.support.annotation.NonNull;

import com.proyecto.etilico.etilico.data.entities.AccessTokenEntity;
import com.proyecto.etilico.etilico.data.entities.UserEntity;
import com.proyecto.etilico.etilico.data.remote.ServiceGenerator;
import com.proyecto.etilico.etilico.data.remote.request.LoginRequest;
import com.proyecto.etilico.etilico.data.remote.request.UserRequest;
import com.proyecto.etilico.etilico.data.repositories.local.SessionManager;
import com.proyecto.etilico.etilico.presentation.contracts.LoginContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter implements LoginContract.Presenter{
    private final LoginContract.View mLoginView;
    private Context context;
    private SessionManager sessionManager;

    public LoginPresenter(LoginContract.View mLoginView, @NonNull Context context) {
        this.mLoginView = mLoginView;
        this.context = context;
        this.mLoginView.setPresenter(this);
        sessionManager = new SessionManager(context);
    }

    @Override
    public void loginUser(String email, String password) {
        mLoginView.setLoadingIndicator(true);
        LoginRequest loginService = ServiceGenerator.createService(LoginRequest.class);
        Call<AccessTokenEntity> call = loginService.login(email, password);
        call.enqueue(new Callback<AccessTokenEntity>() {
            @Override
            public void onResponse(Call<AccessTokenEntity> call, Response<AccessTokenEntity> response) {
                if(response.isSuccessful()){
                    getPerfilUser(response.body());
                }else{
                    mLoginView.setLoadingIndicator(false);
                    mLoginView.errorLogin("Email o contraseña incorrecto(s)");
                }
            }

            @Override
            public void onFailure(Call<AccessTokenEntity> call, Throwable t) {
                mLoginView.setLoadingIndicator(false);
                mLoginView.errorLogin("Ocurrió un error al tratar de ingresar, por favor intente nuevamente");
            }
        });
    }

    @Override
    public void getPerfilUser(final AccessTokenEntity token) {
        UserRequest userRequest = ServiceGenerator.createService(UserRequest.class);
        Call<UserEntity> call = userRequest.getUser("Token "+token.getAccessToken());
        call.enqueue(new Callback<UserEntity>() {
            @Override
            public void onResponse(Call<UserEntity> call, Response<UserEntity> response) {
                if(response.isSuccessful()){
                    openSessionUser(token.getAccessToken(), response.body());
                }else{
                    mLoginView.setLoadingIndicator(false);
                    mLoginView.errorLogin("Ocurrió un error al cargar su perfil");
                }
            }

            @Override
            public void onFailure(Call<UserEntity> call, Throwable t) {
                mLoginView.setLoadingIndicator(false);
                mLoginView.errorLogin("Fallo al traer datos, comunicarse con su administrador");
            }
        });
    }

    @Override
    public void openSessionUser(String token, UserEntity userEntity) {
        sessionManager.openSession(token,userEntity);
        mLoginView.setLoadingIndicator(false);
        mLoginView.successLoginUser(userEntity);
    }

    @Override
    public void start() {

    }
}
