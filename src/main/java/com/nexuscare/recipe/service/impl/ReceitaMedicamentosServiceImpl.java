package com.nexuscare.recipe.service.impl;

import com.nexuscare.recipe.model.ReceitaMedicamentos;
import com.nexuscare.recipe.repository.ReceitaMedicamentosRepository;
import com.nexuscare.recipe.service.ReceitaMedicamentosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceitaMedicamentosServiceImpl implements ReceitaMedicamentosService {

    private final ReceitaMedicamentosRepository ReceitaMedicamentoRepository;

    @Autowired
    public ReceitaMedicamentosServiceImpl(ReceitaMedicamentosRepository ReceitaMedicamentoRepository) {
        this.ReceitaMedicamentoRepository = ReceitaMedicamentoRepository;
    }

    @Override
    public ReceitaMedicamentos save(ReceitaMedicamentos receitaMedicamentos) {
        return ReceitaMedicamentoRepository.save(receitaMedicamentos);
    }

    @Override
    public Optional<ReceitaMedicamentos> findById(Long id) {
        return ReceitaMedicamentoRepository.findById(id);
    }

    @Override
    public List<ReceitaMedicamentos> findAll() {
        return ReceitaMedicamentoRepository.findAll();
    }

    @Override
    public ReceitaMedicamentos update(Long id, ReceitaMedicamentos receitaMedicamentos) {
        if (ReceitaMedicamentoRepository.existsById(id)) {
            receitaMedicamentos.setId(id);
            return ReceitaMedicamentoRepository.save(receitaMedicamentos);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        ReceitaMedicamentoRepository.deleteById(id);
    }
}
