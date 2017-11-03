package com.unmsm.alejandriamaster.Data.Entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by USUARIO on 03/11/2017.
 */

public class loginData {

    @SerializedName("cod_usuario")
    public Long codUsuario;
    @SerializedName("email")
    public String email;
    @SerializedName("password")
    public String password;
    @SerializedName("id")
    public Integer id;
    @SerializedName("usuarioId")
    public Integer usuarioId;

    public Long getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Long codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }
}
