package com.weg.gestao_escolar.repository.Nota;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.weg.gestao_escolar.model.Nota;

public interface NotaRepository {
    Nota saveNota(Nota nota) throws SQLException;
    List<Nota> findAllContatos() throws SQLException;
    Optional<Nota> findPorId(Long id) throws SQLException;
    void atualizarAluno(Nota nota) throws SQLException;
    void deleteNotaPorId(Long id) throws SQLException;
}

