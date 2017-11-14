package com.unmsm.alejandriamaster.Presentation.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.unmsm.alejandriamaster.Core.BaseActivity;
import com.unmsm.alejandriamaster.Presentation.Fragments.ScanFragment;
import com.unmsm.alejandriamaster.Presentation.Presenter.ScanPresenter;
import com.unmsm.alejandriamaster.Presentation.Utils.ActivityUtils;
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
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (result != null) {
            if (result.getContents() == null) {

                showMessageError(getString(R.string.error));
            } else {
                showMessage(result.getContents());
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}
