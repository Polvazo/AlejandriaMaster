package com.unmsm.alejandriamaster.Data.Remote.Request;

import com.unmsm.alejandriamaster.Data.Entities.bookData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface scanRequest {

    @GET("api/libros/{id}")
    Call<bookData> checkBook(@Path("id") String idBook);

}


