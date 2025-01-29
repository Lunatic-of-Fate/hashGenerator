package org.lunatic.repositories;

import org.lunatic.models.Hash;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HashJpaRepository extends JpaRepository<Hash, Long> {
    long countAllByReservedFalse();

    Hash findFirstByReservedFalse();

}