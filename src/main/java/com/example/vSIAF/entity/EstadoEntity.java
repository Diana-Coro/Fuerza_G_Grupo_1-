package com.example.vSIAF.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "Estado")
public class EstadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true)
    private Integer Codestado;

    private String Nomestado;

    public EstadoEntity() {
    }

    public EstadoEntity(Integer Codestado, String Nomestado) {
        this.Codestado = Codestado;
        this.Nomestado = Nomestado;
    }

    public Integer getCodestado() {
        return Codestado;
    }

    public void setCodestado(Integer Codestado) {
        this.Codestado = Codestado;
    }

    public String getNomestado() {
        return Nomestado;
    }

    public void setNomestado(String Nomestado) {
        this.Nomestado = Nomestado;
    }
}