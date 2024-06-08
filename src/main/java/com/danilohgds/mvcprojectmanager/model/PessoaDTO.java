package com.danilohgds.mvcprojectmanager.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pessoa")
@DynamicUpdate
public class PessoaDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String nome;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate datanascimento;
    @NotNull
    private String cpf;
    @NotNull
    private Boolean funcionario;
    @NotNull
    private Boolean gerente;
}
