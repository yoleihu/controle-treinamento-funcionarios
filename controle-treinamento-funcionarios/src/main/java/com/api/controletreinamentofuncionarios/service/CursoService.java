package com.api.controletreinamentofuncionarios.service;

import com.api.controletreinamentofuncionarios.dto.CursoDto;
import com.api.controletreinamentofuncionarios.entity.Curso;
import com.api.controletreinamentofuncionarios.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CursoService {
    private final CursoRepository cursoRepository;

    @Autowired
    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public List<Curso> listarCursos() {
        return (List<Curso>) cursoRepository.listar();
    }

    @Transactional
    public Curso cadastrarCurso(CursoDto curso) {
        return cursoRepository.criar(curso.getNome(), curso.getDescricao());
    }

    @Transactional
    public Curso atualizarCurso(Long codigo, Curso cursoAtualizado) {
        int rowsUpdated = cursoRepository.atualizar(codigo, cursoAtualizado.getNome(), cursoAtualizado.getDescricao());
        if (rowsUpdated > 0) {
            return cursoAtualizado;
        }
        return null;
    }

    @Transactional
    public void excluirCurso(Long codigo) {
        cursoRepository.deletar(codigo);
    }

    public Curso buscarCursoPorCodigo(Long codigo) {
        return cursoRepository.encontrarPorId(codigo);
    }
}
