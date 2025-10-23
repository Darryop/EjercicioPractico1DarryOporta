/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Biblioteca.demo.repository;

/**
 *
 * @author darry
 */

import com.Biblioteca.demo.domain.Queja;
import com.Biblioteca.demo.domain.TipoQueja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface QuejaRepository extends JpaRepository<Queja, Long> {
    
    // Buscar quejas por tipo
    List<Queja> findByTipo(TipoQueja tipo);
    
    // Buscar quejas no tratadas
    List<Queja> findByTratadoFalse();
    
    // Buscar quejas tratadas
    List<Queja> findByTratadoTrue();
    
    // Buscar quejas por email del cliente
    List<Queja> findByEmail(String email);
    
    // Contar quejas no tratadas
    long countByTratadoFalse();
}