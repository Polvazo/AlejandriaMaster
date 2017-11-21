package com.unmsm.alejandriamaster.presentation.activity;



import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;


import com.unmsm.alejandriamaster.core.BaseActivity;
import com.unmsm.alejandriamaster.presentation.presenter.LoginPresenter;
import com.unmsm.alejandriamaster.presentation.utils.ActivityUtils;
import com.unmsm.alejandriamaster.presentation.fragments.LoginFragment;
import com.unmsm.alejandriamaster.R;


public class LoginAlejandria extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clean);
        LoginFragment loginFragment = (LoginFragment) getSupportFragmentManager().findFragmentById(R.id.body);
        if (loginFragment == null) {
            loginFragment = LoginFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), loginFragment, R.id.body);
        }
        //Creacion de LoginPresenter
        new LoginPresenter(loginFragment, this);
    }

    public void showMessageError(String message) {
        CoordinatorLayout container = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        super.showMessage(message);
    }

    @Override
    public void onBackPressed() {
        closeApp(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


}
