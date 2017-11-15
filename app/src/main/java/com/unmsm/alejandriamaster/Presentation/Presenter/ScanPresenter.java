package com.unmsm.alejandriamaster.Presentation.Presenter;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import com.unmsm.alejandriamaster.Data.Entities.loanData;
import com.unmsm.alejandriamaster.Data.Entities.loginData;
import com.unmsm.alejandriamaster.Data.Remote.Request.LoginRequest;
import com.unmsm.alejandriamaster.Data.Remote.Request.loanRequest;
import com.unmsm.alejandriamaster.Data.Remote.ServiceGenerator;
import com.unmsm.alejandriamaster.Presentation.Activity.ScanActivity;
import com.unmsm.alejandriamaster.Presentation.Constans.ConstansGlobal;
import com.unmsm.alejandriamaster.Presentation.Contracs.ScanContract;
import com.unmsm.alejandriamaster.Presentation.Fragments.LoginFragment;
import com.unmsm.alejandriamaster.Presentation.Utils.Preferences;
import com.unmsm.alejandriamaster.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScanPresenter implements ScanContract.Presenter {
    private final ScanContract.View mScanView;
    private Context context;

    public ScanPresenter(ScanContract.View mScanView, @NonNull Context context) {
        this.mScanView = mScanView;
        this.context = context;
        this.mScanView.setPresenter(this);
    }

    @Override
    public void getLoanData() {
        mScanView.getCodeQr();
    }

    @Override
    public void start() {

    }
}
