package com.weg.gestao_escolar.repository.Curso;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.weg.gestao_escolar.model.Curso;

public interface CursoRepository {

    Curso saveCurso(Curso curso) throws SQLException;
    List<Curso> Curso() throws SQLException;
    Optional<Curso> findPorId(Long id) throws SQLException;
    void atualizarCurso(Curso curso) throws SQLException;
    void deleteCursoPorId(Long id) throws SQLException;
}
