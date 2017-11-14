package com.unmsm.alejandriamaster.Presentation.Presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.unmsm.alejandriamaster.Data.Entities.loanData;
import com.unmsm.alejandriamaster.Data.Remote.Request.loanRequest;
import com.unmsm.alejandriamaster.Data.Remote.ServiceGenerator;
import com.unmsm.alejandriamaster.Presentation.Contracs.LoanContract;
import com.unmsm.alejandriamaster.Presentation.Contracs.ScanContract;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by USUARIO on 14/11/2017.
 */

public class LoanPresenter implements LoanContract.Presenter {
    private final LoanContract.View mLoanView;
    private Context context;
    private ArrayList<loanData> prestamo;

    public LoanPresenter(LoanContract.View mLoanView, @NonNull Context context) {
        this.mLoanView = mLoanView;
        this.context = context;
        this.mLoanView.setPresenter(this);
    }

    @Override
    public void getLoanData(int idUser, int idBook) {

        Log.i("estado","loanData");
        final loanRequest loanservice = ServiceGenerator.createService(loanRequest.class);
        Call<ArrayList<loanData>> call = loanservice.getLoan(idUser,idBook);
        call.enqueue(new Callback<ArrayList<loanData>>() {
            @Override
            public void onResponse(Call<ArrayList<loanData>> call, Response<ArrayList<loanData>> response) {
                if(response.isSuccessful()){
                    Log.i("estado","por aca entro");
                    prestamo= response.body();
                    mLoanView.getTextView(prestamo.get(0).getUserData().getName()+prestamo.get(0).getUserData().getLastname(),
                            prestamo.get(0).getBookData().getAutor());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<loanData>> call, Throwable t) {

            }
        });
    }

    @Override
    public void start() {

    }
}
