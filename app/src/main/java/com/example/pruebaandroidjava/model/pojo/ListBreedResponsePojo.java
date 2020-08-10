package com.example.pruebaandroidjava.model.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListBreedResponsePojo {

    @SerializedName("message")
    private List<String> ListaBreed;
    private String status;

    public ListBreedResponsePojo(List<String> listaBreed, String status) {
        ListaBreed = listaBreed;
        this.status = status;
    }

    public List<String> getListaBreed() {
        return ListaBreed;
    }

    public void setListaBreed(List<String> listaBreed) {
        ListaBreed = listaBreed;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

