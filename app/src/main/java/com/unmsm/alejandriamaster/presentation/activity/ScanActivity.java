package com.unmsm.alejandriamaster.presentation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.unmsm.alejandriamaster.core.BaseActivity;
import com.unmsm.alejandriamaster.presentation.constans.ConstansGlobal;
import com.unmsm.alejandriamaster.presentation.fragments.ScanFragment;
import com.unmsm.alejandriamaster.presentation.presenter.ScanPresenter;
import com.unmsm.alejandriamaster.presentation.utils.ActivityUtils;
import com.unmsm.alejandriamaster.presentation.utils.Preferences;
import com.unmsm.alejandriamaster.R;

/**
 * Created by USUARIO on 03/11/2017.
 */

public class ScanActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clean);


        ScanFragment scanFragment = (ScanFragment) getSupportFragmentManager().findFragmentById(R.id.body);
        if (scanFragment == null) {
            scanFragment = ScanFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), scanFragment, R.id.body);
        }

        new ScanPresenter(scanFragment, this);
    }


    @Override
    public void onBackPressed() {
        closeApp(false);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        Log.i("estado", "entro al fragment ");
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                showMessage(getString(R.string.CanceloScan));
            } else {
                Preferences.Guardar(ConstansGlobal.idBook, result.getContents(), getApplicationContext());
                next(this, null, LoanActivity.class, true);
            }
        } else {
        }
    }

}
