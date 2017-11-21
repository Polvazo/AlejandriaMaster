package com.unmsm.alejandriamaster.data.entities;

import com.google.gson.annotations.SerializedName;

public class UserData {

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
