package com.api.controletreinamentofuncionarios.repository;
import com.api.controletreinamentofuncionarios.entity.Turma;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TurmaRepository extends CrudRepository <Turma, Long> {

    @Query("SELECT * FROM turma WHERE curso = :cursoCodigo")
    List<Turma> listarPorCurso(@Param("cursoCodigo") Long cursoCodigo);

    @Query("SELECT * FROM turma WHERE codigo = :turmaCodigo")
    Turma buscarPorCodigo(@Param("turmaCodigo") Long turmaCodigo);

    @Query("INSERT INTO turma (inicio, fim, local, curso) VALUES (:inicio, :fim, :local, :curso)")
    Turma criar(@Param("inicio") LocalDate inicio, @Param("fim") LocalDate fim, @Param("local") String local, @Param("curso") Long curso);

    @Query("UPDATE turma SET inicio = :inicio, fim = :fim, local = :local WHERE codigo = :codigo")
    Turma atualizar(@Param("codigo") Long codigo, @Param("inicio") LocalDate inicio, @Param("fim") LocalDate fim, @Param("local") String local);

    @Query("DELETE FROM turma WHERE codigo = :codigo")
    void excluir(@Param("codigo") Long codigo);

    @Query("DELETE * FROM turma WHERE curso = :cursoCodigo\"")
    void excluirPorCurso(@Param("codigo") Long codigo);
}

