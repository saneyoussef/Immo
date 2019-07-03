package com.example.immo.Models;

import com.google.gson.annotations.SerializedName;

public class JwtResponse {

    private String token;

    public JwtResponse() {
    }

    public String getJwttoken() {
        return token;
    }

    public void setJwttoken(String jwttoken) {
        this.token = token;
    }
}
