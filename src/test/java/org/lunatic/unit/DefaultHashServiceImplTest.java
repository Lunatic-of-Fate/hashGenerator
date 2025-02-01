package org.lunatic.unit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.lunatic.models.Hash;
import org.lunatic.repositories.HashJpaRepository;
import org.lunatic.services.DefaultHashServiceImpl;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;


public class DefaultHashServiceImplTest {

    @Mock
    private HashJpaRepository hashJpaRepository;
    @InjectMocks
    private DefaultHashServiceImpl defaultHashServiceImpl;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGet() {
        when(hashJpaRepository.findFirstByReservedFalse()).thenReturn(null);
        defaultHashServiceImpl.create();

    }

}
