package com.example.immo.Service;

import com.example.immo.Models.JwtRequest;
import com.example.immo.Models.JwtResponse;
import com.example.immo.Models.RegisterRequest;
import com.example.immo.Models.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthService {

    @POST("authenticate")
    Call<JwtResponse> authenticate(@Body JwtRequest request);

    @POST("register")
    Call<RegisterResponse> register(@Body RegisterRequest request);
}
