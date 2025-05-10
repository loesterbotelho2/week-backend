package com.nexuscare.recipe.service;

import com.nexuscare.recipe.model.NomeMedicamento;
import java.util.List;
import java.util.Optional;

public interface NomeMedicamentoService {
	NomeMedicamento save(NomeMedicamento nomeMedicamentos);
    Optional<NomeMedicamento> findById(Long id);
    List<NomeMedicamento> findAll();
    NomeMedicamento update(Long id, NomeMedicamento nomeMedicamentos);
    void delete(Long id);
}
