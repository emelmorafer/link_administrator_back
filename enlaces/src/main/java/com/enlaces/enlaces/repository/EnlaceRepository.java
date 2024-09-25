package com.enlaces.enlaces.repository;

import com.enlaces.enlaces.model.Enlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnlaceRepository extends JpaRepository<Enlace, Long> {

    static final String SELECT_SQL = "SELECT * FROM enlace ";

    @Query(value = SELECT_SQL + " WHERE id_categoria = :idCategoria ", nativeQuery = true)
    public List<Enlace> obtenerEnlacesPorIdCategoria(Long idCategoria);

    @Query(value = SELECT_SQL + " WHERE id_categoria = :idCategoria AND " +
            "(nombre LIKE CONCAT('%', :busqueda, '%') OR descripcion LIKE CONCAT('%', :busqueda, '%')) ", nativeQuery = true)
    public List<Enlace> obtenerEnlacesPorBusqueda(Long idCategoria, String busqueda);

}
