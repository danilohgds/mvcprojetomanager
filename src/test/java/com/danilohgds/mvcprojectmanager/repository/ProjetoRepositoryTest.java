package com.danilohgds.mvcprojectmanager.repository;

import com.danilohgds.mvcprojectmanager.model.ProjetoDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Disabled
class ProjetoRepositoryTest {

    @Autowired
    private ProjetoRepository projetoRepository;

    @BeforeEach
    public void setUp() {
        // Clean up the database before each test
        projetoRepository.deleteAll();

        // Set up initial data for tests
        ProjetoDTO newProjeto1 = new ProjetoDTO();
        newProjeto1.setId(1);
        newProjeto1.setNome("Projeto One");

        ProjetoDTO newProjeto2 = new ProjetoDTO();
        newProjeto2.setId(2);
        newProjeto2.setNome("Projeto Two");

        projetoRepository.save(newProjeto1);
        projetoRepository.save(newProjeto2);
    }

    @Test
    void whenFindById_thenReturnProjeto() {
        // given
        int id = 1;

        // when
        ProjetoDTO projeto = projetoRepository.getProjetoDTOById(id);

        // then
        assertThat(projeto).isNotNull();
        assertThat(projeto.getId()).isEqualTo(id);
        assertThat(projeto.getNome()).isEqualTo("Projeto One");
    }

    @Test
    void whenFindByNonExistingId_thenReturnNull() {
        // given
        int id = 999;

        // when
        ProjetoDTO projeto = projetoRepository.getProjetoDTOById(id);

        // then
        assertThat(projeto).isNull();
    }

    @Test
    void whenSaveProjeto_thenReturnSavedProjeto() {
        // given
        ProjetoDTO newProjeto = new ProjetoDTO();
        newProjeto.setId(3);
        newProjeto.setNome("New Projeto");

        // when
        ProjetoDTO projeto = projetoRepository.save(newProjeto);

        // then
        assertThat(projeto).isNotNull();
        assertThat(projeto.getId()).isEqualTo(3);
        assertThat(projeto.getNome()).isEqualTo("New Projeto");
    }
}
