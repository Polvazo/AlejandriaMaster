package com.unmsm.alejandriamaster.Data.Entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by USUARIO on 14/11/2017.
 */

public class userData {

    @SerializedName("nombre")
    public String name;
    @SerializedName("apellidos")
    public String lastname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
