package com.enlaces.enlaces.controller;

import com.enlaces.enlaces.dto.CategoriaDto;
import com.enlaces.enlaces.model.Categoria;
import com.enlaces.enlaces.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins =  { "*"})
@RestController
@RequestMapping("adminEnlaces")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @PostMapping(value = "/categoria")
    public CategoriaDto guardarCategoria(
            @RequestParam(value = "nombre") String nombre,
            @RequestParam(value = "descripcion") String descripcion,
            @RequestParam(value = "creationdate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime creationdate) {

            Categoria categoria = new Categoria(nombre,descripcion,creationdate);
            return categoriaService.guardarCategoria(categoria);

    }

    @PutMapping(value = "/categoria")
    public CategoriaDto updateCategoria(
            @RequestParam(value = "id") long id,
            @RequestParam(value = "nombre") String nombre,
            @RequestParam(value = "descripcion") String descripcion,
            @RequestParam(value = "creationdate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime creationdate) {

            Categoria categoria = categoriaService.obtenerCategoriaJpaPorId(id);
            categoria.setNombre(nombre);
            categoria.setDescripcion(descripcion);
            categoria.setCreationdate(creationdate);
            return categoriaService.guardarCategoria(categoria);
    }

    @GetMapping(value = "/categoria/{id}")
    public CategoriaDto getCategoriaByID(@PathVariable(value="id") long id) {
        return categoriaService.obtenerCategoriaPorId(id);
    }

    @GetMapping(value = "/categoria/list")
    public List<CategoriaDto> getListCategoria() {
        return categoriaService.obtenerListadoCategorias();
    }

    @GetMapping(value = "/categoria/searchlist/{search}")
    public List<CategoriaDto> getListCategoria(@PathVariable(value="search") String search) {
        return categoriaService.obtenerCategoriasPorBusqueda(search);
    }

    @DeleteMapping(value = "/categoria/{id}")
    public boolean deleteCategoriaById(@PathVariable(value="id") long id) {
        return categoriaService.deleteCategoriaById(id);
    }

}
