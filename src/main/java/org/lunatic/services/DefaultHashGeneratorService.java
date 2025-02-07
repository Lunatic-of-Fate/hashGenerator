package org.lunatic.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.ByteBuffer;
import java.util.Base64;


@Service
public class DefaultHashGeneratorService implements HashGeneratorService {
    public String generateHash(long number) {
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.putLong(number);
        byte[] byteArray = buffer.array();
        return Base64.getUrlEncoder().encodeToString(byteArray);
    }
}