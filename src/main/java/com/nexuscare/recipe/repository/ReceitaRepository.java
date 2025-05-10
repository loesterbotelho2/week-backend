package com.nexuscare.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nexuscare.recipe.model.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {
}
