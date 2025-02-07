package org.lunatic.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.lunatic.dto.HashDTO;
import org.lunatic.dto.HashSearchDTO;
import org.lunatic.models.Hash;
import org.lunatic.repositories.HashJpaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class DefaultHashServiceImpl implements HashService {
    private final HashJpaRepository repository;
    private final ModelMapper mapper;
    private final HashGeneratorService hashGeneratorService;

    @Override
    public HashDTO search(HashSearchDTO dto) {
        return mapper.map(repository.findFirstByHash(dto.getHash()), HashDTO.class);
    }

    @Override
    public HashDTO create() {
        Hash entity = repository.findFirstByUsedIsFalse();
        if (entity == null) {
            double scalingFactor = 1.5;
            long startGenerateId = repository.count() + 1;
            for (long newId = startGenerateId; newId < startGenerateId * scalingFactor; newId++) {
                repository.save(new Hash(hashGeneratorService.generateHash(newId), false));
            }
            entity = repository.findFirstByUsedIsFalse();
        }
        return mapper.map(entity, HashDTO.class);
    }
}