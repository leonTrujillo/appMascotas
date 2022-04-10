package com.coursera.semana3.mascotas1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;


import com.coursera.semana3.mascotas1.adapter.AdaptadorMascotas;
import com.coursera.semana3.mascotas1.fragment.FragmentRecyclerViewInterface;

import com.coursera.semana3.mascotas1.pojo.Mascota;
import com.coursera.semana3.mascotas1.presentador.PresentadorFragmentRecyclerView;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity implements FragmentRecyclerViewInterface {
      private RecyclerView listaFavoritos;
      ArrayList<Mascota>mascota;
      PresentadorFragmentRecyclerView presen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mascotas_favoritas);
         creabarra();
        listaFavoritos=(RecyclerView) findViewById(R.id.favoritosRecycler);
        generarLinearLayoutVertical();
        presen=new PresentadorFragmentRecyclerView(this,this);
    }

    private void creabarra(){

        Toolbar myToolbar=(Toolbar)findViewById(R.id.miActionBar);
        myToolbar.setNavigationIcon(R.drawable.atras);
        ImageView star=new ImageView(this);
        star.setImageResource(R.drawable.cincoestrella);
        Toolbar.LayoutParams tbl=new Toolbar.LayoutParams(Toolbar.LayoutParams.WRAP_CONTENT, Toolbar.LayoutParams.WRAP_CONTENT);
        tbl.gravity= Gravity.END;
        star.setLayoutParams(tbl);
        myToolbar.addView(star);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager myLinearManager=new LinearLayoutManager(this);
        myLinearManager.setOrientation(LinearLayoutManager.VERTICAL);
        listaFavoritos.setLayoutManager(myLinearManager);
         creaAdaptador(mascota);
    }

    @Override
    public AdaptadorMascotas creaAdaptador(ArrayList<Mascota> mascota) {
        AdaptadorMascotas adaptador=new AdaptadorMascotas(mascota,this);
        return adaptador;
    }

    @Override
    public void iniciaAdaptador(AdaptadorMascotas adaptador) {
        listaFavoritos.setAdapter(adaptador);
    }
}