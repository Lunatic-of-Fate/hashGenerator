package org.lunatic.services;

import org.springframework.stereotype.Service;

public interface HashGeneratorService {
    String generateHash(long number);
}
