package com.example.vSIAF.model;
 
public class ObjGasto {
 
    private Integer gestion;
    private String partida;
    private String descrip;
 
    public ObjGasto() {
    }
 
    public ObjGasto(Integer gestion, String partida, String descrip) {
        this.gestion = gestion;
        this.partida = partida;
        this.descrip = descrip;
    }
 
    public Integer getGestion() {
        return gestion;
    }
 
    public void setGestion(Integer gestion) {
        this.gestion = gestion;
    }
 
    public String getPartida() {
        return partida;
    }
 
    public void setPartida(String partida) {
        this.partida = partida;
    }
 
    public String getDescrip() {
        return descrip;
    }
 
    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
}