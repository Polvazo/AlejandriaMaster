package com.unmsm.alejandriamaster.Data.Entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by USUARIO on 14/11/2017.
 */

public class loanData {
    @SerializedName("usuario")
    userData userData;

    @SerializedName("libro")
    bookData bookData;

    public com.unmsm.alejandriamaster.Data.Entities.userData getUserData() {
        return userData;
    }

    public void setUserData(com.unmsm.alejandriamaster.Data.Entities.userData userData) {
        this.userData = userData;
    }

    public com.unmsm.alejandriamaster.Data.Entities.bookData getBookData() {
        return bookData;
    }

    public void setBookData(com.unmsm.alejandriamaster.Data.Entities.bookData bookData) {
        this.bookData = bookData;
    }
}
