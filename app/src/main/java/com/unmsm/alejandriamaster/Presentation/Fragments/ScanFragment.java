package com.unmsm.alejandriamaster.Presentation.Fragments;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.unmsm.alejandriamaster.Core.BaseFragment;

import com.unmsm.alejandriamaster.Presentation.Activity.LoginAlejandria;
import com.unmsm.alejandriamaster.Presentation.Activity.ScanActivity;
import com.unmsm.alejandriamaster.Presentation.Contracs.ScanContract;
import com.unmsm.alejandriamaster.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;


public class ScanFragment extends BaseFragment implements ScanContract.View {

    private ScanContract.Presenter mPresenter;

    @BindView(R.id.btn_scan)
    Button btnScan;


    public static ScanFragment newInstance() {
        return new ScanFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_scan, container, false);
        ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void setLoadingIndicator(boolean active) {

    }

    @Override
    public void setMessageError(String error) {

    }

    @Override
    public void setDialogMessage(String message) {

    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public void setPresenter(ScanContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void errorScanQr(String msg) {
        ((ScanActivity) getActivity()).showMessageError(msg);
    }

    @Override
    public void successScanQr(String msg) {
        ((ScanActivity) getActivity()).showMessageError(msg);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @OnClick(R.id.btn_scan)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_scan:
                getCodeQr();
                break;
        }
    }

    @Override
    public void getCodeQr() {
        IntentIntegrator integrator = new IntentIntegrator(getActivity());
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.setPrompt("Scan!!");
        integrator.setCameraId(0);
        integrator.setBeepEnabled(false);
        integrator.setBarcodeImageEnabled(false);
        integrator.initiateScan();
    }


}

