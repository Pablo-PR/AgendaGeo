package com.example.agendageo.ui.events;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "events_table")
public class Event {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "nombre")
    private String nombre;

    @ColumnInfo(name = "fecha")
    private long fecha;

    @ColumnInfo(name = "latitud")
    private double latitud;

    @ColumnInfo(name = "longitud")
    private double longitud;

    @ColumnInfo(name = "descripcion")
    private String descripcion;


    public Event(String nombre, long fecha, double latitud, double longitud, String descripcion) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.latitud = latitud;
        this.longitud = longitud;
        this.descripcion = descripcion;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getFecha() {
        return fecha;
    }

    public void setFecha(long fecha) {
        this.fecha = fecha;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(int latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
