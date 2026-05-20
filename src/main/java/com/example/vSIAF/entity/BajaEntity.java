package com.example.vSIAF.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "baja")
public class BajaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codbaja;

    private String desbaja;

    public BajaEntity() {
    }

    public BajaEntity(Long codbaja, String desbaja) {
        this.codbaja = codbaja;
        this.desbaja = desbaja;
    }

    public Long getCodbaja() {
        return codbaja;
    }

    public void setCodbaja(Long codbaja) {
        this.codbaja = codbaja;
    }

    public String getDesbaja() {
        return desbaja;
    }

    public void setDesbaja(String desbaja) {
        this.desbaja = desbaja;
    }
}
