package com.unmsm.alejandriamaster.Presentation.Presenter;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import com.unmsm.alejandriamaster.Presentation.Activity.ScanActivity;
import com.unmsm.alejandriamaster.Presentation.Contracs.ScanContract;
import com.unmsm.alejandriamaster.Presentation.Fragments.LoginFragment;
import com.unmsm.alejandriamaster.R;

public class ScanPresenter implements ScanContract.Presenter {
    private final ScanContract.View mScanView;
    private Context context;

    public ScanPresenter(ScanContract.View mScanView, @NonNull Context context) {
        this.mScanView = mScanView;
        this.context = context;
        this.mScanView.setPresenter(this);
    }



    @Override
    public void start() {

    }
}
