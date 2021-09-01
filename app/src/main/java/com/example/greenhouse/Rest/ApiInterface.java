package com.example.greenhouse.Rest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("get/v1")
    Call<List<String>> getPh1();

    @GET("v2")
    Call<List<String>> getPh2();
    @GET("v3")
    Call<List<String>> getAir1();
    @GET("v4")
    Call<List<String>> getAir2();
    @GET("v5")
    Call<List<String>> getTds1();
    @GET("v6")
    Call<List<String>> getTds2();
    @GET("v7")
    Call<List<String>> getUdara();
    @GET("v8")
    Call<List<String>> getKelembaban();
}
