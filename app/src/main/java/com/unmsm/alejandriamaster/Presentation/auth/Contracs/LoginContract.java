package com.unmsm.alejandriamaster.Presentation.auth.Contracs;


import com.unmsm.alejandriamaster.Core.BasePresenter;
import com.unmsm.alejandriamaster.Core.BaseView;
import com.unmsm.alejandriamaster.Data.Entities.loginData;

public interface LoginContract {

    interface View extends BaseView<Presenter> {
        void errorLogin(String msg);
        void successLoginUser(loginData loginData);
    }

    interface Presenter extends BasePresenter {
        void loginUser(String username, String password);
        void getPerfilUser();
        void openSessionUser(String token, loginData userEntity);
    }
}
