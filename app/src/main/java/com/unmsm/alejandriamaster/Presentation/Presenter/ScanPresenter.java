package com.unmsm.alejandriamaster.Presentation.Presenter;



import android.content.Context;

import android.support.annotation.NonNull;


import com.unmsm.alejandriamaster.Data.Entities.bookData;
import com.unmsm.alejandriamaster.Presentation.Contracs.ScanContract;


import java.util.ArrayList;

public class ScanPresenter implements ScanContract.Presenter {
    private final ScanContract.View mScanView;
    private Context context;
    private ArrayList<bookData> bookdata;

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
