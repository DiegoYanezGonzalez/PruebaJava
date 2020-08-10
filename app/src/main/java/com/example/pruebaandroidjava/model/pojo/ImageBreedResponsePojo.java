package com.example.pruebaandroidjava.model.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ImageBreedResponsePojo {

    @SerializedName("message")
    private List<String> listaImagenesURL;
    private String status;

    public ImageBreedResponsePojo(List<String> listaImagenesURL, String status) {
        this.listaImagenesURL = listaImagenesURL;
        this.status = status;
    }
    public List<String> getListaImagenesURL(){
        return listaImagenesURL;
    }

    public void setListaImagenesURL(List<String> listaImagenesURL) {
        this.listaImagenesURL = listaImagenesURL;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
