package com.unmsm.alejandriamaster.data.entities;

import com.google.gson.annotations.SerializedName;

public class BookData {

    @SerializedName("titulo")
    public String title;
    @SerializedName("autor")
    public String autor;
    @SerializedName("id")
    public Integer idBook;

    @SerializedName("estado")
    public boolean estado;

    public BookData(boolean estado) {
        this.estado = estado;
    }

    public Integer getIdBook() {
        return idBook;
    }

    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

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
