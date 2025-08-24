package org.lunatic.services;

import jakarta.validation.constraints.NotNull;
import org.lunatic.dto.HashDTO;
import org.lunatic.dto.HashSearchDTO;

public interface HashService {
    HashDTO search(@NotNull HashSearchDTO dto);
    HashDTO create();
}
