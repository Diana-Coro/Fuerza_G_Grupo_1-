package com.example.vSIAF.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "entidades")
public class EntidadEntity {

    private long gestion;

    @Id
    private long entidad;

    private String descripcion;
    private String sigla;


    public EntidadEntity() {
    }


    public EntidadEntity(long gestion, long entidad, String descripcion, String sigla) {
        this.gestion = gestion;
        this.entidad = entidad;
        this.descripcion = descripcion;
        this.sigla = sigla;
    }


    public long getGestion() {
        return this.gestion;
    }

    public void setGestion(long gestion) {
        this.gestion = gestion;
    }

    public long getEntidad() {
        return this.entidad;
    }

    public void setEntidad(long endian) {
        this.entidad = endian;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSigla() {
        return this.sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}
