package com.enlaces.enlaces.dto;

import java.time.LocalDateTime;

public class EnlaceDto {

    public Long id;

    public String nombre;

    public String descripcion;

    public String enlace;

    public LocalDateTime creationdate;

    public Long categoriaId;

    public EnlaceDto() {
    }

    public EnlaceDto(Long id, String nombre, String descripcion, String enlace, LocalDateTime creationdate, Long categoriaId) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.enlace = enlace;
        this.categoriaId = categoriaId;
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

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
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

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }
}
