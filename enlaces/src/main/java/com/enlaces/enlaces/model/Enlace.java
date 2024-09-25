package com.enlaces.enlaces.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "Enlace")
public class Enlace {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "nombre", nullable = true)
    public String nombre;

    @Column(name = "enlace", nullable = true)
    public String enlace;

    @Column(name = "descripcion", nullable = true)
    public String descripcion;

    @Column(name = "creationdate", nullable = false)
    public LocalDateTime creationdate;

    @ManyToOne
    @JoinColumn(name = "id_categoria", referencedColumnName = "id")
    public Categoria categoria;


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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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

    public Enlace() {
    }

    public Enlace(String nombre, String enlace, String descripcion, LocalDateTime creationdate, Categoria categoria) {
        this.nombre = nombre;
        this.enlace = enlace;
        this.descripcion = descripcion;
        this.creationdate = creationdate;
        this.categoria = categoria;
    }
}
