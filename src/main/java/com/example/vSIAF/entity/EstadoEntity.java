package com.example.vSIAF.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "estado")
public class EstadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true)
    private Integer codestado;

    private String nombrestado;

    public EstadoEntity() {
    }

    public EstadoEntity(Integer codestado, String nombrestado) {
        this.codestado = codestado;
        this.nombrestado = nombrestado;
    }

    public Integer getCodestado() {
        return codestado;
    }

    public void setCodestado(Integer codestado) {
        this.codestado = codestado;
    }

    public String getNombrestado() {
        return nombrestado;
    }

    public void setNombrestado(String nombrestado) {
        this.nombrestado = nombrestado;
    }
}