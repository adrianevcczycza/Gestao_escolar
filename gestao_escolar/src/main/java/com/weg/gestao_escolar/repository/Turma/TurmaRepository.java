package com.weg.gestao_escolar.repository.Turma;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.weg.gestao_escolar.model.Turma;

public interface TurmaRepository {
    Turma saveTurma(Turma turma) throws SQLException;
    List<Turma> findAllTurma() throws SQLException;
    Optional<Turma> findTurmaPorId(Long id) throws SQLException;
    void atualizarTurma(Turma Turma) throws SQLException;
    void deleteTurmaPorId(Long id) throws SQLException;
    
}
