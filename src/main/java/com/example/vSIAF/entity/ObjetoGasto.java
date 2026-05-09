package com.example.vSIAF.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "objeto_gasto")
public class ObjetoGasto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer gestion;

    private Integer partida;

    private String descripcion;

    public ObjetoGasto() {
    }

    public ObjetoGasto(Long id, Integer gestion, Integer partida, String descripcion) {
        this.id = id;
        this.gestion = gestion;
        this.partida = partida;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public Integer getGestion() {
        return gestion;
    }

    public void setGestion(Integer gestion) {
        this.gestion = gestion;
    }

    public Integer getPartida() {
        return partida;
    }

    public void setPartida(Integer partida) {
        this.partida = partida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
