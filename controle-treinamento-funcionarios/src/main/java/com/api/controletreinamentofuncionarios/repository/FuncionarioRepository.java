package com.api.controletreinamentofuncionarios.repository;
import com.api.controletreinamentofuncionarios.entity.Funcionario;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FuncionarioRepository extends CrudRepository <Funcionario, Long> {

    @Modifying
    @Query("INSERT INTO funcionario (nome, cpf, nascimento, cargo, admissao, status) " +
            "VALUES (:nome, :cpf, :nascimento, :cargo, :admissao, :status)")
    Funcionario criar(@Param("nome") String nome, @Param("cpf") String cpf,
                       @Param("nascimento") LocalDate nascimento, @Param("cargo") String cargo,
                       @Param("admissao") LocalDate admissao, @Param("status") boolean status);

    @Query("SELECT * FROM funcionario WHERE status = :status")
    List<Funcionario> encontrarPorStatus(@Param("status") boolean status);

    @Query("SELECT * FROM funcionario WHERE id = :id")
    Funcionario encontrarPorId(@Param("id") Long id);

    @Modifying
    @Query("UPDATE funcionario SET nome = :nome, cpf = :cpf, nascimento = :nascimento, " +
            "cargo = :cargo, admissao = :admissao, status = :status WHERE id = :id")
    Funcionario atualizar(@Param("id") Long id, @Param("nome") String nome, @Param("cpf") String cpf,
                       @Param("nascimento") LocalDate nascimento, @Param("cargo") String cargo,
                       @Param("admissao") LocalDate admissao, @Param("status") boolean status);


}

