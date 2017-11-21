package com.unmsm.alejandriamaster.data.remote.Request;

import com.unmsm.alejandriamaster.data.entities.bookData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface scanRequest {

    @GET("api/libros/{id}")
    Call<bookData> checkBook(@Path("id") String idBook);

}


