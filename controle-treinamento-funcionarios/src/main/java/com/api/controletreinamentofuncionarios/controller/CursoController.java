package com.api.controletreinamentofuncionarios.controller;

import com.api.controletreinamentofuncionarios.dto.CursoDto;
import com.api.controletreinamentofuncionarios.service.CursoService;
import com.api.controletreinamentofuncionarios.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.api.controletreinamentofuncionarios.entity.Curso;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    private final CursoService cursoService;
    private final TurmaService turmaService;

    @Autowired
    public CursoController(CursoService cursoService, TurmaService turmaService) {

        this.cursoService = cursoService;
        this.turmaService = turmaService;
    }

    @GetMapping
    public List<Curso> listarCursos() {
        return cursoService.listarCursos();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Curso> buscarCursoPorCodigo(@PathVariable Long codigo) {
        Curso curso = cursoService.buscarCursoPorCodigo(codigo);
        if (curso != null) {
            return ResponseEntity.ok(curso);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Curso> cadastrarCurso(@RequestBody CursoDto curso) {
        Curso cursoCadastrado = cursoService.cadastrarCurso(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoCadastrado);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Curso> atualizarCurso(@PathVariable Long codigo, @RequestBody Curso cursoAtualizado) {
        Curso curso = cursoService.atualizarCurso(codigo, cursoAtualizado);
        if (curso != null) {
            return ResponseEntity.ok(curso);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> excluirCurso(@PathVariable Long codigo) {
        cursoService.excluirCurso(codigo);
        turmaService.excluirPorCurso(codigo);
        return ResponseEntity.noContent().build();
    }
}

