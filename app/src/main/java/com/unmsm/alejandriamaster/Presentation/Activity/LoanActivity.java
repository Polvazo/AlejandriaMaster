package com.unmsm.alejandriamaster.Presentation.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.unmsm.alejandriamaster.Core.BaseActivity;
import com.unmsm.alejandriamaster.Presentation.Fragments.LoanFragment;
import com.unmsm.alejandriamaster.Presentation.Fragments.ScanFragment;
import com.unmsm.alejandriamaster.Presentation.Presenter.LoanPresenter;
import com.unmsm.alejandriamaster.Presentation.Presenter.ScanPresenter;
import com.unmsm.alejandriamaster.Presentation.Utils.ActivityUtils;
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
}
