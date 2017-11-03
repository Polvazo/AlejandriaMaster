package com.unmsm.alejandriamaster.Data.Remote.Request;


import com.unmsm.alejandriamaster.Data.Entities.loginData;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LoginRequest {

    @GET("/api/logins")
    Call<ArrayList<loginData>> getLogin();
}
