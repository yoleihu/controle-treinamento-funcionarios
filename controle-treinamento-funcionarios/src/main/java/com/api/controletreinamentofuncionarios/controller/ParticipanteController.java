package com.api.controletreinamentofuncionarios.controller;

import com.api.controletreinamentofuncionarios.dto.ParticipanteDto;
import com.api.controletreinamentofuncionarios.entity.Participante;
import com.api.controletreinamentofuncionarios.service.ParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/participantes")
public class ParticipanteController {
    private final ParticipanteService participanteService;

    @Autowired
    public ParticipanteController(ParticipanteService participanteService) {
        this.participanteService = participanteService;
    }

    @GetMapping("/{turmaCodigo}")
    public ResponseEntity<List<Participante>> listarParticipantesDaTurma(@PathVariable Long turmaCodigo) {
        List<Participante> participantes = participanteService.listarParticipantesDaTurma(turmaCodigo);
        return ResponseEntity.ok(participantes);
    }

    @PostMapping
    public ResponseEntity<Participante> adicionarParticipanteNaTurma(@RequestBody ParticipanteDto participante) {
        Participante novoParticipante = participanteService.adicionarParticipanteNaTurma(participante);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoParticipante);
    }

    @DeleteMapping("/{ParticipanteCodigo}")
    public ResponseEntity<Void> removerParticipanteDaTurma(@PathVariable Long participanteCodigo) {
        participanteService.removerParticipanteDaTurma(participanteCodigo);
        return ResponseEntity.noContent().build();
    }
}
