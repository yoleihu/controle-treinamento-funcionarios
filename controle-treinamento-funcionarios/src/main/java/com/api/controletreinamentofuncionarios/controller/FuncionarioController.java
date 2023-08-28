package com.api.controletreinamentofuncionarios.controller;

import com.api.controletreinamentofuncionarios.dto.FuncionarioDto;
import com.api.controletreinamentofuncionarios.entity.Funcionario;
import com.api.controletreinamentofuncionarios.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @Autowired
    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping
    public ResponseEntity<List<Funcionario>> listarFuncionarios(@RequestParam(name = "ativo", required = false) Boolean ativo) {
        if (ativo != null) {
            return ResponseEntity.ok(funcionarioService.listarFuncionariosPorStatus(ativo));
        } else {
            return ResponseEntity.ok(funcionarioService.listarFuncionariosPorStatus(true));
        }
    }

    @PostMapping
    public ResponseEntity<Funcionario> cadastrarFuncionario(@RequestBody FuncionarioDto funcionario) {
        Funcionario novoFuncionario = funcionarioService.cadastrarFuncionario(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoFuncionario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizarFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionario) {
        Funcionario funcionarioExistente = funcionarioService.buscarFuncionarioPorId(id);
        funcionarioExistente.setNome(funcionario.getNome());
        funcionarioExistente.setCpf(funcionario.getCpf());
        funcionarioExistente.setNascimento(funcionario.getNascimento());
        funcionarioExistente.setCargo(funcionario.getCargo());
        funcionarioExistente.setAdmissao(funcionario.getAdmissao());
        funcionarioExistente.setStatus(funcionario.isStatus());

        Funcionario atualizadoFuncionario = funcionarioService.atualizarFuncionario(funcionarioExistente.getCodigo(),funcionarioExistente);
        return ResponseEntity.ok(atualizadoFuncionario);
    }

}
