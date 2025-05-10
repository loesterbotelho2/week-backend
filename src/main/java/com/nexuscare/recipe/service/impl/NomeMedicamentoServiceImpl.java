package com.nexuscare.recipe.service.impl;

import com.nexuscare.recipe.model.NomeMedicamento;
import com.nexuscare.recipe.repository.NomeMedicamentoRepository;
import com.nexuscare.recipe.service.NomeMedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NomeMedicamentoServiceImpl implements NomeMedicamentoService {

    private final NomeMedicamentoRepository NomeMedicamentoRepository;

    @Autowired
    public NomeMedicamentoServiceImpl(NomeMedicamentoRepository NomeMedicamentoRepository) {
        this.NomeMedicamentoRepository = NomeMedicamentoRepository;
    }

    @Override
    public NomeMedicamento save(NomeMedicamento NomeMedicamento) {
        return NomeMedicamentoRepository.save(NomeMedicamento);
    }

    @Override
    public Optional<NomeMedicamento> findById(Long id) {
        return NomeMedicamentoRepository.findById(id);
    }

    @Override
    public List<NomeMedicamento> findAll() {
        return NomeMedicamentoRepository.findAll();
    }

    @Override
    public NomeMedicamento update(Long id, NomeMedicamento NomeMedicamento) {
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
