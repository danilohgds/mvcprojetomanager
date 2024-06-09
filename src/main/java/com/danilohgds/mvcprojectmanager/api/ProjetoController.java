package com.danilohgds.mvcprojectmanager.api;


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

    ProjetoController(@Autowired ProjetoService projetoService){
        this.projetoService = projetoService;
    }

}
