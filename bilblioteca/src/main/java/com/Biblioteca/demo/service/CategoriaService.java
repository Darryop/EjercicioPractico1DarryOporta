package com.Biblioteca.demo.service;

/**
 *
 * @author darry
 */

import com.Biblioteca.demo.domain.Categoria;
import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    
    // Obtener todas las categorías
    List<Categoria> findAll();
    
    // Obtener categoría por ID
    Optional<Categoria> findById(Long id);
    
    // Obtener categoría por nombre
    Optional<Categoria> findByNombre(String nombre);
    
    // Guardar categoría (crear o actualizar)
    Categoria save(Categoria categoria);
    
    // Eliminar categoría por ID
    void deleteById(Long id);
    
    // Verificar si existe categoría por nombre
    boolean existsByNombre(String nombre);
    
    // Buscar categorías por nombre (búsqueda parcial)
    List<Categoria> findByNombreContaining(String nombre);
}