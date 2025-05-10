package com.nexuscare.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nexuscare.recipe.model.ReceitaMedicamentos;

public interface ReceitaMedicamentoRepository extends JpaRepository<ReceitaMedicamentos, Long> {
}
