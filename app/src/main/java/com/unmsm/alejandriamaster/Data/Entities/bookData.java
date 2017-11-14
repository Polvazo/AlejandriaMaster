package com.unmsm.alejandriamaster.Data.Entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by USUARIO on 14/11/2017.
 */

public class bookData {

    @SerializedName("titulo")
    public String title;
    @SerializedName("autor")
    public String autor;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
