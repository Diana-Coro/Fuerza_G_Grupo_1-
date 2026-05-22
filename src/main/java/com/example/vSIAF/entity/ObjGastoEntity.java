package com.example.vSIAF.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "objgasto")
public class ObjGastoEntity {

    @Id
    private String Partida;
    private Integer Gestion;
    private String Descrip;

    public ObjGastoEntity() {
    }

    public ObjGastoEntity(String Partida, Integer Gestion, String Descrip) {
        this.Partida = Partida;
        this.Gestion = Gestion;
        this.Descrip = Descrip;
    }

    public String getPartida() {
        return Partida;
    }

    public void setPartida(String Partida) {
        this.Partida = Partida;
    }

    public Integer getGestion() {
        return Gestion;
    }

    public void setGestion(Integer Gestion) {
        this.Gestion = Gestion;
    }

    public String getDescrip() {
        return Descrip;
    }

    public void setDescrip(String Descrip) {
        this.Descrip = Descrip;
    }
}
