package com.danilohgds.mvcprojectmanager.api;

import com.danilohgds.mvcprojectmanager.model.MembroDTO;
import com.danilohgds.mvcprojectmanager.service.MembroService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigInteger;
import java.util.Collections;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MembroController.class)
class MembroControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MembroService membroService;

    private MembroDTO membro;

    @BeforeEach
    public void setup() {
        membro = new MembroDTO();
        membro.setIdpessoa(1);
        membro.setIdprojeto(BigInteger.valueOf(1));

        given(membroService.getMembro(anyInt(), anyInt())).willReturn(membro);
        given(membroService.getAllMembros()).willReturn(Collections.singletonList(membro));
    }

    @Test
    void testGetMembro() throws Exception {
        mockMvc.perform(get("/membro/pessoa/1/projeto/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idpessoa", is(1)));
    }

}
