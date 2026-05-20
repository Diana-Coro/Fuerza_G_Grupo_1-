 package com.example.vSIAF.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "ctapar")
public class CtaParEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private Integer codcont;
    private Integer gestion;

    public CtaParEntity() {
    }

    public CtaParEntity(Integer id, Integer codcont, Integer gestion) {
        this.id = id;
        this.codcont = codcont;
        this.gestion = gestion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodcont() {
        return codcont;
    }

    public void setCodcont(Integer codcont) {
        this.codcont = codcont;
    }

    public Integer getGestion() {
        return gestion;
    }

    public void setGestion(Integer gestion) {
        this.gestion = gestion;
    }
}