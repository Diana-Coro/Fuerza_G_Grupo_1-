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
    @JsonProperty(value = "Codcont", access = JsonProperty.Access.READ_ONLY)
    @Schema(description = "Identificador único autoincrementable", accessMode = Schema.AccessMode.READ_ONLY)
    private Integer codcont; 
    
    @Column(name = "Partida")
    @JsonProperty("Partida") 
    @Schema(description = "Número de partida presupuestaria", example = "11700")
    private Integer partida; 

    @Column(name = "Gestion")
    @JsonProperty("Gestion") 
    @Schema(description = "Año de la gestión", example = "2026")
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