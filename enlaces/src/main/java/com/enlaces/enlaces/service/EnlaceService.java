package com.enlaces.enlaces.service;

import com.enlaces.enlaces.dto.EnlaceDto;
import com.enlaces.enlaces.model.Enlace;

import java.util.List;

public interface EnlaceService {

    public EnlaceDto guardarEnlace(Enlace enlace);

    public EnlaceDto obtenerEnlacePorId(long id);

    Enlace obtenerEnlaceJpaPorId(long id);

    public List<EnlaceDto> obtenerEnlacesPorIdCategoria(long idCategoria);

    public List<EnlaceDto> obtenerEnlacesPorBusqueda(long idCategoria, String busqueda);

    public boolean deleteEnlaceById(long id);
}
