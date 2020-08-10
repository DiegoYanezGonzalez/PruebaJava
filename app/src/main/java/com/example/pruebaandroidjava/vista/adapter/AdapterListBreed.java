package com.example.pruebaandroidjava.vista.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pruebaandroidjava.R;


import java.util.List;

public class AdapterListBreed<OnClick> extends RecyclerView.Adapter<AdapterListBreed.ViewHolderListBreed> {

    private List<String> breedResponseList;
    private Context context;
    private OnClick listener;

    public AdapterListBreed(List<String> breedResponseList, Context context, OnClick listener) {
        this.breedResponseList = breedResponseList;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AdapterListBreed.ViewHolderListBreed onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_list,null,false);
        return new ViewHolderListBreed(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterListBreed.ViewHolderListBreed holder, final int position) {
holder.Data(breedResponseList.get(position));
holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
     //   listener.OnClick(breedResponseList.get(position));
    }
});
    }

    @Override
    public int getItemCount() {
        return breedResponseList.size();
    }

    public class ViewHolderListBreed extends RecyclerView.ViewHolder {
        private TextView dato;

        private ViewHolderListBreed(@NonNull View itemView) {
            super(itemView);
            dato = (TextView) itemView.findViewById(R.id.perroText);
        }

        private void Data(String datos) {
            dato.setText(datos);
        }
    }
public interface OnClick{
        void onClick(String nombrePerro);
}
}
