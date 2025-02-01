package org.lunatic.services;

import org.lunatic.DTO.HashDTO;
import org.lunatic.DTO.HashSearchDTO;

public interface HashService {
    HashDTO search(HashSearchDTO dto);
    HashDTO create();
}
