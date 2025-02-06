package org.lunatic.unit;


import lombok.RequiredArgsConstructor;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.lunatic.services.HashGeneratorService;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RequiredArgsConstructor
class HashGeneratorServiceIntegrationTest implements WithAssertions {
    private final HashGeneratorService generator;

    @Test
    void generateHash_correctNumber() {
        long input = 123L;
        var expected = "AAAAAAAAAHs=";

        var result = generator.generateHash(input);

        assertThat(result).isEqualTo(expected);
    }
}