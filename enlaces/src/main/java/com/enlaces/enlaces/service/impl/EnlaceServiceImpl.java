package com.enlaces.enlaces.service.impl;

import com.enlaces.enlaces.dto.EnlaceDto;
import com.enlaces.enlaces.model.Enlace;
import com.enlaces.enlaces.repository.EnlaceRepository;
import com.enlaces.enlaces.service.EnlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnlaceServiceImpl implements EnlaceService {


    @Autowired
    EnlaceRepository enlaceRepository;

    public EnlaceDto guardarEnlace(Enlace enlace) {
        if (!enlace.getNombre().equals("")) {

            return domainToDto(enlaceRepository.save(enlace));

        } else {
            return new EnlaceDto();
        }
    }

    public EnlaceDto obtenerEnlacePorId(long id) {
        Optional<Enlace> enlaceOpt = enlaceRepository.findById(id);
        if (enlaceOpt.isPresent()) {
            return domainToDto(enlaceOpt.get());
        }else{
            return new EnlaceDto();
        }
    }

    public Enlace obtenerEnlaceJpaPorId(long id) {
        Optional<Enlace> enlaceOpt = enlaceRepository.findById(id);
        return enlaceOpt.orElse(new Enlace());
    }

    public List<EnlaceDto> obtenerEnlacesPorIdCategoria(long idCategoria){
        List<Enlace> listEnlace = (List<Enlace>)enlaceRepository.obtenerEnlacesPorIdCategoria(idCategoria);
        return listEnlace.stream().map(enlace -> domainToDto(enlace)).collect(Collectors.toList());
    }

    public List<EnlaceDto> obtenerEnlacesPorBusqueda(long idCategoria, String busqueda){
        List<Enlace> listEnlace = (List<Enlace>)enlaceRepository.obtenerEnlacesPorBusqueda(idCategoria,busqueda);
        return listEnlace.stream().map(enlace -> domainToDto(enlace)).collect(Collectors.toList());
    }

    public boolean deleteEnlaceById(long id) {
        try {
            enlaceRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public EnlaceDto domainToDto(Enlace enlace) {
        return new EnlaceDto(
                enlace.id,
                enlace.nombre,
                enlace.descripcion,
                enlace.enlace,
                enlace.creationdate,
                enlace.getCategoria().id);
    }

}
