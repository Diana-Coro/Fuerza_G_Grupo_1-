package com.example.vSIAF.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Entidades")
public class EntidadesEntity {

        @Id
        private Integer entidad;

        private Integer gestion;
        private String desc_ent;
        private String sigla_ent;
        private Integer sector_ent;
        private Integer subsec_ent;
        private Integer area_ent;
        private Integer subareaent;
        private Integer nivel_inst;


        public EntidadesEntity() {
        }


        public EntidadesEntity(Integer entidad, Integer gestion, String desc_ent, String sigla_ent,
                               Integer sector_ent, Integer subsec_ent, Integer area_ent, Integer subareaent, Integer nivel_inst) {
            this.entidad = entidad;
            this.gestion = gestion;
            this.desc_ent = desc_ent;
            this.sigla_ent = sigla_ent;
            this.sector_ent = sector_ent;
            this.subsec_ent = subsec_ent;
            this.area_ent = area_ent;
            this.subareaent = subareaent;
            this.nivel_inst = nivel_inst;
        }


        public Integer getEntidad() { return entidad; }
        public void setEntidad(Integer entidad) { this.entidad = entidad; }

        public Integer getGestion() { return gestion; }
        public void setGestion(Integer gestion) { this.gestion = gestion; }

        public String getDesc_ent() { return desc_ent; }
        public void setDesc_ent(String desc_ent) { this.desc_ent = desc_ent; }

        public String getSigla_ent() { return sigla_ent; }
        public void setSigla_ent(String sigla_ent) { this.sigla_ent = sigla_ent; }

        public Integer getSector_ent() { return sector_ent; }
        public void setSector_ent(Integer sector_ent) { this.sector_ent = sector_ent; }

        public Integer getSubsec_ent() { return subsec_ent; }
        public void setSubsec_ent(Integer subsec_ent) { this.subsec_ent = subsec_ent; }

        public Integer getArea_ent() { return area_ent; }
        public void setArea_ent(Integer area_ent) { this.area_ent = area_ent; }

        public Integer getSubareaent() { return subareaent; }
        public void setSubareaent(Integer subareaent) { this.subareaent = subareaent; }

        public Integer getNivel_inst() { return nivel_inst; }
        public void setNivel_inst(Integer nivel_inst) { this.nivel_inst = nivel_inst; }
}
