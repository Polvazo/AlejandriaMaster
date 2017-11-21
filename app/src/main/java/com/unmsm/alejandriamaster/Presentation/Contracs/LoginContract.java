package com.unmsm.alejandriamaster.Presentation.Contracs;


import com.unmsm.alejandriamaster.Core.BasePresenter;
import com.unmsm.alejandriamaster.Core.BaseView;

public interface LoginContract {

    interface View extends BaseView<Presenter> {
        void errorLogin(String msg);
        void successLoginUser();
    }

    interface Presenter extends BasePresenter {
        void loginUser(String username, String password);

    }
}
