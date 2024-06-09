package com.danilohgds.mvcprojectmanager.model;

import com.danilohgds.mvcprojectmanager.enums.RiscoProjeto;
import com.danilohgds.mvcprojectmanager.enums.StatusProjeto;
import com.danilohgds.mvcprojectmanager.exceptionhandling.ValidEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name="projeto")
@DynamicUpdate
public class ProjetoDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String nome;
    private int idgerente;
    private Float orcamentoTotal;
    private String descricao;
    @JsonFormat(pattern = "dd/mm/yyyy")
    private LocalDate dataInicio;
    @JsonFormat(pattern = "dd/mm/yyyy")
    private LocalDate dataPrevisaoTermino;
    @JsonFormat(pattern = "dd/mm/yyyy")
    private LocalDate dataRealTermino;
    @NotBlank(message = "Risco cannot be blank")
    @ValidEnum(enumClass = RiscoProjeto.class, message = "Risco must be a valid value")
    private String risco;
    @NotBlank(message = "Status cannot be blank")
    @ValidEnum(enumClass = StatusProjeto.class, message = "Status must be a valid value")
    private String status;
}
