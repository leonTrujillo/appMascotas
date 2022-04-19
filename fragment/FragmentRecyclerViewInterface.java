package com.coursera.semana3.mascotas1.fragment;


import com.coursera.semana3.mascotas1.adapter.AdaptadorMascotas;

import com.coursera.semana3.mascotas1.pojo.Mascota;

import java.util.ArrayList;

public interface FragmentRecyclerViewInterface {

    public void generarLinearLayoutVertical();
    public AdaptadorMascotas creaAdaptador(ArrayList<Mascota> favoritos);
    public void iniciaAdaptador(AdaptadorMascotas adaptador);

}
