package com.Biblioteca.demo.service;

/**
 *
 * @author darry
 */

import com.Biblioteca.demo.domain.Queja;
import com.Biblioteca.demo.domain.TipoQueja;
import java.util.List;
import java.util.Optional;

public interface QuejaService {
    
    // Obtener todas las quejas
    List<Queja> findAll();
    
    // Obtener queja por ID
    Optional<Queja> findById(Long id);
    
    // Obtener quejas por tipo
    List<Queja> findByTipo(TipoQueja tipo);
    
    // Obtener quejas no tratadas
    List<Queja> findNoTratadas();
    
    // Obtener quejas tratadas
    List<Queja> findTratadas();
    
    // Guardar queja (crear)
    Queja save(Queja queja);
    
    // Marcar queja como tratada
    Queja marcarComoTratada(Long id);
    
    // Contar quejas no tratadas
    long countNoTratadas();
}