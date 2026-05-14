package com.example.vSIAF.model;

public class Entidad {

    private long gestion;
    private long entidad;
    private String descripcion;
    private String sigla;

    public Entidad() {

    }

    public Entidad(long gestion, long entidad, String descripcion, String sigla) {
        this.gestion = gestion;
        this.entidad = entidad;
        this.descripcion = descripcion;
        this.sigla = sigla;
    }

    public long getGestion() {
        return this.gestion;
    }

    public long getEntidad() {
        return this.entidad;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public String getSigla() {
        return this.sigla;
    }

    public void setGestion(long gestion) {
        this.gestion = gestion;
    }

    public void setEntidad(long entidad) {
        this.entidad = entidad;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}