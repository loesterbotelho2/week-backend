package com.nexuscare.recipe.service;

import com.nexuscare.recipe.model.Receita;
import java.util.List;
import java.util.Optional;

public interface ReceitaService {
    Receita save(Receita receita);
    Optional<Receita> findById(Long id);
    List<Receita> findAll();
    Receita update(Long id, Receita receita);
    void delete(Long id);
}
