package com.unmsm.alejandriamaster.Presentation.auth.Contracs;


import com.unmsm.alejandriamaster.Core.BasePresenter;
import com.unmsm.alejandriamaster.Core.BaseView;

public interface LoginContract {

    interface View extends BaseView<Presenter> {
        void errorLogin(String msg);
        void successLoginUser(UserEntity userEntity);
    }

    interface Presenter extends BasePresenter {
        void loginUser(String email, String password);
        void getPerfilUser(AccessTokenEntity token);
        void openSessionUser(String token, UserEntity userEntity);
    }
}
