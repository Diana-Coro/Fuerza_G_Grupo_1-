package com.example.vSIAF.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "unidadadmin")
public class UnidadadminEntity {

    private Long entidad;

    @Id
    private Long unidad;

    private String descrip;
    private String ciudad;

    public UnidadadminEntity() {
    }

    public UnidadadminEntity(Long entidad, Long unidad, String descrip, String ciudad) {
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