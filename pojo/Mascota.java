package com.coursera.semana3.mascotas1.pojo;

import androidx.annotation.Nullable;

public class Mascota {
    public String nombre;
    public String descripcion;
    public int foto;
    public int rating;
    public int idMascota;
    public Mascota(int idMascota,String nombre,String descripcion, int foto,int rating) {
        this.idMascota=idMascota;
        this.nombre = nombre;
        this.foto = foto;
        this.rating = rating;
    }

    public Mascota(){

    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


}
