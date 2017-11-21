package com.unmsm.alejandriamaster.Data.Remote.Request;

import com.unmsm.alejandriamaster.Data.Entities.bookData;
import com.unmsm.alejandriamaster.Data.Entities.loanData;

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
    Call<ArrayList<loanData>> getLoan(@Query("filter[where][usuarioId]") int username,
                                      @Query("filter[where][libroId]") int idbook);

    @PATCH("/api/prestamos/{id}/")
    Call<ResponseBody> pathLoan (@Path("id") Integer idLoan, @Body loanData loanData);

    @PATCH("/api/libros/{id}/")
    Call<ResponseBody> pathLibro (@Path("id") Integer idLoan, @Body bookData loanData);
}
