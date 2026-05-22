package com.example.vSIAF.model;

public class Mes {

    private Integer mes;
    private String nommes;

    public Mes() {
    }

    public Mes(Integer mes, String nommes) {
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