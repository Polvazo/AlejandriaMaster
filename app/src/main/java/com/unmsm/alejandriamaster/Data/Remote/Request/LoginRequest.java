package com.unmsm.alejandriamaster.Data.Remote.Request;


import com.unmsm.alejandriamaster.Data.Entities.loginData;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LoginRequest {

    @GET("/api/logins/")
    Call<ArrayList<loginData>> getLogin(@Query("filter[where][email]") String username,
                                        @Query("filter[where][password]") String password);

}
