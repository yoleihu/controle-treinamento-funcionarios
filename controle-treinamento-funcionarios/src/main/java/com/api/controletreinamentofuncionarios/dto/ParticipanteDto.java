package com.api.controletreinamentofuncionarios.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParticipanteDto {
    private Long turmaCodigo;
    private Long funcionarioCodigo;

    public ParticipanteDto() {}

    public ParticipanteDto(Long turmaCodigo, Long funcionarioCodigo) {
        this.turmaCodigo = turmaCodigo;
        this.funcionarioCodigo = funcionarioCodigo;
    }
}
