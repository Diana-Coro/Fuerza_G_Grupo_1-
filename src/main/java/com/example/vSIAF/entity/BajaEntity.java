package com.example.vSIAF.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Baja")
public class BajaEntity {

    @Id
    private Integer codbaja;

    private String desbaja;


    public BajaEntity() {
    }


    public BajaEntity(Integer codbaja, String desbaja) {
        this.codbaja = codbaja;
        this.desbaja = desbaja;
    }

    public Integer getCodbaja() {
        return codbaja;
    }

    public void setCodbaja(Integer codbaja) {
        this.codbaja = codbaja;
    }

    public String getDesbaja() {
        return desbaja;
    }

    public void setDesbaja(String desbaja) {
        this.desbaja = desbaja;
    }
}
