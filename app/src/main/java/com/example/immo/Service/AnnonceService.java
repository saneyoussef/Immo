package com.example.immo.Service;

import com.example.immo.Models.AnnonceResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AnnonceService {

    @GET("getAllAnnonce")
    Call<List<AnnonceResponse>> getAllAnnonce();
}
