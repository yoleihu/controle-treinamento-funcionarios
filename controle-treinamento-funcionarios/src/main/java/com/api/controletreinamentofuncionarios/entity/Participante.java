package com.api.controletreinamentofuncionarios.entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.relational.core.mapping.Column;

@Getter
@Setter
public class Participante {
    @Id
    private Long codigo;

    @Column("turma")
    private Long turmaCodigo;

    @Column("funcionario")
    private Long funcionarioCodigo;

    public Participante() {}

    @PersistenceConstructor
    public Participante(Long turmaCodigo, Long funcionarioCodigo) {
        this.turmaCodigo = turmaCodigo;
        this.funcionarioCodigo = funcionarioCodigo;
    }
}
