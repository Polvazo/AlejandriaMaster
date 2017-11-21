package com.unmsm.alejandriamaster.Presentation.Presenter;



import android.content.Context;

import android.support.annotation.NonNull;

import com.unmsm.alejandriamaster.Presentation.Contracs.ScanContract;


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
