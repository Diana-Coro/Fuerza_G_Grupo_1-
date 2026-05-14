package com.example.vSIAF.model;

public class Baja {

    private Integer id;
    private String motivo;
    private String fecha;

    public Baja() {
    }

    public Baja(Integer id, String motivo, String fecha) {
        this.id = id;
        this.motivo = motivo;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}