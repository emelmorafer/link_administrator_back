package com.enlaces.enlaces.service;

import com.enlaces.enlaces.dto.CategoriaDto;
import com.enlaces.enlaces.model.Categoria;

import java.util.List;

public interface CategoriaService {

    public CategoriaDto guardarCategoria(Categoria categoria);

    public CategoriaDto obtenerCategoriaPorId(long id);

    public Categoria obtenerCategoriaJpaPorId(long id);

    public List<CategoriaDto> obtenerListadoCategorias();

    public List<CategoriaDto> obtenerCategoriasPorBusqueda(String busqueda);

    public boolean deleteCategoriaById(long id);


}
