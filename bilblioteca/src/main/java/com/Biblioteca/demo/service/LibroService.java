package com.Biblioteca.demo.service;

/**
 *
 * @author darry
 */
import com.Biblioteca.demo.domain.Libro;
import com.Biblioteca.demo.domain.Categoria;
import java.util.List;
import java.util.Optional;

public interface LibroService {

    // Obtener todos los libros
    List<Libro> findAll();

    // Obtener libro por ID
    Optional<Libro> findById(Long id);

    // Obtener libros por título (búsqueda parcial)
    List<Libro> findByTituloContaining(String titulo);

    // Obtener libros por autor
    List<Libro> findByAutorContaining(String autor);

    // Obtener libros por categoría
    List<Libro> findByCategoria(Categoria categoria);

    // Obtener libros disponibles
    List<Libro> findDisponibles();

    // Obtener libros no disponibles
    List<Libro> findNoDisponibles();

    // Guardar libro (crear o actualizar)
    Libro save(Libro libro);

    // Eliminar libro por ID
    void deleteById(Long id);

    // Obtener libro con información de categoría
    Optional<Libro> findByIdWithCategoria(Long id);

    // Obtener todos los libros con información de categoría
    List<Libro> findAllWithCategoria();

    // NUEVO: Obtener el libro más reciente
    Optional<Libro> findLibroMasReciente();
}
