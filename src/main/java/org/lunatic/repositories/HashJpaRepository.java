package org.lunatic.repositories;

import org.lunatic.DTO.HashSearchDTO;
import org.lunatic.models.Hash;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HashJpaRepository extends JpaRepository<Hash, Long> {

    Hash findFirstByUsedIsFalse();
    Hash findAllByHash(String hash);
}