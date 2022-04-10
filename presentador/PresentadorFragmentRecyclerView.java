package com.coursera.semana3.mascotas1.presentador;

import android.content.Context;

import com.coursera.semana3.mascotas1.basedatos.ConstructorMascotas;
import com.coursera.semana3.mascotas1.fragment.FragmentRecyclerViewInterface;

import com.coursera.semana3.mascotas1.pojo.Mascota;

import java.util.ArrayList;

public class PresentadorFragmentRecyclerView implements FragmentPresentadorInterface{


    private FragmentRecyclerViewInterface fri;
    private Context cont;
    private ConstructorMascotas construyeMascotas;
    private ArrayList<Mascota> masc;
    private ArrayList<Mascota> favoritas;

    public PresentadorFragmentRecyclerView(FragmentRecyclerViewInterface fri, Context cont) {
        this.fri=fri;
        this.cont=cont;
        obtenMascotasBaseDatos();
    }

    @Override
    public void obtenMascotasBaseDatos() {
          construyeMascotas=new ConstructorMascotas(cont);
          masc= construyeMascotas.obtenerDatos();
          mostrarMascotasEnRecyclerView();
    }

    @Override
    public void mostrarMascotasEnRecyclerView() {
      fri.iniciaAdaptador(fri.creaAdaptador(masc));
      fri.generarLinearLayoutVertical();
    }


}
