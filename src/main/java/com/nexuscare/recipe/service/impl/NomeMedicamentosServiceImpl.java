package com.nexuscare.recipe.service.impl;

import com.nexuscare.recipe.model.NomeMedicamentos;
import com.nexuscare.recipe.repository.NomeMedicamentosRepository;
import com.nexuscare.recipe.service.NomeMedicamentosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NomeMedicamentosServiceImpl implements NomeMedicamentosService {

    private final NomeMedicamentosRepository NomeMedicamentoRepository;

    @Autowired
    public NomeMedicamentosServiceImpl(NomeMedicamentosRepository NomeMedicamentoRepository) {
        this.NomeMedicamentoRepository = NomeMedicamentoRepository;
    }

    @Override
    public NomeMedicamentos save(NomeMedicamentos NomeMedicamento) {
        return NomeMedicamentoRepository.save(NomeMedicamento);
    }

    @Override
    public Optional<NomeMedicamentos> findById(Long id) {
        return NomeMedicamentoRepository.findById(id);
    }

    @Override
    public List<NomeMedicamentos> findAll() {
        return NomeMedicamentoRepository.findAll();
    }

    @Override
    public NomeMedicamentos update(Long id, NomeMedicamentos NomeMedicamento) {
        if (NomeMedicamentoRepository.existsById(id)) {
            NomeMedicamento.setId(id);
            return NomeMedicamentoRepository.save(NomeMedicamento);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        NomeMedicamentoRepository.deleteById(id);
    }
}
