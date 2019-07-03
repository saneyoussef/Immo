package com.example.immo.Service;

import com.example.immo.Models.JwtRequest;
import com.example.immo.Models.JwtResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthService {

    @POST("authenticate")
    Call<JwtResponse> authenticate(@Body JwtRequest request);
}
