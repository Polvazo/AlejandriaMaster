package com.unmsm.alejandriamaster.data.remote.request;

import com.unmsm.alejandriamaster.data.entities.BookData;
import com.unmsm.alejandriamaster.data.entities.LoanData;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;
import retrofit2.http.Query;



public interface loanRequest {


    @GET("/api/prestamos/")
    Call<ArrayList<LoanData>> getLoan(@Query("filter[where][usuarioId]") int username,
                                      @Query("filter[where][libroId]") int idbook);

    @PATCH("/api/prestamos/{id}/")
    Call<ResponseBody> pathLoan (@Path("id") Integer idLoan, @Body LoanData loanData);

    @PATCH("/api/libros/{id}/")
    Call<ResponseBody> pathLibro (@Path("id") Integer idLoan, @Body BookData loanData);
}
