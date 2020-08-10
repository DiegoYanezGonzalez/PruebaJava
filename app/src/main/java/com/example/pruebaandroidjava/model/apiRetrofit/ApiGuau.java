package com.example.pruebaandroidjava.model.apiRetrofit;

import com.example.pruebaandroidjava.model.pojo.ImageBreedResponsePojo;
import com.example.pruebaandroidjava.model.pojo.ListBreedResponsePojo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiGuau {

    @GET("api/breeds/list/")
    Call<ListBreedResponsePojo> getListaRazas();

    @GET("api/breed({breed}/images/")
    Call<ImageBreedResponsePojo> getListaImagenesURL(@Path("breed")String breed);
}
