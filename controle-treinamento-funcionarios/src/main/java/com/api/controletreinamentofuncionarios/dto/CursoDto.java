package com.api.controletreinamentofuncionarios.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CursoDto {
    private String nome;
    private String descricao;
    private Integer duracao;

    public CursoDto() {}

    public CursoDto(String nome, String descricao, Integer duracao) {
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
    }

}
