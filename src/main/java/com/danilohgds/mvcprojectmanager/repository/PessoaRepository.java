package com.danilohgds.mvcprojectmanager.repository;

import com.danilohgds.mvcprojectmanager.model.PessoaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaDTO, Integer> {

    PessoaDTO save(PessoaDTO pessoaDTO);

    PessoaDTO getPessoaDTOById(int id);

    void deletePessoaDTOById(int id);
}

