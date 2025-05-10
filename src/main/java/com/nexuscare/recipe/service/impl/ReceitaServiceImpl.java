package com.nexuscare.recipe.service.impl;

import com.nexuscare.recipe.model.Receita;
import com.nexuscare.recipe.repository.ReceitaRepository;
import com.nexuscare.recipe.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceitaServiceImpl implements ReceitaService {

    private final ReceitaRepository receitaRepository;

    @Autowired
    public ReceitaServiceImpl(ReceitaRepository receitaRepository) {
        this.receitaRepository = receitaRepository;
    }

    @Override
    public Receita save(Receita receita) {
        return receitaRepository.save(receita);
    }

    @Override
    public Optional<Receita> findById(Long id) {
        return receitaRepository.findById(id);
    }

    @Override
    public List<Receita> findAll() {
        return receitaRepository.findAll();
    }

    @Override
    public Receita update(Long id, Receita receita) {
        if (receitaRepository.existsById(id)) {
            receita.setId(id);
            return receitaRepository.save(receita);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        receitaRepository.deleteById(id);
    }
}
