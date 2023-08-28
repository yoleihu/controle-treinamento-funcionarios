package com.api.controletreinamentofuncionarios.repository;
import com.api.controletreinamentofuncionarios.entity.Curso;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends CrudRepository <Curso, Long> {

    @Modifying
    @Query("INSERT INTO curso (nome, descricao) VALUES (:nome, :descricao)")
    Curso criar(@Param("nome") String nome, @Param("descricao") String descricao);

    @Query("SELECT * FROM curso WHERE id = :id")
    Curso encontrarPorId(@Param("id") Long id);

    @Query("SELECT * FROM curso")
    List<Curso> listar();

    @Modifying
    @Query("UPDATE curso SET nome = :nome, descricao = :descricao WHERE id = :id")
    int atualizar(@Param("id") Long id, @Param("nome") String nome, @Param("descricao") String descricao);

    @Modifying
    @Query("DELETE FROM curso WHERE id = :id")
    int deletar(@Param("id") Long id);
}

