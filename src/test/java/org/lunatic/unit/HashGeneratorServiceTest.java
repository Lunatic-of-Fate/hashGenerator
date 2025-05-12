package org.lunatic.unit;


import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.lunatic.services.DefaultHashGeneratorService;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class HashGeneratorServiceTest implements WithAssertions {
    @InjectMocks
    private DefaultHashGeneratorService generator;

    @Test
    void generateHash_correctNumber() {
        long input = 123L;
        var expected = "AAAAAAAAAHs=";
        var result = generator.generateHash(input);
        assertThat(result).isEqualTo(expected);
    }
}