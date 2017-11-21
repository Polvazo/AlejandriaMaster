package com.unmsm.alejandriamaster.presentation.fragments;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.unmsm.alejandriamaster.core.BaseFragment;

import com.unmsm.alejandriamaster.presentation.activity.ScanActivity;

import com.unmsm.alejandriamaster.presentation.constans.ConstansGlobal;
import com.unmsm.alejandriamaster.presentation.contracs.LoanContract;

import com.unmsm.alejandriamaster.presentation.utils.Preferences;
import com.unmsm.alejandriamaster.R;


import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

public class LoanFragment extends BaseFragment implements LoanContract.View {


    private LoanContract.Presenter mPresenter;
    private TextView usuario;
    private TextView libro;
    Button ingresar;
    Button cancelar;
    private ProgressDialog dialog;
    private AlertDialog alertDialog;
    boolean isLoading = false;

    public static LoanFragment newInstance() {
        return new LoanFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_loan, container, false);
        usuario = (TextView) root.findViewById(R.id.txt_user);
        libro = (TextView) root.findViewById(R.id.txt_book);
        dialog = new ProgressDialog(getActivity());
        if (Preferences.obtener(ConstansGlobal.idUser, getActivity()) == null && Preferences.obtener(ConstansGlobal.idBook, getActivity()) == null) {
            Toast.makeText(getActivity(), R.string.problem, Toast.LENGTH_SHORT).show();
        }

        Log.i("estado", "paso por LoagnFramgemt para e post" + Preferences.obtener(ConstansGlobal.idBook, getActivity()));

        mPresenter.checkBook(Preferences.obtener(ConstansGlobal.idBook, getActivity()));

        // userid = Preferences.obtener(ConstansGlobal.idUser, getActivity());
        //bookid = Preferences.obtener(ConstansGlobal.idBook, getActivity());

        //mPresenter.getLoanData(Integer.parseInt(userid), Integer.parseInt(bookid));
        ingresar = (Button) root.findViewById(R.id.btn_prestamo);
        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.pathLoan();
                mPresenter.pathLoanBook();

            }
        });
        cancelar = (Button) root.findViewById(R.id.btn_cancelar);
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), R.string.cancel, Toast.LENGTH_SHORT).show();
                next(getActivity(), null, ScanActivity.class, true);
            }
        });
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        dialog.setIndeterminate(true);
        dialog.setMessage(getString(R.string.verificandoLibro));
        dialog.setCancelable(false);
        dialog.setIndeterminateDrawable(getResources().getDrawable(R.drawable.circle_progress));

        alertDialog = new AlertDialog.Builder(getActivity()).create();
        alertDialog.setTitle(getString(R.string.ALEJANDRIAMASTER));
        alertDialog.setCancelable(false);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, getString(R.string.Ok),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        next(getActivity(), null, ScanActivity.class, true);
                    }
                });
    }

    @Override
    public void successLoginUser() {
        next(getActivity(), null, ScanActivity.class, true);
    }

    @Override
    public void setLoadingIndicator(boolean active) {
        if (!active) {
            dialog.dismiss();
            isLoading = false;
        } else if (active) {
            isLoading = true;
            dialog.show();
        }
    }

    @Override
    public void setMessage(boolean active, String message) {
        if (!active) {
            alertDialog.setMessage(message);
            isLoading = false;
        } else if (active) {
            alertDialog.setMessage(message);
            alertDialog.show();
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

