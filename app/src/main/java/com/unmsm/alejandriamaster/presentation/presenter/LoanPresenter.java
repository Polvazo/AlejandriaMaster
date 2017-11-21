package com.unmsm.alejandriamaster.presentation.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.unmsm.alejandriamaster.data.entities.BookData;
import com.unmsm.alejandriamaster.data.entities.LoanData;
import com.unmsm.alejandriamaster.data.remote.request.LoanRequest;
import com.unmsm.alejandriamaster.data.remote.request.ScanRequest;
import com.unmsm.alejandriamaster.data.remote.ServiceGenerator;
import com.unmsm.alejandriamaster.presentation.constans.ConstansGlobal;
import com.unmsm.alejandriamaster.presentation.contracs.LoanContract;
import com.unmsm.alejandriamaster.presentation.utils.Preferences;
import com.unmsm.alejandriamaster.R;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoanPresenter implements LoanContract.Presenter {
    private final LoanContract.View mLoanView;
    private Context context;
    private ArrayList<LoanData> prestamo;
    private BookData bookdata;
    private String userid;

    public LoanPresenter(LoanContract.View mLoanView, @NonNull Context context) {
        this.mLoanView = mLoanView;
        this.context = context;
        this.mLoanView.setPresenter(this);
    }

    @Override
    public void checkBook(String idBook) {

        mLoanView.setLoadingIndicator(true);
        ScanRequest scanrequest = ServiceGenerator.createService(ScanRequest.class);
        Call<BookData> call = scanrequest.checkBook(idBook);
        Log.i("estado", "LoanData");
        call.enqueue(new Callback<BookData>() {
            @Override
            public void onResponse(Call<BookData> call, Response<BookData> response) {
                Log.i("estadoLoanData", String.valueOf(response.code()));
                if (response.isSuccessful()) {
                    Log.i("estado", "por aca entro");
                    bookdata = response.body();
                    assert bookdata != null;
                    if (bookdata.isEstado()) {
                        mLoanView.setLoadingIndicator(false);
                        mLoanView.setMessage(true, context.getString(R.string.Disponiblidad));
                    } else {
                        userid = Preferences.obtener(ConstansGlobal.idUser, context);
                        mLoanView.setLoadingIndicator(false);
                        getLoanData(Integer.parseInt(userid), bookdata.getIdBook());
                    }


                }
                if (response.code() == 404) {
                    mLoanView.setLoadingIndicator(false);
                    mLoanView.setMessage(true, context.getString(R.string.Ocupado));
                }
            }

            @Override
            public void onFailure(Call<BookData> call, Throwable t) {
                mLoanView.setLoadingIndicator(false);
                Toast.makeText(context, R.string.errorConexion, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void getLoanData(int idUser, int idBook) {

        Log.i("estado", "LoanData");
        LoanRequest loanservice = ServiceGenerator.createService(LoanRequest.class);
        Call<ArrayList<LoanData>> call = loanservice.getLoan(idUser, idBook);
        call.enqueue(new Callback<ArrayList<LoanData>>() {
            @Override
            public void onResponse(Call<ArrayList<LoanData>> call, Response<ArrayList<LoanData>> response) {
                if (response.isSuccessful()) {
                    Log.i("estado", "por aca entro");
                    prestamo = response.body();
                    if (!prestamo.isEmpty()) {
                        mLoanView.getTextView(prestamo.get(0).getUserData().getName() + " " + prestamo.get(0).getUserData().getLastname(),
                                prestamo.get(0).getBookData().getTitle() + " - " + prestamo.get(0).getBookData().getAutor());
                        Preferences.guardar(ConstansGlobal.idLoan, String.valueOf(prestamo.get(0).getIdLoan()), context);
                    } else {
                        mLoanView.setMessage(true, context.getString(R.string.noExiste));
                    }


                }
            }

            @Override
            public void onFailure(Call<ArrayList<LoanData>> call, Throwable t) {
                mLoanView.setLoadingIndicator(false);
                Toast.makeText(context, R.string.errorConexion, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void pathLoan() {
        mLoanView.setLoadingIndicator(true);
        LoanRequest loanservice = ServiceGenerator.createService(LoanRequest.class);
        LoanData general = new LoanData(ConstansGlobal.estadoLoanCancel);
        Call<ResponseBody> call = loanservice.pathLoan(Integer.parseInt(Preferences.obtener(ConstansGlobal.idLoan, context)), general);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    mLoanView.setLoadingIndicator(false);
                    Log.i("pasoO", "se cambio de estado");
                    mLoanView.successLoginUser();
                    Toast.makeText(context, R.string.Correcto, Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                mLoanView.setLoadingIndicator(false);
                Toast.makeText(context, R.string.errorConexion, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void pathLoanBook() {
        mLoanView.setLoadingIndicator(true);
        LoanRequest loanservice = ServiceGenerator.createService(LoanRequest.class);
        BookData general = new BookData(ConstansGlobal.estadoLoanCancel);
        Call<ResponseBody> call = loanservice.pathLibro(Integer.parseInt(Preferences.obtener(ConstansGlobal.idBook, context)), general);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    mLoanView.setLoadingIndicator(false);
                    Log.i("pasoO", "se cambio de estado");
                    mLoanView.successLoginUser();
                    Toast.makeText(context, R.string.Corecto, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                mLoanView.setLoadingIndicator(false);
                Toast.makeText(context, R.string.errorConexion, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void start() {

    }
}
