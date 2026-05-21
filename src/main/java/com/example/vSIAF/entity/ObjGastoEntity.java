package com.example.vSIAF.entity;
 
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
 
@Entity
@Table(name = "objgasto")
public class ObjGastoEntity {
 
    @Id
    private String partida;
    private Integer gestion;
    private String descrip;
 
    public ObjGastoEntity() {
    }
 
    public ObjGastoEntity(String partida, Integer gestion, String descrip) {
        this.partida = partida;
        this.gestion = gestion;
        this.descrip = descrip;
    }
 
    public String getPartida() {
        return partida;
    }
 
    public void setPartida(String partida) {
        this.partida = partida;
    }
 
    public Integer getGestion() {
        return gestion;
    }
 
    public void setGestion(Integer gestion) {
        this.gestion = gestion;
    }
 
    public String getDescrip() {
        return descrip;
    }
 
    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
}
