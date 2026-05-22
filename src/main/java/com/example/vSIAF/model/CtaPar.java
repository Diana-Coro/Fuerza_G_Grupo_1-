package com.example.vSIAF.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CtaPar {

    private Integer id;

    @JsonProperty("Codcont") 
    private Integer codcont;

    @JsonProperty("Partida") 
    private Integer partida;

    @JsonProperty("Gestion") 
    private Integer gestion;

    
    public CtaPar() {
    }

    
    public CtaPar(Integer id, Integer codcont, Integer partida, Integer gestion) {
        this.id = id;
        this.codcont = codcont;
        this.partida = partida;
        this.gestion = gestion;
    }

    // Getters y Setters
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