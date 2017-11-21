package com.unmsm.alejandriamaster.data.remote.request;


import com.unmsm.alejandriamaster.data.entities.LoginData;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LoginRequest {

    @GET("/api/logins/")
    Call<ArrayList<LoginData>> getLogin(@Query("filter[where][email]") String username,
                                        @Query("filter[where][password]") String password);

}
