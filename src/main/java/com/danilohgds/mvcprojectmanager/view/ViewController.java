package com.danilohgds.mvcprojectmanager.view;

import com.danilohgds.mvcprojectmanager.exceptionhandling.BadRequestException;
import com.danilohgds.mvcprojectmanager.exceptionhandling.ResourceNotFoundException;
import com.danilohgds.mvcprojectmanager.model.MembroDTO;
import com.danilohgds.mvcprojectmanager.model.ProjetoDTO;
import com.danilohgds.mvcprojectmanager.service.MembroService;
import com.danilohgds.mvcprojectmanager.service.PessoaService;
import com.danilohgds.mvcprojectmanager.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class ViewController {

    public static final String PESSOAS = "pessoas";
    final PessoaService pessoaService;
    final MembroService membroService;
    final ProjetoService projetoService;

    @Autowired
    ViewController(PessoaService pessoaService, MembroService membroService, ProjetoService projetoService){
        this.pessoaService = pessoaService;
        this.membroService = membroService;
        this.projetoService = projetoService;
    }


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                setValue(LocalDate.parse(text, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            }

            @Override
            public String getAsText() {
                if(getValue() != null) {
                    return DateTimeFormatter.ofPattern("dd/MM/yyyy").format((LocalDate) getValue());
                }else {
                    return "";
                }
            }
        });
    }


    @RequestMapping("/view-pessoas")
    public ModelAndView viewPessoas(ModelAndView model) {
        model.setViewName("view-pessoas");
        model.addObject(PESSOAS, pessoaService.getAllPessoas());
        return model;
    }



    @GetMapping("/create-membro")
    public String showCreateMembroPage(Model model) {
        model.addAttribute("command", new MembroDTO());
        model.addAttribute(PESSOAS, pessoaService.getAllPessoas());
        model.addAttribute("projetos", projetoService.listAllProjetos());
        return "create-membro";
    }

    @PostMapping("/create-membro")
    public RedirectView createMembro(@ModelAttribute("membro") MembroDTO membroDTO) {
        final RedirectView redirectView = new RedirectView("/view-membros", true);
        membroService.saveMembro(membroDTO);
        return redirectView;
    }



    @RequestMapping("/view-projetos")
    public ModelAndView viewProjects(ModelAndView model) {
        model.setViewName("view-projetos");
        model.addObject("projetos", projetoService.listAllProjetos());
        return model;
    }

    @GetMapping("/create-projeto")
    public String showCreateProjetoPage(Model model) {
        model.addAttribute("command", new ProjetoDTO());
        model.addAttribute(PESSOAS, pessoaService.getAllPessoas());
        return "create-projeto";
    }

    @PostMapping("/delete-projeto")
    public RedirectView deleteProjeto(@RequestParam int idprojeto) throws BadRequestException, ResourceNotFoundException {
        final RedirectView redirectView = new RedirectView("/view-projetos", true);
        projetoService.deleteProjeto(idprojeto);
        return redirectView;
    }

    @PostMapping("/create-projeto")
    public RedirectView addProject(@ModelAttribute("projeto") ProjetoDTO projeto) {
        final RedirectView redirectView = new RedirectView("/view-projetos", true);
        projetoService.saveProjeto(projeto);
        return redirectView;
    }
}
