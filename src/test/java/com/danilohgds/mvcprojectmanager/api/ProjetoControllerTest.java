package com.danilohgds.mvcprojectmanager.api;

import com.danilohgds.mvcprojectmanager.model.ProjetoDTO;
import com.danilohgds.mvcprojectmanager.service.ProjetoService;
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

@WebMvcTest(ProjetoController.class)
class ProjetoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProjetoService projetoService;

    @BeforeEach
    public void setup() {
        ProjetoDTO projetoDTO = new ProjetoDTO();
        projetoDTO.setId(1);
        projetoDTO.setNome("Project Alpha");

        BDDMockito.given(projetoService.getProjeto(anyInt())).willReturn(projetoDTO);
        BDDMockito.given(projetoService.listAllProjetos()).willReturn(List.of(projetoDTO));
        BDDMockito.given(projetoService.saveProjeto(any(ProjetoDTO.class))).willReturn(projetoDTO);
        BDDMockito.given(projetoService.updateProjeto(any(ProjetoDTO.class))).willReturn(projetoDTO);
    }

    @Test
    void testGetProjetos() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/projetos/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].nome", is("Project Alpha")));
    }

    @Test
    void testCreateProjeto() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/projetos/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"nome\":\"Project Alpha\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.nome", is("Project Alpha")));
    }

    @Test
    void testUpdateProjeto() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/projetos/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"nome\":\"Project Alpha\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.nome", is("Project Alpha")));
    }

    @Test
    void testDeleteProjeto() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/projetos/1"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetProjeto() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/projetos/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.nome", is("Project Alpha")));
    }
}
