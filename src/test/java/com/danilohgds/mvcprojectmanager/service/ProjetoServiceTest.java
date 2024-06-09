package com.danilohgds.mvcprojectmanager.service;

import com.danilohgds.mvcprojectmanager.enums.StatusProjeto;
import com.danilohgds.mvcprojectmanager.exceptionhandling.BadRequestException;
import com.danilohgds.mvcprojectmanager.exceptionhandling.ResourceNotFoundException;
import com.danilohgds.mvcprojectmanager.model.ProjetoDTO;
import com.danilohgds.mvcprojectmanager.repository.ProjetoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProjetoServiceTest {

    @Mock
    private ProjetoRepository projetoRepository;

    @InjectMocks
    private ProjetoService projetoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveProjeto_ShouldSaveProjeto_WhenValidStatus() {
        ProjetoDTO projeto = new ProjetoDTO();
        projeto.setStatus(StatusProjeto.CANCELADO.name());

        when(projetoRepository.save(projeto)).thenReturn(projeto);

        ProjetoDTO savedProjeto = projetoService.saveProjeto(projeto);

        assertNotNull(savedProjeto);
        verify(projetoRepository, times(1)).save(projeto);
    }

    @Test
    void saveProjeto_ShouldThrowBadRequestException_WhenInvalidStatus() {
        ProjetoDTO projeto = new ProjetoDTO();
        projeto.setStatus("INVALID_STATUS");
        assertThrows(BadRequestException.class, () -> projetoService.saveProjeto(projeto));
    }

    @Test
    void updateProjeto_ShouldUpdateProjeto() {
        ProjetoDTO projeto = new ProjetoDTO();
        projeto.setStatus(StatusProjeto.EM_ANALISE.name());

        when(projetoRepository.save(projeto)).thenReturn(projeto);

        ProjetoDTO updatedProjeto = projetoService.updateProjeto(projeto);

        assertNotNull(updatedProjeto);
        verify(projetoRepository, times(1)).save(projeto);
    }

    @Test
    void listAllProjetos_ShouldReturnAllProjetos() {
        List<ProjetoDTO> projetos = Arrays.asList(new ProjetoDTO(), new ProjetoDTO());

        when(projetoRepository.findAll()).thenReturn(projetos);

        List<ProjetoDTO> result = projetoService.listAllProjetos();

        assertEquals(2, result.size());
        verify(projetoRepository, times(1)).findAll();
    }

    @Test
    void deleteProjeto_ShouldDeleteProjeto_WhenValidIdAndStatusAllowsDeletion() {
        ProjetoDTO projeto = new ProjetoDTO();
        projeto.setStatus(StatusProjeto.PLANEJADO.name());

        when(projetoRepository.findById(1)).thenReturn(Optional.of(projeto));

        projetoService.deleteProjeto(1);

        verify(projetoRepository, times(1)).deleteById(1);
    }

    @Test
    void deleteProjeto_ShouldThrowBadRequestException_WhenStatusDoesNotAllowDeletion() {
        ProjetoDTO projeto = new ProjetoDTO();
        projeto.setStatus(StatusProjeto.INICIADO.name());

        when(projetoRepository.findById(1)).thenReturn(Optional.of(projeto));

        assertThrows(BadRequestException.class, () -> projetoService.deleteProjeto(1));
        verify(projetoRepository, never()).deleteById(1);
    }

    @Test
    void deleteProjeto_ShouldThrowResourceNotFoundException_WhenInvalidId() {
        when(projetoRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> projetoService.deleteProjeto(1));
        verify(projetoRepository, never()).deleteById(1);
    }

    @Test
    void getProjeto_ShouldReturnProjeto_WhenValidId() {
        ProjetoDTO projeto = new ProjetoDTO();

        when(projetoRepository.getProjetoDTOById(1)).thenReturn(projeto);

        ProjetoDTO result = projetoService.getProjeto(1);

        assertNotNull(result);
        verify(projetoRepository, times(1)).getProjetoDTOById(1);
    }

    @Test
    void getProjeto_ShouldThrowResourceNotFoundException_WhenInvalidId() {
        when(projetoRepository.getProjetoDTOById(1)).thenReturn(null);

        assertThrows(ResourceNotFoundException.class, () -> projetoService.getProjeto(1));
    }
}
