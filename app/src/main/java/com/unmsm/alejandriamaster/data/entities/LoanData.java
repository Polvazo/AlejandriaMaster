package com.unmsm.alejandriamaster.data.entities;

import com.google.gson.annotations.SerializedName;



public class LoanData {
    @SerializedName("usuario")
    UserData userData;

    @SerializedName("libro")
    BookData bookData;

    @SerializedName("id")
    Integer idLoan;

    @SerializedName("estado")
    Boolean estado;

    public LoanData(Boolean estado) {
        this.estado = estado;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Integer getIdLoan() {
        return idLoan;
    }

    public void setIdLoan(Integer idLoan) {
        this.idLoan = idLoan;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public BookData getBookData() {
        return bookData;
    }

    public void setBookData(BookData bookData) {
        this.bookData = bookData;
    }
}
