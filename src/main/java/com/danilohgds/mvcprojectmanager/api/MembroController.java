package com.danilohgds.mvcprojectmanager.api;

import com.danilohgds.mvcprojectmanager.model.MembroDTO;
import com.danilohgds.mvcprojectmanager.service.MembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MembroController {

    final MembroService membroService;

    @Autowired
    MembroController( MembroService membroService){
        this.membroService = membroService;
    }

    @GetMapping("/membro/pessoa/{idpessoa}/projeto/{idprojeto}")
    public MembroDTO getMembro(@PathVariable int idpessoa, @PathVariable int idprojeto) {
        return membroService.getMembro(idpessoa, idprojeto);
    }

    @GetMapping("/list-membros")
    public List<MembroDTO> viewMembros(){
        return membroService.getAllMembros();
    }
}
