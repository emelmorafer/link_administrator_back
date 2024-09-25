package com.enlaces.enlaces.dto;

import java.time.LocalDateTime;

public class CategoriaDto {

    public Long id;

    public String nombre;

    public String descripcion;

    public LocalDateTime creationdate;

    public CategoriaDto() {
    }

    public CategoriaDto(Long id, String nombre, String descripcion, LocalDateTime creationdate) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.creationdate = creationdate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(LocalDateTime creationdate) {
        this.creationdate = creationdate;
    }
}
