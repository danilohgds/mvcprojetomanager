package com.danilohgds.mvcprojectmanager.repository;

import com.danilohgds.mvcprojectmanager.model.ProjetoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoRepository extends JpaRepository<ProjetoDTO, Integer> {

    ProjetoDTO getProjetoDTOById(int id);
    ProjetoDTO save(ProjetoDTO projetoDTO);

}
