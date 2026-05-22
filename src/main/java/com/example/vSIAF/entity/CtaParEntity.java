package com.example.vSIAF.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Cta_par")
public class CtaParEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Codcont")
    @JsonProperty(value = "Codcont", access = JsonProperty.Access.READ_ONLY)
    private Integer codcont; 
    
    @Column(name = "Partida")
    @JsonProperty("Partida") 
    private Integer partida; 

    @Column(name = "Gestion")
    @JsonProperty("Gestion") 
    private Integer gestion; 

    public CtaParEntity() {
    }

    public CtaParEntity(Integer codcont, Integer partida, Integer gestion) {
        this.codcont = codcont;
        this.partida = partida;
        this.gestion = gestion;
    }

    public Integer getCodcont() {
        return codcont;
    }

    @JsonIgnore
    public void setCodcont(Integer codcont) {
        this.codcont = codcont;
    }

    public Integer getPartida() {
        return partida;
    }

    public void setPartida(Integer partida) {
        this.partida = partida;
    }

    public Integer getGestion() {
        return gestion;
    }

    public void setGestion(Integer gestion) {
        this.gestion = gestion;
    }
}