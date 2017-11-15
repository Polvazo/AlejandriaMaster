package com.unmsm.alejandriamaster.Presentation.Presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.unmsm.alejandriamaster.Data.Entities.bookData;
import com.unmsm.alejandriamaster.Data.Entities.loanData;
import com.unmsm.alejandriamaster.Data.Remote.Request.loanRequest;
import com.unmsm.alejandriamaster.Data.Remote.ServiceGenerator;
import com.unmsm.alejandriamaster.Presentation.Constans.ConstansGlobal;
import com.unmsm.alejandriamaster.Presentation.Contracs.LoanContract;
import com.unmsm.alejandriamaster.Presentation.Contracs.ScanContract;
import com.unmsm.alejandriamaster.Presentation.Utils.Preferences;

import java.util.ArrayList;

import okhttp3.ResponseBody;
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

        Log.i("estado", "loanData");
        loanRequest loanservice = ServiceGenerator.createService(loanRequest.class);
        Call<ArrayList<loanData>> call = loanservice.getLoan(idUser, idBook);
        call.enqueue(new Callback<ArrayList<loanData>>() {
            @Override
            public void onResponse(Call<ArrayList<loanData>> call, Response<ArrayList<loanData>> response) {
                if (response.isSuccessful()) {
                    Log.i("estado", "por aca entro");
                    prestamo = response.body();
                    if (!prestamo.isEmpty()) {
                        mLoanView.getTextView(prestamo.get(0).getUserData().getName() + prestamo.get(0).getUserData().getLastname(),
                                prestamo.get(0).getBookData().getAutor());
                        Preferences.Guardar(ConstansGlobal.idLoan, String.valueOf(prestamo.get(0).getIdLoan()), context);
                    }
                    mLoanView.setDialogMessage("Prestamo no encontrado");


                }
            }

            @Override
            public void onFailure(Call<ArrayList<loanData>> call, Throwable t) {

            }
        });
    }

    @Override
    public void pathLoan() {
        mLoanView.setLoadingIndicator(true);
        loanRequest loanservice = ServiceGenerator.createService(loanRequest.class);
        loanData general = new loanData(ConstansGlobal.estadoLoanCancel);
        Call<ResponseBody> call = loanservice.pathLoan(Integer.parseInt(Preferences.obtener(ConstansGlobal.idLoan, context)), general);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    mLoanView.setLoadingIndicator(false);
                    Log.i("pasoO", "se cambio de estado");
                    mLoanView.successLoginUser();
                    Toast.makeText(context, "Se ingreso correctamente", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    @Override
    public void pathLoanBook() {
        mLoanView.setLoadingIndicator(true);
        loanRequest loanservice = ServiceGenerator.createService(loanRequest.class);
        bookData general = new bookData(ConstansGlobal.estadoLoanCancel);
        Call<ResponseBody> call = loanservice.pathLibro(Integer.parseInt(Preferences.obtener(ConstansGlobal.idBook, context)), general);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    mLoanView.setLoadingIndicator(false);
                    Log.i("pasoO", "se cambio de estado");
                    mLoanView.successLoginUser();
                    Toast.makeText(context, "Se ingreso correctamente", Toast.LENGTH_SHORT).show();
                } else {

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    @Override
    public void start() {

    }
}
