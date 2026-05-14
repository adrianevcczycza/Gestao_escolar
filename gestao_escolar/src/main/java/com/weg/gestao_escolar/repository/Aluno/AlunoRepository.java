package com.weg.gestao_escolar.repository.Aluno;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.weg.gestao_escolar.model.Aluno;

public interface AlunoRepository{

    Aluno saveAluno(Aluno aluno) throws SQLException;
    List<Aluno> findAllContatos() throws SQLException;
    Optional<Aluno> findPorId(Long id) throws SQLException;
    void atualizarAluno(Aluno aluno) throws SQLException;
    void deletePorId(Long id) throws SQLException;
}