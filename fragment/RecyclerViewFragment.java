package com.coursera.semana3.mascotas1.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.coursera.semana3.mascotas1.R;
import com.coursera.semana3.mascotas1.adapter.AdaptadorMascotas;
import com.coursera.semana3.mascotas1.pojo.Mascota;
import com.coursera.semana3.mascotas1.presentador.PresentadorFragmentRecyclerView;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment implements FragmentRecyclerViewInterface {

    private RecyclerView listaMascotas;
    ArrayList<Mascota> mascota;
    PresentadorFragmentRecyclerView presen;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_recyclerview,container,false);
        listaMascotas=(RecyclerView) v.findViewById(R.id.recyclerViewMascotas);
       generarLinearLayoutVertical();
        presen=new PresentadorFragmentRecyclerView(this,getContext());
        return v;
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager myLinearManager=new LinearLayoutManager(getActivity());
        myLinearManager.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(myLinearManager);
        creaAdaptador(mascota);
    }

    @Override
    public AdaptadorMascotas creaAdaptador(ArrayList<Mascota> mascotas) {
        AdaptadorMascotas adaptador=new AdaptadorMascotas(mascotas,getActivity());
        return adaptador;
    }

    @Override
    public void iniciaAdaptador(AdaptadorMascotas adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}