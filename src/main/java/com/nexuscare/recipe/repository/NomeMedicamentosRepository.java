package com.nexuscare.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nexuscare.recipe.model.NomeMedicamento;

public interface NomeMedicamentosRepository extends JpaRepository<NomeMedicamento, Long> {
}
