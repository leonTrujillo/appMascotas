package com.coursera.semana3.mascotas1.basedatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.coursera.semana3.mascotas1.R;

import com.coursera.semana3.mascotas1.pojo.Mascota;

import java.util.ArrayList;

public class ConstructorMascotas {

    private Context cont;
    private static final int LIKE=1;
    private  ArrayList<Mascota> listaMascotasFavoritas;

    public ConstructorMascotas(Context cont) {
        this.cont=cont;
        listaMascotasFavoritas = new ArrayList<>();
    }

    public ArrayList<Mascota> obtenerDatos(){
        BaseDeDatos db = new BaseDeDatos(cont);
            metiendoMascotas(db);
            return db.obtenerMascotas();
    }

    public void actualizaPuntos(Mascota mascotaPuntuada,int puntos) {
           BaseDeDatos db = new BaseDeDatos(cont);
           SQLiteDatabase miDatabase = db.getWritableDatabase();
        ContentValues valoresParaActualizar = new ContentValues();
        valoresParaActualizar.put(ConstantesBaseDatos.PUNTUACION,puntos);

        miDatabase.execSQL("UPDATE "+ConstantesBaseDatos.TABLE
                +" SET puntos = "+"'"+puntos+"' "+ "WHERE id = "+"'"+mascotaPuntuada.idMascota+"'");

    }


    public void metiendoMascotas(BaseDeDatos db){
        //1
        ContentValues contentValues=new ContentValues();
        contentValues.put(ConstantesBaseDatos.NOMBRE,"Dog");
        contentValues.put(ConstantesBaseDatos.DESCRIPCION,"Un perro super simpatico");
        contentValues.put(ConstantesBaseDatos.FOTO,R.drawable.dog);
        contentValues.put(ConstantesBaseDatos.PUNTUACION,0);
        db.insertaMascotas(contentValues);
         //2
         contentValues=new ContentValues();
        contentValues.put(ConstantesBaseDatos.NOMBRE,"gato");
        contentValues.put(ConstantesBaseDatos.DESCRIPCION,"Es lo que ves...un gato");
        contentValues.put(ConstantesBaseDatos.FOTO,R.drawable.cat);
        contentValues.put(ConstantesBaseDatos.PUNTUACION,0);
        db.insertaMascotas(contentValues);
           //3
        contentValues=new ContentValues();
        contentValues.put(ConstantesBaseDatos.NOMBRE,"draco");
        contentValues.put(ConstantesBaseDatos.DESCRIPCION,"Monisimo ahora...ya veras cuando crezca!!");
        contentValues.put(ConstantesBaseDatos.FOTO,R.drawable.draco);
        contentValues.put(ConstantesBaseDatos.PUNTUACION,0);
        db.insertaMascotas(contentValues);
        //4
        contentValues=new ContentValues();
        contentValues.put(ConstantesBaseDatos.NOMBRE,"dino");
        contentValues.put(ConstantesBaseDatos.DESCRIPCION,"Pero tu lo has visto?? como te va a gustar eso???!!!");
        contentValues.put(ConstantesBaseDatos.FOTO,R.drawable.dino);
        contentValues.put(ConstantesBaseDatos.PUNTUACION,0);
        db.insertaMascotas(contentValues);
        //5
        contentValues=new ContentValues();
        contentValues.put(ConstantesBaseDatos.NOMBRE,"gizmo");
        contentValues.put(ConstantesBaseDatos.DESCRIPCION,"Un encanto...con sorpresa!!!");
        contentValues.put(ConstantesBaseDatos.FOTO,R.drawable.gremlin);
        contentValues.put(ConstantesBaseDatos.PUNTUACION,0);
        db.insertaMascotas(contentValues);

         //6
        contentValues=new ContentValues();
        contentValues.put(ConstantesBaseDatos.NOMBRE,"pluto");
        contentValues.put(ConstantesBaseDatos.DESCRIPCION,"Si quieres ser feliz olvidate de los demas,quedate con este!");
        contentValues.put(ConstantesBaseDatos.FOTO,R.drawable.pluto);
        contentValues.put(ConstantesBaseDatos.PUNTUACION,0);
        db.insertaMascotas(contentValues);
            //7
        contentValues=new ContentValues();
        contentValues.put(ConstantesBaseDatos.NOMBRE,"fluffy");
        contentValues.put(ConstantesBaseDatos.DESCRIPCION,"Mira,no se sabe ni lo que es...");
        contentValues.put(ConstantesBaseDatos.FOTO,R.drawable.beast);
        contentValues.put(ConstantesBaseDatos.PUNTUACION,0);
        db.insertaMascotas(contentValues);
         //8
        contentValues=new ContentValues();
        contentValues.put(ConstantesBaseDatos.NOMBRE,"mimi");
        contentValues.put(ConstantesBaseDatos.DESCRIPCION,"Como salgas a pasear con eso por la calle...enfin!!!");
        contentValues.put(ConstantesBaseDatos.FOTO,R.drawable.warbeastpng);
        contentValues.put(ConstantesBaseDatos.PUNTUACION,0);
        db.insertaMascotas(contentValues);

        //9
        contentValues=new ContentValues();
        contentValues.put(ConstantesBaseDatos.NOMBRE,"abrazitos");
        contentValues.put(ConstantesBaseDatos.DESCRIPCION,"No te fies,no le has visto enfadado,Es un oso!!!");
        contentValues.put(ConstantesBaseDatos.FOTO,R.drawable.bear1);
        contentValues.put(ConstantesBaseDatos.PUNTUACION,0);
        db.insertaMascotas(contentValues);

    }


}
