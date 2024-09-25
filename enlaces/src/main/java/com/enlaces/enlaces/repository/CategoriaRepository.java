package com.enlaces.enlaces.repository;

import com.enlaces.enlaces.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    static final String SELECT_SQL = "SELECT * FROM categoria ";

    @Query(value = SELECT_SQL + " WHERE (nombre LIKE CONCAT('%', :busqueda, '%') OR descripcion LIKE CONCAT('%', :busqueda, '%')) ", nativeQuery = true)
    public List<Categoria> obtenerCategoriasPorBusqueda(String busqueda);

}
