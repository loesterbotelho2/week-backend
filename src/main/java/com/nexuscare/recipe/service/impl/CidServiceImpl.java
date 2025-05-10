package com.nexuscare.recipe.service.impl;

import com.nexuscare.recipe.model.Cid;
import com.nexuscare.recipe.repository.CidRepository;
import com.nexuscare.recipe.service.CidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidServiceImpl implements CidService {

    private final CidRepository cidRepository;

    @Autowired
    public CidServiceImpl(CidRepository cidRepository) {
        this.cidRepository = cidRepository;
    }

    @Override
    public Cid save(Cid cid) {
        return cidRepository.save(cid);
    }

    @Override
    public Optional<Cid> findById(Long id) {
        return cidRepository.findById(id);
    }

    @Override
    public List<Cid> findAll() {
        return cidRepository.findAll();
    }

    @Override
    public Cid update(Long id, Cid cid) {
        if (cidRepository.existsById(id)) {
            cid.setId(id);
            return cidRepository.save(cid);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        cidRepository.deleteById(id);
    }
}
