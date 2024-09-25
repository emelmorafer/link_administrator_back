package com.enlaces.enlaces.controller;

import com.enlaces.enlaces.dto.EnlaceDto;
import com.enlaces.enlaces.model.Categoria;
import com.enlaces.enlaces.model.Enlace;
import com.enlaces.enlaces.service.CategoriaService;
import com.enlaces.enlaces.service.EnlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins =  { "*"})
@RestController
@RequestMapping("adminEnlaces")
public class EnlaceController {

    @Autowired
    EnlaceService enlaceService;

    @Autowired
    CategoriaService categoriaService;

    @PostMapping(value = "/enlace")
    public EnlaceDto guardarEnlace(
            @RequestParam(value = "nombre") String nombre,
            @RequestParam(value = "descripcion") String descripcion,
            @RequestParam(value = "enlaceDir") String enlaceDir,
            @RequestParam(value = "categoriaId") Long categoriaId,
            @RequestParam(value = "creationdate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime creationdate) {

        Categoria categoria = categoriaService.obtenerCategoriaJpaPorId(categoriaId);
        Enlace enlace = new Enlace(nombre,enlaceDir,descripcion,creationdate,categoria);
        return enlaceService.guardarEnlace(enlace);
    }

    @PutMapping(value = "/enlace")
    public EnlaceDto updateEnlace(
            @RequestParam(value = "id") long id,
            @RequestParam(value = "nombre") String nombre,
            @RequestParam(value = "descripcion") String descripcion,
            @RequestParam(value = "enlaceDir") String enlaceDir,
            @RequestParam(value = "creationdate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime creationdate) {

        Enlace enlace = enlaceService.obtenerEnlaceJpaPorId(id);
        enlace.setNombre(nombre);
        enlace.setDescripcion(descripcion);
        enlace.setEnlace(enlaceDir);
        enlace.setCreationdate(creationdate);
        return enlaceService.guardarEnlace(enlace);
    }

    @GetMapping(value = "/enlace/{id}")
    public EnlaceDto getEnlaceByID(@PathVariable(value="id") long id) {
        return enlaceService.obtenerEnlacePorId(id);
    }

    @GetMapping(value = "/enlace/list/categoria/{idCategoria}")
    public List<EnlaceDto> obtenerEnlacesPorIdCategoria(@PathVariable(value="idCategoria") long idCategoria) {
        return enlaceService.obtenerEnlacesPorIdCategoria(idCategoria);
    }

    @GetMapping(value = "/enlace/searchlist/{idCategoria}/{search}")
    public List<EnlaceDto> obtenerEnlacesPorIdCategoria(
            @PathVariable(value="idCategoria") long idCategoria,
            @PathVariable(value="search") String search) {
        return enlaceService.obtenerEnlacesPorBusqueda(idCategoria,search);
    }

    @DeleteMapping(value = "/enlace/{id}")
    public boolean deleteEnlaceById(@PathVariable(value="id") long id) {
        return enlaceService.deleteEnlaceById(id);
    }
}
