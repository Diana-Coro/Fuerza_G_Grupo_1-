package com.example.vSIAF.service;

import com.example.vSIAF.model.UnidadAdmin;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UnidadAdminService {

    private final List<UnidadAdmin> unidades = new ArrayList<>();

    public UnidadAdminService() {
        unidades.add(new UnidadAdmin(1L, 1L, "Unidad administrativa", "Potosi"));
    }

    public List<UnidadAdmin> listar() {
        return unidades;
    }

    public UnidadAdmin buscarPorUnidad(Long unidad) {
        return unidades.stream()
                .filter(item -> item.getUnidad().equals(unidad))
                .findFirst()
                .orElse(null);
    }

    public UnidadAdmin crear(UnidadAdmin unidadAdmin) {
        unidades.add(unidadAdmin);
        return unidadAdmin;
    }

    public UnidadAdmin actualizar(Long unidad, UnidadAdmin datosNuevos) {
        for (UnidadAdmin item : unidades) {
            if (item.getUnidad().equals(unidad)) {
                item.setEntidad(datosNuevos.getEntidad());
                item.setDescrip(datosNuevos.getDescrip());
                item.setCiudad(datosNuevos.getCiudad());
                return item;
            }
        }
        return null;
    }

    public String eliminar(Long unidad) {
        unidades.removeIf(item -> item.getUnidad().equals(unidad));
        return "UnidadAdmin eliminada correctamente";
    }
}