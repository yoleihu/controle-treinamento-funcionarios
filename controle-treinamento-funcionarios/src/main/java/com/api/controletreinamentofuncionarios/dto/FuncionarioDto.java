package com.api.controletreinamentofuncionarios.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class FuncionarioDto {
    private String nome;
    private String cpf;
    private LocalDate nascimento;
    private String cargo;
    private LocalDate admissao;
    private boolean status;

    public FuncionarioDto() {}

    public FuncionarioDto(String nome, String cpf, LocalDate nascimento, String cargo, LocalDate admissao, boolean status) {
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.cargo = cargo;
        this.admissao = admissao;
        this.status = status;
    }
}
