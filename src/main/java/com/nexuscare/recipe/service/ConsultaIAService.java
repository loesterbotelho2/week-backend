package com.nexuscare.recipe.service;

import java.util.List;

import com.nexuscare.recipe.model.ReceitaMedicamentos;

public interface ConsultaIAService {
	List<ReceitaMedicamentos> consultarIA(String observacoes);
}
