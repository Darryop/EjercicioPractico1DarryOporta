/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Biblioteca.demo.service.impl;

/**
 *
 * @author darry
 */

import com.Biblioteca.demo.domain.Queja;
import com.Biblioteca.demo.domain.TipoQueja;
import com.Biblioteca.demo.repository.QuejaRepository;
import com.Biblioteca.demo.service.QuejaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class QuejaServiceImpl implements QuejaService {

    @Autowired
    private QuejaRepository quejaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Queja> findAll() {
        return quejaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Queja> findById(Long id) {
        return quejaRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Queja> findByTipo(TipoQueja tipo) {
        return quejaRepository.findByTipo(tipo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Queja> findNoTratadas() {
        return quejaRepository.findByTratadoFalse();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Queja> findTratadas() {
        return quejaRepository.findByTratadoTrue();
    }

    @Override
    public Queja save(Queja queja) {
        return quejaRepository.save(queja);
    }

    @Override
    public Queja marcarComoTratada(Long id) {
        Optional<Queja> quejaOpt = quejaRepository.findById(id);
        if (quejaOpt.isPresent()) {
            Queja queja = quejaOpt.get();
            queja.setTratado(true);
            return quejaRepository.save(queja);
        }
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public long countNoTratadas() {
        return quejaRepository.countByTratadoFalse();
    }
}