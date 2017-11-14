package com.unmsm.alejandriamaster.Presentation.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.unmsm.alejandriamaster.Core.BaseFragment;

import com.unmsm.alejandriamaster.Presentation.Activity.ScanActivity;

import com.unmsm.alejandriamaster.Presentation.Constans.ConstansGlobal;
import com.unmsm.alejandriamaster.Presentation.Contracs.LoanContract;

import com.unmsm.alejandriamaster.Presentation.Utils.Preferences;
import com.unmsm.alejandriamaster.R;


import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

public class LoanFragment extends BaseFragment implements LoanContract.View {


    private LoanContract.Presenter mPresenter;
    private TextView usuario;
    private TextView libro;
    private Button ingresar;
    private String userid;
    private String bookid;

    public static LoanFragment newInstance() {
        return new LoanFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_loan, container, false);
        usuario = (TextView) root.findViewById(R.id.txt_user);
        libro = (TextView) root.findViewById(R.id.txt_book);

        if (Preferences.obtener(ConstansGlobal.idUser, getActivity()) == null && Preferences.obtener(ConstansGlobal.idBook, getActivity()) == null) {
            Toast.makeText(getActivity(), "Hubo un problema", Toast.LENGTH_SHORT).show();
        }

        userid = Preferences.obtener(ConstansGlobal.idUser, getActivity());
        bookid = Preferences.obtener(ConstansGlobal.idBook, getActivity());
        mPresenter.getLoanData(Integer.parseInt(userid), Integer.parseInt(bookid));

        ingresar = (Button) root.findViewById(R.id.btn_prestamo);
        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
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
    public void setPresenter(LoanContract.Presenter presenter) {
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
    public void getTextView(String user, String book) {
        if (usuario != null && libro != null) {
            usuario.setText(user);
            libro.setText(book);
        }

    }


    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }


}

