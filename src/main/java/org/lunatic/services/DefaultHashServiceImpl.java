package org.lunatic.services;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.lunatic.DTO.HashResponseDTO;
import org.lunatic.models.Hash;
import org.lunatic.repositories.HashJpaRepository;
import org.springframework.stereotype.Service;

import java.nio.ByteBuffer;
import java.util.Base64;

@AllArgsConstructor
@Service
public class DefaultHashServiceImpl implements HashService {
    private final HashJpaRepository hashJpaRepository;

    public HashResponseDTO get() {
        Hash hash = hashJpaRepository.findFirstByReservedFalse();
        if (hash == null) {
            generateHash();
            hash = hashJpaRepository.findFirstByReservedFalse();
        }
        hash.setReserved(true);
        hashJpaRepository.save(hash);
        return new HashResponseDTO(hash.getHash());
    }

    @PostConstruct
    private void generateHash() {
        double scalingFactor = 1.5;
        long startGenerateId = hashJpaRepository.count() + 1;
        for (long newId = startGenerateId; newId < startGenerateId * scalingFactor; newId++) {
            Hash hash = new Hash(
                    newId,
                    encodeNumberToBase64(newId),
                    false
            );
            hashJpaRepository.save(hash);
        }
    }

    //    Тут можно сделать многопоточную генерацию хэшей для ускорения работы
    private String encodeNumberToBase64(long number) {
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.putLong(number);
        byte[] byteArray = buffer.array();
        return Base64.getUrlEncoder().encodeToString(byteArray);
    }
}