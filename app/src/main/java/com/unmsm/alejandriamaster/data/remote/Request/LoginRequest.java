package com.unmsm.alejandriamaster.data.remote.Request;


import com.unmsm.alejandriamaster.data.entities.loginData;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LoginRequest {

    @GET("/api/logins/")
    Call<ArrayList<loginData>> getLogin(@Query("filter[where][email]") String username,
                                        @Query("filter[where][password]") String password);

}
