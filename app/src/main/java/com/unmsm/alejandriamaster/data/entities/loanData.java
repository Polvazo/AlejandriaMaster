package com.unmsm.alejandriamaster.data.entities;

import com.google.gson.annotations.SerializedName;



public class loanData {
    @SerializedName("usuario")
    userData userData;

    @SerializedName("libro")
    bookData bookData;

    @SerializedName("id")
    Integer idLoan;

    @SerializedName("estado")
    Boolean estado;

    public loanData(Boolean estado) {
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

    public com.unmsm.alejandriamaster.data.entities.userData getUserData() {
        return userData;
    }

    public void setUserData(com.unmsm.alejandriamaster.data.entities.userData userData) {
        this.userData = userData;
    }

    public com.unmsm.alejandriamaster.data.entities.bookData getBookData() {
        return bookData;
    }

    public void setBookData(com.unmsm.alejandriamaster.data.entities.bookData bookData) {
        this.bookData = bookData;
    }
}
