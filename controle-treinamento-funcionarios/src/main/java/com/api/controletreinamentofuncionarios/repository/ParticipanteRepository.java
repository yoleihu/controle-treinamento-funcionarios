package com.api.controletreinamentofuncionarios.repository;

import com.api.controletreinamentofuncionarios.entity.Participante;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ParticipanteRepository extends CrudRepository <Participante, Long> {

    @Query("SELECT * FROM participante WHERE turma = :turmaCodigo")
    List<Participante> listarPorTurma(@Param("turmaCodigo") Long turmaCodigo);

    @Modifying
    @Query("INSERT INTO participante (turma, funcionario) VALUES (:turmaCodigo, :funcionarioCodigo)")
    void adicionarParticipanteNaTurma(@Param("turmaCodigo") Long turmaCodigo, @Param("funcionarioCodigo") Long funcionarioCodigo);

    @Modifying
    @Query("DELETE FROM participante WHERE codigo = :participanteCodigo")
    void removeParticipante(@Param("participanteCodigo") Long participanteCodigo);
}
