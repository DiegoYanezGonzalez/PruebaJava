package com.example.pruebaandroidjava.vista.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.pruebaandroidjava.R;
import com.example.pruebaandroidjava.model.apiRetrofit.ApiGuau;
import com.example.pruebaandroidjava.model.apiRetrofit.RetrofitClient;
import com.example.pruebaandroidjava.model.pojo.ImageBreedResponsePojo;
import com.example.pruebaandroidjava.model.pojo.ListBreedResponsePojo;
import com.example.pruebaandroidjava.vista.adapter.AdapterListBreed;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ListBreedFragment extends Fragment implements AdapterListBreed.OnClick {

    private  static final String ARG_PARAM1 = "param1";
    private ArrayList<String> mparam1;
    private AdapterListBreed adapter;
    private RecyclerView recyclerView;
    private List<String> perritos = new ArrayList<>();

    public ListBreedFragment() { }

    public static ListBreedFragment newInstance(ArrayList<String> param1) {
        ListBreedFragment fragment = new ListBreedFragment();
        Bundle args = new Bundle();
        args.putStringArrayList(ARG_PARAM1, (ArrayList<String>)param1);
        Log.e("ListBreedFragment",String.valueOf(param1));
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toast.makeText(getContext(),"Elije la mascota que más te guste",Toast.LENGTH_LONG).show();
        ApiGuau service = RetrofitClient.getRetrofitInstance().create(ApiGuau.class);
        Call<ListBreedResponsePojo> call = service.getListaRazas();
        if (getArguments() != null){
            mparam1 = getArguments().getStringArrayList(ARG_PARAM1);
        }

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_list_breed,container,false);
               recyclerView = view.findViewById(R.id.recyclerId);

       Log.e("Algo Paso,",String.valueOf(perritos.size()));

       adapter= new AdapterListBreed(mparam1,getContext(),this);
       recyclerView.setAdapter(adapter);
       recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        return view;
    }
    public void onClick(String dog){
        Toast.makeText(getContext(),dog,Toast.LENGTH_LONG).show();
        imageBreed(dog);
    }
    private void imageBreed(final String dogName) {
        ApiGuau service = RetrofitClient.getRetrofitInstance().create(ApiGuau.class);
        Call<ImageBreedResponsePojo> callImages = service.getListaImagenesURL(dogName);
        callImages.enqueue(new Callback<ImageBreedResponsePojo>() {
            @Override
            public void onResponse(Call<ImageBreedResponsePojo> call, Response<ImageBreedResponsePojo> response) {
                List<String> listaImagenesUrl = response.body().getListaImagenesURL();

                Log.e("ImagesPerros",String.valueOf(listaImagenesUrl));

                initImageFragment(listaImagenesUrl);
            }

            @Override
            public void onFailure(Call<ImageBreedResponsePojo> call, Throwable t) {

                Log.e("Fallo",String.valueOf(t));
            }
        });
    }
    private void initImageFragment(List<String> listaPerri){
        ImageBreedFragment secondFragment = ImageBreedFragment.newInstance(listaPerri);
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.text1,secondFragment,"SECONDfRAGMENT")
                .addToBackStack("SECONDFRAGMENT")
                .commit();
    }
}