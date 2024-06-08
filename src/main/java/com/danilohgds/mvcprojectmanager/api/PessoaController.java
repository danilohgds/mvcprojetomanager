package com.danilohgds.mvcprojectmanager.api;


import com.danilohgds.mvcprojectmanager.model.PessoaDTO;
import com.danilohgds.mvcprojectmanager.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class PessoaController {

    @Autowired
    private PessoaController(PessoaService pessoaService){
        this.pessoaService = pessoaService;
    }
    private final PessoaService pessoaService;

    @GetMapping(path="/pessoas/{id}")
    ResponseEntity<PessoaDTO> getPessoa(@PathVariable int id){
        return ResponseEntity.ok(pessoaService.getPessoaById(id));
    }

    @GetMapping(path="/pessoas/")
    ResponseEntity<List<PessoaDTO>> getPessoas(){
        return ResponseEntity.ok(pessoaService.getAllPessoas());
    }

    @PostMapping(path="/pessoas/")
    ResponseEntity<PessoaDTO> updatePessoa(@RequestBody PessoaDTO pessoaDTO){
        return ResponseEntity.ok(pessoaService.updatePessoa(pessoaDTO));
    }

    @PutMapping(path="/pessoas/")
    ResponseEntity<PessoaDTO> createPessoa(@RequestBody PessoaDTO pessoaDTO){
        return ResponseEntity.ok(pessoaService.createPessoa(pessoaDTO));
    }

    @DeleteMapping(path="/pessoas/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void deletePessoa(@PathVariable int id){
        pessoaService.deletePessoa(id);
    }
}
