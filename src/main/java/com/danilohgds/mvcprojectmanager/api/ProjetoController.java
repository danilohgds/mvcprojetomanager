package com.danilohgds.mvcprojectmanager.api;


import com.danilohgds.mvcprojectmanager.exceptionhandling.BadRequestException;
import com.danilohgds.mvcprojectmanager.exceptionhandling.ResourceNotFoundException;
import com.danilohgds.mvcprojectmanager.model.ProjetoDTO;
import com.danilohgds.mvcprojectmanager.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjetoController {
    private final ProjetoService projetoService;

    @Autowired
    ProjetoController(ProjetoService projetoService){
        this.projetoService = projetoService;
    }

    @GetMapping(path = "/projetos/")
    ResponseEntity<List<ProjetoDTO>> getProjetos(){
        return ResponseEntity.ok(projetoService.listAllProjetos());
    }

    @GetMapping(path = "/projetos/{id}")
    ResponseEntity<ProjetoDTO> getProjeto(@PathVariable int id){
        return ResponseEntity.ok(projetoService.getProjeto(id));
    }

    @PutMapping(path = "/projetos/")
    ResponseEntity<ProjetoDTO> createProjeto(@RequestBody ProjetoDTO projeto){
        return ResponseEntity.ok(projetoService.saveProjeto(projeto));
    }

    @PostMapping(path = "/projetos/")
    ResponseEntity<ProjetoDTO> updateProjeto(@RequestBody @Validated ProjetoDTO projeto){
        return ResponseEntity.ok(projetoService.updateProjeto(projeto));
    }

    @DeleteMapping(path = "/projetos/{id}")
    HttpStatus deleteProjeto(@PathVariable int id) throws BadRequestException, ResourceNotFoundException {
        projetoService.deleteProjeto(id);
        return HttpStatus.ACCEPTED;
    }
}
