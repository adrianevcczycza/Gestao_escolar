package com.weg.gestao_escolar.repository.Aluno;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.weg.gestao_escolar.dto.aluno.AlunoRequisicaoDTO;
import com.weg.gestao_escolar.model.Aluno;

public interface AlunoRepository{

    Aluno saveAluno(Aluno aluno) throws SQLException;
    static Optional<Aluno> findAlunoPorId(Long id) throws SQLException {
        return null;
    }
    void deletePorId(Long id) throws SQLException;
    List<Aluno> findAllAlunos() throws SQLException;
    Aluno atualizarAluno(Aluno aluno) throws SQLException;
    boolean existsPorId(Long id);
    void atualizarAluno() throws SQLException;
}