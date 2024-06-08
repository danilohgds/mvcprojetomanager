package com.danilohgds.mvcprojectmanager.service;

import com.danilohgds.mvcprojectmanager.model.PessoaDTO;
import com.danilohgds.mvcprojectmanager.repository.PessoaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    final PessoaRepository pessoaRepository;

    PessoaService(@Autowired PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
    }
    public PessoaDTO createPessoa(PessoaDTO pessoaDTO) {
        return pessoaRepository.save(pessoaDTO);
    }

    public PessoaDTO getPessoaById(int id) {
        return pessoaRepository.getPessoaDTOById(id);
    }

    @Transactional
    public void deletePessoa(int id) {
        pessoaRepository.deletePessoaDTOById(id);
    }

    @Transactional
    public PessoaDTO updatePessoa(PessoaDTO pessoaDTO){
        return pessoaRepository.save(pessoaDTO);
    }

    public List<PessoaDTO> getAllPessoas() {
        return pessoaRepository.findAll();
    }
}
