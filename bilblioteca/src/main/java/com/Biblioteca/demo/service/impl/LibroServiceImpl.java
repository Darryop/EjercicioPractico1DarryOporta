package com.Biblioteca.demo.service.impl;

/**
 *
 * @author darry
 */


import com.Biblioteca.demo.domain.Libro;
import com.Biblioteca.demo.domain.Categoria;
import com.Biblioteca.demo.repository.LibroRepository;
import com.Biblioteca.demo.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LibroServiceImpl implements LibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Libro> findAll() {
        return libroRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Libro> findById(Long id) {
        return libroRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Libro> findByTituloContaining(String titulo) {
        return libroRepository.findByTituloContainingIgnoreCase(titulo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Libro> findByAutorContaining(String autor) {
        return libroRepository.findByAutorContainingIgnoreCase(autor);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Libro> findByCategoria(Categoria categoria) {
        return libroRepository.findByCategoria(categoria);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Libro> findDisponibles() {
        return libroRepository.findByDisponibleTrue();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Libro> findNoDisponibles() {
        return libroRepository.findByDisponibleFalse();
    }

    @Override
    public Libro save(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public void deleteById(Long id) {
        libroRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Libro> findByIdWithCategoria(Long id) {
        return libroRepository.findByIdWithCategoria(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Libro> findAllWithCategoria() {
        return libroRepository.findAllWithCategoria();
    }
}