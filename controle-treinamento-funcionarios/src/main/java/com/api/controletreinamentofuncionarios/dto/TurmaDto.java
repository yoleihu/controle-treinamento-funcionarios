package com.api.controletreinamentofuncionarios.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TurmaDto {
    private LocalDate inicio;
    private LocalDate fim;
    private String local;
    private Long cursoCodigo;

    public TurmaDto() {
    }

    public TurmaDto(LocalDate inicio, LocalDate fim, String local, Long cursoCodigo) {
        this.inicio = inicio;
        this.fim = fim;
        this.local = local;
        this.cursoCodigo = cursoCodigo;
    }
}
