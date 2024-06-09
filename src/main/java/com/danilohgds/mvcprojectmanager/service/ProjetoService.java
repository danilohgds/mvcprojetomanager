package com.danilohgds.mvcprojectmanager.service;


import com.danilohgds.mvcprojectmanager.enums.StatusProjeto;
import com.danilohgds.mvcprojectmanager.model.ProjetoDTO;
import com.danilohgds.mvcprojectmanager.repository.ProjetoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {

    private final ProjetoRepository projetoRepository;

    ProjetoService(@Autowired ProjetoRepository projetoRepository){
        this.projetoRepository = projetoRepository;
    }

    public ProjetoDTO saveProjeto(ProjetoDTO projetoDTO){
       return projetoRepository.save(projetoDTO);
    }

    @Transactional
    public ProjetoDTO updateProjeto(ProjetoDTO projeto) {
        return projetoRepository.save(projeto);
    }

    public List<ProjetoDTO> listAllProjetos() {
        return projetoRepository.findAll();
    }

    public void deleteProjeto(int id){
        Optional<ProjetoDTO> projeto = projetoRepository.findById(id);

        if(projeto.isPresent() && StatusProjeto.valueOf(projeto.get().getStatus().toUpperCase().replace(" ", "_")).podeExcluir()){
            projetoRepository.deleteById(id);
        }
    }

    public ProjetoDTO getProjeto(int id) {
        return projetoRepository.getProjetoDTOById(id);
    }
}
