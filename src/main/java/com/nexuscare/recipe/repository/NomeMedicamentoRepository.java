package com.nexuscare.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nexuscare.recipe.model.NomeMedicamento;

public interface NomeMedicamentoRepository extends JpaRepository<NomeMedicamento, Long> {
}
