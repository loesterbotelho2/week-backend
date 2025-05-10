package com.nexuscare.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nexuscare.recipe.model.Cid;

public interface CidRepository extends JpaRepository<Cid, Long> {
}
