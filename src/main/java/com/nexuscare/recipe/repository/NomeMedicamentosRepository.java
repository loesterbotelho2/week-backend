package com.nexuscare.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nexuscare.recipe.model.NomeMedicamentos;

public interface NomeMedicamentosRepository extends JpaRepository<NomeMedicamentos, Long> {
}
