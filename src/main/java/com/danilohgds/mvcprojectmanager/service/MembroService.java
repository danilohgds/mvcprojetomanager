package com.danilohgds.mvcprojectmanager.service;

import com.danilohgds.mvcprojectmanager.model.MembroDTO;
import com.danilohgds.mvcprojectmanager.repository.MembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembroService {

    final MembroRepository membroRepository;

    MembroService(@Autowired MembroRepository membroRepository){
        this.membroRepository = membroRepository;
    }
    public MembroDTO saveMembro(MembroDTO membroDTO) {
       return membroRepository.save(membroDTO);
    }

    public MembroDTO getMembro(int idpessoa, int idprojeto){
        return membroRepository.getMembroDTOByIdpessoaAndIdprojeto(idpessoa, idprojeto);
    }

    public List<MembroDTO> getAllMembros() {
        return membroRepository.findAll();
    }
}
