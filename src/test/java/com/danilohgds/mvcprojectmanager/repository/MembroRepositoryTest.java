package com.danilohgds.mvcprojectmanager.repository;

import com.danilohgds.mvcprojectmanager.model.MembroDTO;
import com.danilohgds.mvcprojectmanager.model.PessoaDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigInteger;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Disabled
class MembroRepositoryTest {

    @Autowired
    private MembroRepository membroRepository;

    @Autowired PessoaRepository pessoaRepository;

    @BeforeEach
    public void setUp() {
        // Clean up the database before each test

        membroRepository.deleteAll();
        pessoaRepository.deleteAll();

        PessoaDTO pessoa1 = new PessoaDTO(1, "danilo", LocalDate.now(), "0", Boolean.TRUE, Boolean.TRUE);
        PessoaDTO pessoa2 = new PessoaDTO(2, "danilo2", LocalDate.now(), "0", Boolean.TRUE, Boolean.TRUE);

        pessoaRepository.save(pessoa1);
        pessoaRepository.save(pessoa2);

        // Set up initial data for tests
        MembroDTO membro1 = new MembroDTO();
        membro1.setIdpessoa(pessoa1.getId());
        membro1.setIdprojeto(BigInteger.valueOf(101));

        MembroDTO membro2 = new MembroDTO();
        membro2.setIdpessoa(pessoa2.getId());
        membro2.setIdprojeto(BigInteger.valueOf(102));

        membroRepository.save(membro1);
        membroRepository.save(membro2);
    }

    @Test
    void whenFindByIdpessoaAndIdprojeto_thenReturnMembro() {
        // given
        int idpessoa = 1;
        int idprojeto = 101;

        // when
        MembroDTO found = membroRepository.getMembroDTOByIdpessoaAndIdprojeto(idpessoa, idprojeto);

        // then
        assertThat(found).isNotNull();
        assertThat(found.getIdpessoa()).isEqualTo(idpessoa);
        assertThat(found.getIdprojeto()).isEqualTo(idprojeto);
    }

    @Test
    void whenFindByNonExistingIdpessoaAndIdprojeto_thenReturnNull() {
        // given
        int idpessoa = 999;
        int idprojeto = 999;

        // when
        MembroDTO found = membroRepository.getMembroDTOByIdpessoaAndIdprojeto(idpessoa, idprojeto);

        // then
        assertThat(found).isNull();
    }
}
