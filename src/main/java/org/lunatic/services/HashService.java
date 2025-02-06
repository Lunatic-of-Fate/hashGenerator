package org.lunatic.services;

import org.lunatic.dto.HashDTO;
import org.lunatic.dto.HashSearchDTO;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface HashService {
    HashDTO search(@NotNull HashSearchDTO dto);

    HashDTO create();
}
