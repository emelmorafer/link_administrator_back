package com.enlaces.enlaces.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "Categoria")
public class Categoria {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "nombre", nullable = true)
    public String nombre;

    @Column(name = "descripcion", nullable = true)
    public String descripcion;

    @Column(name = "creationdate", nullable = false)
    public LocalDateTime creationdate;


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

    public Categoria() {
    }

    public Categoria(String nombre, String descripcion, LocalDateTime creationdate) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.creationdate = creationdate;
    }
}
