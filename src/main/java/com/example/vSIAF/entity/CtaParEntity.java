package com.example.vSIAF.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Cta_par")
public class CtaParEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Codcont")
    @JsonProperty("Codcont")
    @Schema(hidden = true) // Lo oculta del JSON de ejemplo de inserción en Swagger
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