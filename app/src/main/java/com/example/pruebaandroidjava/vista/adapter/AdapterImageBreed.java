package com.example.pruebaandroidjava.vista.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pruebaandroidjava.R;

import java.util.List;

public class AdapterImageBreed extends RecyclerView.Adapter<AdapterImageBreed.ViewHolderImagesBreed>   {
    List<String> imageBreedResponsePojos ;
    Context context;
    private View.OnLongClickListener listener;
    public AdapterImageBreed(List<String> imageBreedResponsePojos, Context context) {
        this.imageBreedResponsePojos = imageBreedResponsePojos;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolderImagesBreed onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_image,parent,false);
        return new ViewHolderImagesBreed(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolderImagesBreed holder, final int position) {
        final String fotoUrl =imageBreedResponsePojos.get(position);
        Glide.with(holder.imagenBreedView.getContext())
                .load(fotoUrl)
                .into(holder.imagenBreedView);
        holder.imagenBreedView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(context,"Cargando tu mascota", Toast.LENGTH_LONG).show();
                return false;
            }
        });
    }
    @Override
    public int getItemCount() {
        return imageBreedResponsePojos.size();
    }
    public class ViewHolderImagesBreed extends RecyclerView.ViewHolder {
        private ImageView imagenBreedView;
        public ViewHolderImagesBreed(@NonNull View itemView) {
            super(itemView);
            imagenBreedView = (ImageView)itemView.findViewById(R.id.ImageViewId);
        }
    }
}
