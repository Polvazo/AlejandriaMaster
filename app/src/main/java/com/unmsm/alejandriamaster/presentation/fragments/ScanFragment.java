package com.unmsm.alejandriamaster.presentation.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


import com.google.zxing.integration.android.IntentIntegrator;
import com.unmsm.alejandriamaster.core.BaseFragment;


import com.unmsm.alejandriamaster.presentation.contracs.ScanContract;

import com.unmsm.alejandriamaster.R;

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
        if(active){
        Toast.makeText(getActivity(), R.string.error, Toast.LENGTH_SHORT).show();}
    }

    @Override
    public void setMessageError(String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setDialogMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
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
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @OnClick(R.id.btn_scan)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_scan:
               mPresenter.getLoanData();
               break;
        }
    }

    public void getCodeQr() {
        IntentIntegrator integrator = new IntentIntegrator(getActivity());
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.setPrompt(getString(R.string.FISI));
        integrator.setCameraId(0);
        integrator.setBeepEnabled(false);
        integrator.setBarcodeImageEnabled(false);
        integrator.initiateScan();

    }


}

