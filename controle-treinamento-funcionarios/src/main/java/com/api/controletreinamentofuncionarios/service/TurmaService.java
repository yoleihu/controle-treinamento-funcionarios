package com.api.controletreinamentofuncionarios.service;

import com.api.controletreinamentofuncionarios.dto.TurmaDto;
import com.api.controletreinamentofuncionarios.entity.Turma;
import com.api.controletreinamentofuncionarios.repository.ParticipanteRepository;
import com.api.controletreinamentofuncionarios.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TurmaService {
    private final TurmaRepository turmaRepository;
    private final ParticipanteRepository participanteRepository;

    @Autowired
    public TurmaService(TurmaRepository turmaRepository, ParticipanteRepository participanteRepository) {
        this.turmaRepository = turmaRepository;
        this.participanteRepository = participanteRepository;
    }

    public List<Turma> listarTurmasPorCurso(Long cursoCodigo) {
        return turmaRepository.listarPorCurso(cursoCodigo);
    }

    @Transactional
    public Turma criarTurma(TurmaDto turma) {
        return turmaRepository.criar(turma.getInicio(), turma.getFim(), turma.getLocal(), turma.getCursoCodigo());
    }

    @Transactional
    public Turma atualizarTurma(Turma turma) {
        return turmaRepository.atualizar(turma.getCodigo(), turma.getInicio(), turma.getFim(), turma.getLocal());
    }

    @Transactional
    public void excluirTurma(Long turmaCodigo) {
        turmaRepository.excluir(turmaCodigo);
    }

    @Transactional
    public void excluirPorCurso(Long turmaCodigo) {
        turmaRepository.excluirPorCurso(turmaCodigo);
    }

}


