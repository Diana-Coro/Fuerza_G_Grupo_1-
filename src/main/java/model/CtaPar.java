package com.example.Cta_par.model;

public class CtaPar {

    private Integer id;
    private Integer codcont;
    private Integer gestion;

    public CtaPar() {
    }

    public CtaPar(Integer id, Integer codcont, Integer gestion) {
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