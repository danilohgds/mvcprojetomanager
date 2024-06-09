package com.danilohgds.mvcprojectmanager.repository;

import com.danilohgds.mvcprojectmanager.model.MembroDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembroRepository extends JpaRepository<MembroDTO, Integer> {

    MembroDTO getMembroDTOByIdpessoaAndIdprojeto(int idpessoa, int idprojeto);
}
