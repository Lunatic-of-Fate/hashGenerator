package org.lunatic.integration;


import info.solidsoft.mockito.java8.api.WithBDDMockito;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.lunatic.dto.HashDTO;
import org.lunatic.services.HashGeneratorService;
import org.lunatic.services.HashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertAll;

@Testcontainers
@SpringBootTest
@RequiredArgsConstructor
public class HashServiceIntegrationTest implements WithAssertions, WithBDDMockito {
    @Autowired
    HashService hashService;
    @MockitoBean
    HashGeneratorService hashGeneratorService;

    @Test
    void create_correctUse() {
        HashDTO dto = hashService.create();
        given(hashGeneratorService.generateHash(anyLong())).willReturn("new_hash");

        assertAll(
                () -> assertThat(dto).isNotNull(),
                () -> assertThat(dto.hash).isEqualTo("new_hash")
        );
    }
}
