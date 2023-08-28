package com.api.controletreinamentofuncionarios.entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Getter
@Setter
public class Funcionario {
    @Id
    private Long codigo;
    private String nome;
    private String cpf;
    private LocalDate nascimento;
    private String cargo;
    private LocalDate admissao;
    private boolean status;

    public Funcionario() {}

    public Funcionario(String nome, String cpf, LocalDate nascimento, String cargo, LocalDate admissao, boolean status) {
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.cargo = cargo;
        this.admissao = admissao;
        this.status = status;
    }
}
