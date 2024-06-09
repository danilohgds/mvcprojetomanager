package com.danilohgds.mvcprojectmanager.api;

import com.danilohgds.mvcprojectmanager.model.PessoaDTO;
import com.danilohgds.mvcprojectmanager.service.PessoaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PessoaController.class)
class PessoaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PessoaService pessoaService;

    @BeforeEach
    public void setup() {
        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setId(1);
        pessoaDTO.setNome("Joao Dasilva");

        BDDMockito.given(pessoaService.getPessoaById(anyInt())).willReturn(pessoaDTO);
        BDDMockito.given(pessoaService.getAllPessoas()).willReturn(List.of(pessoaDTO));
        BDDMockito.given(pessoaService.updatePessoa(any(PessoaDTO.class))).willReturn(pessoaDTO);
        BDDMockito.given(pessoaService.savePessoa(any(PessoaDTO.class))).willReturn(pessoaDTO);
    }

    @Test
    void testGetPessoa() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/pessoas/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.nome", is("Joao Dasilva")));
    }

    @Test
    void testGetPessoas() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/pessoas/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].nome", is("Joao Dasilva")));
    }

    @Test
    void testUpdatePessoa() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/pessoas/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"id":1,"nome":"Joao Dasilva", "cpf": "000.000.000", "funcionario": "false",  "gerente": "false" }"""))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.nome", is("Joao Dasilva")));
    }

    @Test
    void testCreatePessoa() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/api/pessoas/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"id":1,"nome":"Joao Dasilva", "cpf": "000.000.000", "funcionario": "false",  "gerente": "false" }"""))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.nome", is("Joao Dasilva")));
    }

    @Test
    void testDeletePessoa() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/pessoas/1"))
                .andExpect(status().isAccepted());
    }
}
