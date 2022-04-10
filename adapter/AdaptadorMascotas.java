package com.coursera.semana3.mascotas1.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.coursera.semana3.mascotas1.basedatos.BaseDeDatos;
import com.coursera.semana3.mascotas1.basedatos.ConstructorMascotas;
import com.coursera.semana3.mascotas1.pojo.Mascota;
import com.coursera.semana3.mascotas1.R;

import java.util.ArrayList;
import java.util.Random;

public class AdaptadorMascotas extends RecyclerView.Adapter<AdaptadorMascotas.MascotaViewHolder> {
    ArrayList<Mascota> mascotaArrayList;
    Activity activity;
    BaseDeDatos db;

    public AdaptadorMascotas(ArrayList<Mascota> mascotaArrayList, Activity activity) {
        this.mascotaArrayList = mascotaArrayList;
        this.activity = activity;
        db=new BaseDeDatos(activity.getApplicationContext());

    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaViewHolder, int position) {
        Mascota mas = mascotaArrayList.get(position);
        mascotaViewHolder.foto.setImageResource(mas.getFoto());
        mascotaViewHolder.nombre.setText(mas.getNombre());
        mascotaViewHolder.rating.setText(String.valueOf(mas.getRating()));
        cambiaColores((RelativeLayout)(ViewGroup)mascotaViewHolder.foto.getParent(),position);


        mascotaViewHolder.foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, mas.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });

        mascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Context cont =activity.getApplicationContext();
               try {
                   if (mascotaViewHolder.favName.equals(String.valueOf(R.drawable.huesoblanco))) {
                       Toast.makeText(activity, "Has Añdido a favoritos a: " + mas.getNombre(), Toast.LENGTH_SHORT).show();
                       mascotaViewHolder.btnLike.setImageResource(R.drawable.cincoestrella);
                       mascotaViewHolder.favName=String.valueOf(R.drawable.cincoestrella);

                   } else {
                       Toast.makeText(activity, "Has quitado de favoritos a: " + mas.getNombre(), Toast.LENGTH_SHORT).show();
                       mascotaViewHolder.btnLike.setImageResource(R.drawable.huesoblanco);
                       mascotaViewHolder.favName=String.valueOf(R.drawable.huesoblanco);
                   }
               }catch(Exception e){
                   mascotaViewHolder.nombre.setText(e.toString());
               }
            }
        });

        mascotaViewHolder.btnRate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Has puntuado a: " + mas.getNombre(), Toast.LENGTH_SHORT).show();
                mas.setRating(mas.getRating()+1);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotaArrayList.size();
    }



    public void cambiaColores(View v ,int... posicion){
        Random r = new Random();
        int color= Color.argb(128,r.nextInt(256),r.nextInt(256),r.nextInt(256));
        v.setBackgroundColor(color);
    }



    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        private ImageView  foto;
        private TextView nombre, rating;
        private ImageButton btnLike, btnRate;
        String favName;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            foto = (ImageView) itemView.findViewById(R.id.imgFoto);
            nombre = (TextView) itemView.findViewById(R.id.suNombre);
            rating = (TextView) itemView.findViewById(R.id.suRating);
            btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);
            btnLike.setTag(R.drawable.huesoblanco);
            favName=String.valueOf(btnLike.getTag());
            btnRate = (ImageButton) itemView.findViewById(R.id.btnRate);
        }
    }
}
