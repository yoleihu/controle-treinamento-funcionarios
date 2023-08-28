package com.api.controletreinamentofuncionarios.controller;

import com.api.controletreinamentofuncionarios.dto.TurmaDto;
import com.api.controletreinamentofuncionarios.entity.Turma;
import com.api.controletreinamentofuncionarios.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

    private final TurmaService turmaService;

    @Autowired
    public TurmaController(TurmaService turmaService) {
        this.turmaService = turmaService;
    }

    @GetMapping("/{cursoCodigo}")
    public ResponseEntity<List<Turma>> listarTurmasPorCurso(@PathVariable Long cursoCodigo) {
        List<Turma> turmas = turmaService.listarTurmasPorCurso(cursoCodigo);
        return ResponseEntity.ok(turmas);
    }

    @PostMapping
    public ResponseEntity<Turma> criarTurma(@RequestBody TurmaDto turma) {
        Turma novaTurma = turmaService.criarTurma(turma);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaTurma);
    }

    @PutMapping("/{turmaCodigo}")
    public ResponseEntity<Turma> atualizarTurma(@PathVariable Long turmaCodigo, @RequestBody Turma turma) {
        turma.setCodigo(turmaCodigo);
        Turma turmaAtualizada = turmaService.atualizarTurma(turma);
        return ResponseEntity.ok(turmaAtualizada);
    }

    @DeleteMapping("/{turmaCodigo}")
    public ResponseEntity<Void> excluirTurma(@PathVariable Long turmaCodigo) {
        turmaService.excluirTurma(turmaCodigo);
        return ResponseEntity.noContent().build();
    }
}

