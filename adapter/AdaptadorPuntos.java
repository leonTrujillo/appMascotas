package com.coursera.semana3.mascotas1.adapter;






import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.coursera.semana3.mascotas1.R;
import com.coursera.semana3.mascotas1.pojo.Mascota;

import java.util.ArrayList;
import java.util.Random;

public class AdaptadorPuntos extends RecyclerView.Adapter<AdaptadorPuntos.PuntosViewHolder>{
    ArrayList<Mascota> puntosArrayList;
    Activity activity;
    public Mascota mas;


    public AdaptadorPuntos(ArrayList<Mascota> puntosArrayList, Activity activity) {
        this.puntosArrayList = puntosArrayList;
        this.activity = activity;


    }

    @NonNull
    @Override
    public PuntosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_puntuaciones, parent, false);
        return new PuntosViewHolder(v);
    }



    @Override
    public void onBindViewHolder(@NonNull PuntosViewHolder holder, int position) {
        mas = puntosArrayList.get(position);
        holder.foto.setImageResource(mas.getFoto());
        holder.puntos.setText(String.valueOf(mas.getRating()));
        holder.textoPuntos.setText(mas.getNombre());
        holder.hueso.setImageResource(R.drawable.huesoamarillo);
        cambiaColores((RelativeLayout)(ViewGroup)holder.foto.getParent(),position);

    }

    @Override
    public int getItemCount() {
        return puntosArrayList.size();
    }

    public void cambiaColores(View v ,int... posicion){
        Random r = new Random();
        int color= Color.argb(128,r.nextInt(256),r.nextInt(256),r.nextInt(256));
        v.setBackgroundColor(color);
    }

    public static class PuntosViewHolder extends RecyclerView.ViewHolder {
        private ImageView foto,hueso;
        private TextView puntos,textoPuntos;

        public PuntosViewHolder(@NonNull View itemView) {
            super(itemView);
            foto = (ImageView) itemView.findViewById(R.id.imgPuntosMascota);
            puntos = (TextView) itemView.findViewById(R.id.puntos);
            textoPuntos=(TextView) itemView.findViewById(R.id.textoMedio);
            hueso = (ImageView) itemView.findViewById(R.id.huesoPuntos);

        }
    }
}
