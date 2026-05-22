package com.example.vSIAF.model;

public class Unidadadmin {

    private Long entidad;
    private Long unidad;
    private String descrip;
    private String ciudad;

    public Unidadadmin() {
    }

    public Unidadadmin(Long entidad, Long unidad, String descrip, String ciudad) {
        this.entidad = entidad;
        this.unidad = unidad;
        this.descrip = descrip;
        this.ciudad = ciudad;
    }

    public Long getEntidad() {
        return entidad;
    }

    public void setEntidad(Long entidad) {
        this.entidad = entidad;
    }

    public Long getUnidad() {
        return unidad;
    }

    public void setUnidad(Long unidad) {
        this.unidad = unidad;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}