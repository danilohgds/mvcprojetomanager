package com.danilohgds.mvcprojectmanager.service;

import com.danilohgds.mvcprojectmanager.model.PessoaDTO;
import com.danilohgds.mvcprojectmanager.repository.PessoaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PessoaServiceTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @InjectMocks
    private PessoaService pessoaService;

    private PessoaDTO pessoaDTO;

    @BeforeEach
    void setUp() {
        pessoaDTO = PessoaDTO.builder()
                .id(1)
                .nome("Joao Dasilva")
                .datanascimento(LocalDate.of(1990, 5, 15))
                .cpf("12345678900")
                .funcionario(true)
                .gerente(false)
                .build();
    }

    @Test
    void createPessoa_ShouldReturnSavedPessoa() {
        // Given
        when(pessoaRepository.save(pessoaDTO)).thenReturn(pessoaDTO);

        // When
        PessoaDTO savedPessoa = pessoaService.createPessoa(pessoaDTO);

        // Then
        assertThat(savedPessoa).isEqualTo(pessoaDTO);
    }

    @Test
    void getPessoa_ShouldReturnPessoaIfExists() {
        // Given
        int id = 1;
        when(pessoaRepository.getPessoaDTOById(id)).thenReturn(pessoaDTO);

        // When
        PessoaDTO foundPessoa = pessoaService.getPessoaById(id);

        // Then
        assertThat(foundPessoa).isEqualTo(pessoaDTO);
    }

    @Test
    void getPessoa_ShouldReturnNullIfNotExists() {
        // Given
        int id = 1;
        when(pessoaRepository.getPessoaDTOById(id)).thenReturn(null);

        // When
        PessoaDTO foundPessoa = pessoaService.getPessoaById(id);

        // Then
        assertThat(foundPessoa).isNull();
    }

    @Test
    void deletePessoa_ShouldDeletePessoa() {
        // Given
        int id = 1;

        // When
        pessoaService.deletePessoa(id);

        // Then
        verify(pessoaRepository, times(1)).deletePessoaDTOById(id);
    }

    @Test
    void updatePessoa_ShouldReturnUpdatedPessoa() {
        // Given
        when(pessoaRepository.save(pessoaDTO)).thenReturn(pessoaDTO);

        // When
        PessoaDTO updatedPessoa = pessoaService.updatePessoa(pessoaDTO);

        // Then
        assertThat(updatedPessoa).isEqualTo(pessoaDTO);
    }

    @Test
    void getAllPessoas_ShouldReturnListOfPessoas() {
        // Given
        List<PessoaDTO> pessoaList = new ArrayList<>();
        pessoaList.add(pessoaDTO);
        when(pessoaRepository.findAll()).thenReturn(pessoaList);

        // When
        List<PessoaDTO> foundPessoas = pessoaService.getAllPessoas();

        // Then
        assertThat(foundPessoas).containsExactly(pessoaDTO);
    }
}
