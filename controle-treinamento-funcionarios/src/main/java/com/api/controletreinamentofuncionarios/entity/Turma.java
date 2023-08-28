package com.api.controletreinamentofuncionarios.entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Turma {
    @Id
    private Long codigo;
    private LocalDate inicio;
    private LocalDate fim;
    private String local;

    @Column("curso")
    private Long cursoCodigo;

    public Turma() {}

    @PersistenceConstructor
    public Turma(LocalDate inicio, LocalDate fim, String local, Long cursoCodigo) {
        this.inicio = inicio;
        this.fim = fim;
        this.local = local;
        this.cursoCodigo = cursoCodigo;
    }
}
