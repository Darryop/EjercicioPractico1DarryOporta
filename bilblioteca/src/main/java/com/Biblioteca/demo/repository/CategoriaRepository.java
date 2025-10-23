/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Biblioteca.demo.repository;

/**
 *
 * @author darry
 */


import com.Biblioteca.demo.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
    // Buscar categoría por nombre
    Optional<Categoria> findByNombre(String nombre);
    
    // Verificar si existe una categoría con ese nombre
    boolean existsByNombre(String nombre);
    
    // Buscar categorías que contengan en el nombre
    List<Categoria> findByNombreContainingIgnoreCase(String nombre);
}
