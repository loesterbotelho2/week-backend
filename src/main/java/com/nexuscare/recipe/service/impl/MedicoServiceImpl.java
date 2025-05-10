package com.nexuscare.recipe.service.impl;

import com.nexuscare.recipe.model.Medico;
import com.nexuscare.recipe.repository.MedicoRepository;
import com.nexuscare.recipe.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoServiceImpl implements MedicoService {

    private final MedicoRepository medicoRepository;

    @Autowired
    public MedicoServiceImpl(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    @Override
    public Medico save(Medico medico) {
        return medicoRepository.save(medico);
    }

    @Override
    public Optional<Medico> findById(Long id) {
        return medicoRepository.findById(id);
    }

    @Override
    public List<Medico> findAll() {
        return medicoRepository.findAll();
    }

    @Override
    public Medico update(Long id, Medico medico) {
        if (medicoRepository.existsById(id)) {
            medico.setId(id);
            return medicoRepository.save(medico);
        }
        return null;  // Ou lançar exceção
    }

    @Override
    public void delete(Long id) {
        medicoRepository.deleteById(id);
    }
}
