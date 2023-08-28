package com.api.controletreinamentofuncionarios.service;

import com.api.controletreinamentofuncionarios.dto.FuncionarioDto;
import com.api.controletreinamentofuncionarios.entity.Funcionario;
import com.api.controletreinamentofuncionarios.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    @Autowired
    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @Transactional
    public Funcionario cadastrarFuncionario(FuncionarioDto funcionario) {
        return funcionarioRepository.criar(
                funcionario.getNome(), funcionario.getCpf(), funcionario.getNascimento(),
                funcionario.getCargo(), funcionario.getAdmissao(), funcionario.isStatus()
        );
    }

    @Transactional
    public Funcionario atualizarFuncionario(Long id, Funcionario funcionario) {
        return funcionarioRepository.atualizar(
                id, funcionario.getNome(), funcionario.getCpf(), funcionario.getNascimento(),
                funcionario.getCargo(), funcionario.getAdmissao(), funcionario.isStatus()
        );
    }

    public List<Funcionario> listarFuncionariosPorStatus(boolean ativo) {
        return funcionarioRepository.encontrarPorStatus(ativo);
    }

    public Funcionario buscarFuncionarioPorId(Long id) {
        return funcionarioRepository.encontrarPorId(id);
    }
}

