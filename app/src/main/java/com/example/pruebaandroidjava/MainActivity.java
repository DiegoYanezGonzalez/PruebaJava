package com.example.pruebaandroidjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.pruebaandroidjava.model.apiRetrofit.ApiGuau;
import com.example.pruebaandroidjava.model.apiRetrofit.RetrofitClient;
import com.example.pruebaandroidjava.model.pojo.ListBreedResponsePojo;
import com.example.pruebaandroidjava.vista.fragments.ListBreedFragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ApiGuau service = RetrofitClient.getRetrofitInstance().create(ApiGuau.class);
        Call<ListBreedResponsePojo> call = service.getListaRazas();
        call.enqueue(new Callback<ListBreedResponsePojo>() {
            @Override
            public void onResponse(Call<ListBreedResponsePojo> call, Response<ListBreedResponsePojo> response) {
                if (response.body() != null) {
                    List<String> perritos = response.body().getListaBreed();
                    Log.e("Perritos", String.valueOf(perritos));
                    initializeFragmentBreed(perritos);
                } else {
                    Log.e("Perritos", "es nulo");
                }
            }
            @Override
            public void onFailure(Call<ListBreedResponsePojo> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Fallo, vuelva a intentar", Toast.LENGTH_LONG).show();
                Log.e("Perritos", String.valueOf(t));
            }
        });
    }
    private void initializeFragmentBreed(List<String> listaPerritos) {
        ListBreedFragment listBreedFragment= ListBreedFragment.newInstance((ArrayList<String>) listaPerritos);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.text1,listBreedFragment,listBreedFragment.getClass().getSimpleName())
                .commit();
    }
}