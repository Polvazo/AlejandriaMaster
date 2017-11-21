package com.unmsm.alejandriamaster.presentation.contracs;


import com.unmsm.alejandriamaster.core.BasePresenter;
import com.unmsm.alejandriamaster.core.BaseView;

public interface LoginContract {

    interface View extends BaseView<Presenter> {
        void errorLogin(String msg);
        void successLoginUser();
    }

    interface Presenter extends BasePresenter {
        void loginUser(String username, String password);

    }
}
