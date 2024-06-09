package com.danilohgds.mvcprojectmanager.service;

import com.danilohgds.mvcprojectmanager.model.MembroDTO;
import com.danilohgds.mvcprojectmanager.repository.MembroRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MembroServiceTest {

    @Mock
    private MembroRepository membroRepository;

    @InjectMocks
    private MembroService membroService;

    @Test
    void persistirMembro_ShouldReturnSavedMembro() {
        // Given
        MembroDTO membroDTO = new MembroDTO();
        membroDTO.setIdprojeto(BigInteger.valueOf(1));
        membroDTO.setIdpessoa(101);

        when(membroRepository.save(membroDTO)).thenReturn(membroDTO);

        // When
        MembroDTO savedMembro = membroService.saveMembro(membroDTO);

        // Then
        assertThat(savedMembro).isNotNull();
        assertThat(savedMembro.getIdprojeto()).isEqualTo(BigInteger.valueOf(1));
        assertThat(savedMembro.getIdpessoa()).isEqualTo(101);
    }
}
