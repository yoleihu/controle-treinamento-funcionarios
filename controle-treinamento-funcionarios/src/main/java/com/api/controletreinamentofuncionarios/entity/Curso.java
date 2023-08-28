package com.api.controletreinamentofuncionarios.entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Curso {
    @Id
    private Long codigo;
    private String nome;
    private String descricao;
    private Integer duracao;

    public Curso() {}

    public Curso(String nome, String descricao, Integer duracao) {
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
    }
}
