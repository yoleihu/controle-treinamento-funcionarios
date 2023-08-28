package com.api.controletreinamentofuncionarios.service;

import com.api.controletreinamentofuncionarios.dto.ParticipanteDto;
import com.api.controletreinamentofuncionarios.entity.Participante;
import com.api.controletreinamentofuncionarios.repository.ParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ParticipanteService {
    private final ParticipanteRepository participanteRepository;

    @Autowired
    public ParticipanteService(ParticipanteRepository participanteRepository) {
        this.participanteRepository = participanteRepository;
    }


    public List<Participante> listarParticipantesDaTurma(Long turmaCodigo) {
        return participanteRepository.listarPorTurma(turmaCodigo);
    }

    @Transactional
    public Participante adicionarParticipanteNaTurma(ParticipanteDto participante) {
        participanteRepository.adicionarParticipanteNaTurma(participante.getTurmaCodigo(), participante.getFuncionarioCodigo());
        return null;
    }

    @Transactional
    public void removerParticipanteDaTurma(Long participanteCodigo) {
        participanteRepository.removeParticipante(participanteCodigo);
    }
}
