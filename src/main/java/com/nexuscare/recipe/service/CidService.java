package com.nexuscare.recipe.service;

import com.nexuscare.recipe.model.Cid;
import java.util.List;
import java.util.Optional;

public interface CidService {
    Cid save(Cid cid);
    Optional<Cid> findById(Long id);
    List<Cid> findAll();
    Cid update(Long id, Cid cid);
    void delete(Long id);
}
