package com.coursera.semana3.mascotas1.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.coursera.semana3.mascotas1.R;
import com.coursera.semana3.mascotas1.adapter.AdaptadorPuntos;
import com.coursera.semana3.mascotas1.pojo.Mascota;

import java.util.ArrayList;

public class PerfilFragment extends Fragment {


    private RecyclerView listaPuntosMascota;
    ArrayList<Mascota> mascotas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_perfil,container,false);
        listaPuntosMascota=(RecyclerView) v.findViewById(R.id.gridParaMascotas);
        GridLayoutManager Gridanager=new GridLayoutManager(getActivity(),3);


        listaPuntosMascota.setLayoutManager(Gridanager);
        rellenaLista();
        inicializaAdaptador();
        return v;
    }

    public void inicializaAdaptador(){
        AdaptadorPuntos adaptador=new AdaptadorPuntos(mascotas,getActivity());
        listaPuntosMascota.setAdapter(adaptador);
    }
    public void rellenaLista(){
        mascotas=new ArrayList<Mascota>();
        mascotas.add(new Mascota(1,"bear","",R.drawable.bear1,1));
        mascotas.add(new Mascota(1,"love","",R.drawable.bear9,1));
        mascotas.add(new Mascota(1,"friend","",R.drawable.bear3,3));
        mascotas.add(new Mascota(1,"good","",R.drawable.bear4,0));
        mascotas.add(new Mascota(1,"Great","",R.drawable.bear5,2));
        mascotas.add(new Mascota(1,"pink","",R.drawable.bear6,0));
        mascotas.add(new Mascota(1,"bueno","",R.drawable.bear7,0));
        mascotas.add(new Mascota(1,"Mal dia","",R.drawable.angry_bear,6));
        mascotas.add(new Mascota(1,"mejor","",R.drawable.bear8,0));


    }


}