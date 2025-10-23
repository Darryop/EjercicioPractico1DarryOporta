package com.Biblioteca.demo.service.impl;

/**
 *
 * @author darry
 */
import com.Biblioteca.demo.domain.Categoria;
import com.Biblioteca.demo.repository.CategoriaRepository;
import com.Biblioteca.demo.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Categoria> findById(Long id) {
        return categoriaRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Categoria> findByNombre(String nombre) {
        return categoriaRepository.findByNombre(nombre);
    }

    @Override
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public void deleteById(Long id) {
        categoriaRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByNombre(String nombre) {
        return categoriaRepository.existsByNombre(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> findByNombreContaining(String nombre) {
        return categoriaRepository.findByNombreContainingIgnoreCase(nombre);
    }
}