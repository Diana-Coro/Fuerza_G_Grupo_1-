package com.example.vSIAF.services;

import com.example.vSIAF.dtos.EntidadesDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class EntidadesService {
    List<EntidadesDTO> entidades = new ArrayList<>();

    public EntidadesService() {
    }



    public List<EntidadesDTO> obtenerEntidades() {
        return entidades;
    }

    public EntidadesDTO obtenerEntidad(Long entidad) {
        return entidades.stream()
                .filter(e -> e.getEntidad() == entidad)

                .findFirst()
                .orElse(null);
    }




    public EntidadesDTO crearEntidades(EntidadesDTO entidadesNuevo) {
        entidades.add(entidadesNuevo);

        return entidadesNuevo;
    }




    public EntidadesDTO editarEntidades(long entidad, EntidadesDTO entidadEditada) {
        EntidadesDTO temporal = obtenerEntidad(entidad);
        if (temporal == null) {
            throw new RuntimeException("ENTIDAD NO ENCONTRADA");
        }
        if (entidadEditada.getGestion() != 0) {
            temporal.setGestion(entidadEditada.getGestion());
        }
        if (entidadEditada.getEntidad() != 0) {
            temporal.setEntidad(entidadEditada.getEntidad());
        }
        if (entidadEditada.getDescripcion() != null) {
            temporal.setDescripcion(entidadEditada.getDescripcion());
        }
        if (entidadEditada.getSigla() != null) {
            temporal.setSigla(entidadEditada.getSigla());

        }
        return temporal;

    }




    public EntidadesDTO eliminarEntidad(long entidad)
    {
        EntidadesDTO  temporal = obtenerEntidad(entidad);
        if(temporal ==null)
        {
            throw new RuntimeException("ENTIDAD NO ENCOTRADA");
        }
        entidades.remove(temporal);
        return temporal;
    }
}