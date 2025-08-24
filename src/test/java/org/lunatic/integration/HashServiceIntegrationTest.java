package org.lunatic.integration;

import info.solidsoft.mockito.java8.api.WithBDDMockito;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.lunatic.SpringBootApplicationTest;
import org.lunatic.dto.HashDTO;
import org.lunatic.dto.HashSearchDTO;
import org.lunatic.services.HashGeneratorService;
import org.lunatic.services.HashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import static org.junit.jupiter.api.Assertions.assertAll;

@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class HashServiceIntegrationTest extends SpringBootApplicationTest implements WithAssertions, WithBDDMockito {
    @Autowired
    HashService hashService;
    @MockitoBean
    HashGeneratorService hashGeneratorService;

    @Test
    void create_correctUse() {
        given(hashGeneratorService.generateHash(anyLong())).willReturn("new_hash");

        HashDTO dto = hashService.create();

        assertAll(
                () -> assertThat(dto).isNotNull(),
                () -> assertThat(dto.getHash()).isEqualTo("new_hash"),
                () -> assertThat(dto.isUsed()).isEqualTo(true)
        );
    }

    @Test
    void search_correctUse() {
        given(hashGeneratorService.generateHash(anyLong())).willReturn("new_hash");

        HashDTO dto = hashService.create();
        HashDTO searchDto = hashService.search(new HashSearchDTO("new_hash"));

        assertAll(
                () -> assertThat(searchDto).isNotNull(),
                () -> assertThat(searchDto.getHash()).isEqualTo(dto.getHash()),
                () -> assertThat(searchDto.isUsed()).isEqualTo(dto.isUsed())
        );
    }
}