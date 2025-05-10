package com.nexuscare.recipe.service;

import com.nexuscare.recipe.model.NomeMedicamentos;
import java.util.List;
import java.util.Optional;

public interface NomeMedicamentosService {
	NomeMedicamentos save(NomeMedicamentos nomeMedicamentos);
    Optional<NomeMedicamentos> findById(Long id);
    List<NomeMedicamentos> findAll();
    NomeMedicamentos update(Long id, NomeMedicamentos nomeMedicamentos);
    void delete(Long id);
}
