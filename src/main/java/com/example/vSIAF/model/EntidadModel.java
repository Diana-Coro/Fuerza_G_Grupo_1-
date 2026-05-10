package com.example.vSIAF.model;

public class EntidadModel {

    private long gestion;
    private long entidad;
    private String descripcion;
    private String sigla;

    public EntidadModel(){

    }
    public EntidadModel(long gestion, long entidad, String descripcion, String sigla){
        this.gestion = gestion;
        this.entidad = entidad;
        this.descripcion = descripcion;
        this.sigla = sigla;
    }


    public long getGestion(){return this.gestion;}
    public long getEntidad(){return  this.entidad;}
    public String getDescripcion(){return  this.descripcion;}
    public String getSigla(){return this.sigla;}


    public void setGestion(long gestion){this.gestion = this.gestion;}
    public void setEntidad(long entidad){this.entidad = this.entidad;}
    public void setDescripcion(String descripcion){this.descripcion = this.descripcion;}
    public void setSigla(String sigla){this.sigla = this.sigla;}
}
