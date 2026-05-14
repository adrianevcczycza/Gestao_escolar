package com.weg.gestao_escolar.repository.Professor;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.weg.gestao_escolar.model.Professor;

public interface ProfessorRepository {

    Professor saveProfessor(Professor professor) throws SQLException;
    List<Professor> findAllProfessor() throws SQLException;
    Optional<Professor> findPorId(Long id) throws SQLException;
    void atualizarProfessor(Professor professor) throws SQLException;
    void deletePorId(Long id) throws SQLException;
    
}
