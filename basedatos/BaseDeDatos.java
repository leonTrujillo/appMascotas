package com.coursera.semana3.mascotas1.basedatos;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


import com.coursera.semana3.mascotas1.adapter.AdaptadorMascotas;
import com.coursera.semana3.mascotas1.pojo.Mascota;

import java.util.ArrayList;

public class BaseDeDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDeDatos(@Nullable Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase miDatabase) {


            String crearTablaMascotas = "CREATE TABLE " + ConstantesBaseDatos.TABLE + "(" +
                    ConstantesBaseDatos.ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    ConstantesBaseDatos.NOMBRE + " TEXT," +
                    ConstantesBaseDatos.DESCRIPCION + " TEXT," +
                    ConstantesBaseDatos.PUNTUACION + " INTEGER," +
                    ConstantesBaseDatos.FOTO + " INTEGER)";
            miDatabase.execSQL(crearTablaMascotas);


    }

    @Override
    public void onUpgrade(SQLiteDatabase miDatabase, int i, int i1) {
         miDatabase.execSQL("DROP TABLE IF EXISTS "+ConstantesBaseDatos.DATABASE_NAME);
    }

    public ArrayList<Mascota>obtenerMascotas(){
        ArrayList<Mascota>mascotas=new ArrayList<>();

        String query ="SELECT * FROM "+ConstantesBaseDatos.TABLE;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor registros=db.rawQuery(query,null);

        while (registros.moveToNext()){
            Mascota mascotaActual=new Mascota();
            mascotaActual.setIdMascota(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setDescripcion(registros.getString(2));
            mascotaActual.setRating(registros.getInt(3));
            mascotaActual.setFoto(registros.getInt(4));
            mascotas.add(mascotaActual);
        }
          db.close();
        return mascotas;
    }

    public void insertaMascotas(ContentValues contentValues){
        SQLiteDatabase db=this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE,null,contentValues);
        db.close();
    }

}
