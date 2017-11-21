package com.unmsm.alejandriamaster.data.remote.request;

import com.unmsm.alejandriamaster.data.entities.BookData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface scanRequest {

    @GET("api/libros/{id}")
    Call<BookData> checkBook(@Path("id") String idBook);

}


