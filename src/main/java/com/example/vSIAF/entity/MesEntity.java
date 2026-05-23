package com.example.vSIAF.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mes")
public class MesEntity {

    @Id
    private Integer mes;
    private String nommes;

    public MesEntity() {
    }

    public MesEntity(Integer mes, String nommes) {
        this.mes = mes;
        this.nommes = nommes;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public String getNommes() {
        return nommes;
    }

    public void setNommes(String nommes) {
        this.nommes = nommes;
    }
}