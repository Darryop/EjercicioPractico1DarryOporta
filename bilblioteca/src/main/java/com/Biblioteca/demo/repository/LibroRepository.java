/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Biblioteca.demo.repository;

/**
 *
 * @author darry
 */


import com.Biblioteca.demo.domain.Libro;
import com.Biblioteca.demo.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
    
    // Buscar libros por título
    List<Libro> findByTituloContainingIgnoreCase(String titulo);
    
    // Buscar libros por autor
    List<Libro> findByAutorContainingIgnoreCase(String autor);
    
    // Buscar libros por categoría
    List<Libro> findByCategoria(Categoria categoria);
    
    // Buscar libros disponibles
    List<Libro> findByDisponibleTrue();
    
    // Buscar libros no disponibles
    List<Libro> findByDisponibleFalse();
    
    // Buscar libro por ISBN
    Optional<Libro> findByIsbn(String isbn);
    
    // Consulta personalizada para buscar libros con información de categoría
    @Query("SELECT l FROM Libro l JOIN FETCH l.categoria WHERE l.id = ?1")
    Optional<Libro> findByIdWithCategoria(Long id);
    
    // Consulta para obtener todos los libros con sus categorías (evita N+1)
    @Query("SELECT l FROM Libro l JOIN FETCH l.categoria")
    List<Libro> findAllWithCategoria();
}