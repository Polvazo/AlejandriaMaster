package com.unmsm.alejandriamaster.Data.Remote.Request;

import com.unmsm.alejandriamaster.Data.Entities.loanData;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by USUARIO on 14/11/2017.
 */

public interface loanRequest {


    @GET("/api/prestamos/")
    Call<ArrayList<loanData>> getLoan(@Query("filter[where][usuarioId]") int username,
                                      @Query("filter[where][libroId]") int idbook);
}
