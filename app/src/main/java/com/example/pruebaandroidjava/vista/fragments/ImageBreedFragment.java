package com.example.pruebaandroidjava.vista.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pruebaandroidjava.R;
import com.example.pruebaandroidjava.vista.adapter.AdapterImageBreed;

import java.util.ArrayList;
import java.util.List;


public class ImageBreedFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private List<String> responsePerritosImage = new ArrayList<>();
    private AdapterImageBreed imageAdapter;
    private ArrayList<String> mParam1;
    private RecyclerView recyclerViewImage;
    public ImageBreedFragment() {
    }
    public static ImageBreedFragment newInstance(List<String> param1) {
        ImageBreedFragment fragment = new ImageBreedFragment();
        Bundle args = new Bundle();
        args.putStringArrayList(ARG_PARAM1, (ArrayList<String>) param1);
        Log.e("Image", String.valueOf(param1));
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getStringArrayList(ARG_PARAM1);
            responsePerritosImage = mParam1;
            Log.e("Recibo Images", String.valueOf(responsePerritosImage));
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image_breed, container, false);
        recyclerViewImage = (RecyclerView) view.findViewById(R.id.recyclerId2);
        recyclerViewImage.setLayoutManager(new LinearLayoutManager(getContext()));
        imageAdapter = new AdapterImageBreed(responsePerritosImage, getContext());
        recyclerViewImage.setAdapter(imageAdapter);
        return view; }
}