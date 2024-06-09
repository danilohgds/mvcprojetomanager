package com.danilohgds.mvcprojectmanager.view;

import com.danilohgds.mvcprojectmanager.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class ViewController {

    public static final String PESSOAS = "pessoas";
    final PessoaService pessoaService;

    ViewController(@Autowired PessoaService pessoaService){
        this.pessoaService = pessoaService;
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
}
