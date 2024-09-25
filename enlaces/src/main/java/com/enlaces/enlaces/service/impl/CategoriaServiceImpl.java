package com.enlaces.enlaces.service.impl;

import com.enlaces.enlaces.dto.CategoriaDto;
import com.enlaces.enlaces.model.Categoria;
import com.enlaces.enlaces.repository.CategoriaRepository;
import com.enlaces.enlaces.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public CategoriaDto guardarCategoria(Categoria categoria) {
        if (!categoria.getNombre().equals("")) {

            return domainToDto(categoriaRepository.save(categoria));

        } else {
            return new CategoriaDto();
        }
    }

    public CategoriaDto obtenerCategoriaPorId(long id) {
        Optional<Categoria> categoriaOpt = categoriaRepository.findById(id);
        if (categoriaOpt.isPresent()) {
            return domainToDto(categoriaOpt.get());
        }else{
            return new CategoriaDto();
        }
    }

    public Categoria obtenerCategoriaJpaPorId(long id) {
        Optional<Categoria> categoriaOpt = categoriaRepository.findById(id);
        return categoriaOpt.orElse(new Categoria());
    }

    public List<CategoriaDto> obtenerListadoCategorias(){
        List<Categoria> listCategoria = (List<Categoria>)categoriaRepository.findAll();
        return listCategoria.stream().map(categoria -> domainToDto(categoria)).collect(Collectors.toList());
    }

    public List<CategoriaDto> obtenerCategoriasPorBusqueda(String busqueda){
        List<Categoria> listCategoria = (List<Categoria>)categoriaRepository.obtenerCategoriasPorBusqueda(busqueda);
        return listCategoria.stream().map(categoria -> domainToDto(categoria)).collect(Collectors.toList());
    }

    public boolean deleteCategoriaById(long id) {
        try {
            categoriaRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public CategoriaDto domainToDto(Categoria categoria) {
        return new CategoriaDto(
                categoria.id,
                categoria.nombre,
                categoria.descripcion,
                categoria.creationdate);
    }


}
