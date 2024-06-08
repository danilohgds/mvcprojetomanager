package com.danilohgds.mvcprojectmanager.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
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
    private String risco;
    private String status;
}
