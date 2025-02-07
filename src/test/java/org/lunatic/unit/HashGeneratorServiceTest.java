package org.lunatic.unit;


import lombok.RequiredArgsConstructor;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.lunatic.SpringBootApplicationTest;
import org.lunatic.services.HashGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class HashGeneratorServiceTest extends SpringBootApplicationTest implements WithAssertions {

    private final HashGeneratorService generator;

    @Test
    void generateHash_correctNumber() {
        long input = 123L;
        var expected = "AAAAAAAAAHs=";
        var result = generator.generateHash(input);
        assertThat(result).isEqualTo(expected);
    }
}