package com.unmsm.alejandriamaster.presentation.activity;


import android.os.Bundle;

import com.unmsm.alejandriamaster.core.BaseActivity;
import com.unmsm.alejandriamaster.presentation.fragments.LoanFragment;

import com.unmsm.alejandriamaster.presentation.presenter.LoanPresenter;

import com.unmsm.alejandriamaster.presentation.utils.ActivityUtils;
import com.unmsm.alejandriamaster.R;

public class LoanActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clean);


        LoanFragment loanFragment = (LoanFragment) getSupportFragmentManager().findFragmentById(R.id.body);
        if (loanFragment == null) {
            loanFragment = LoanFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), loanFragment, R.id.body);
        }

        new LoanPresenter(loanFragment, this);
    }
    @Override
    public void onBackPressed() {
        closeApp(false);
    }
}
