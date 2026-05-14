package com.weg.gestao_escolar.servece.Aluno;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.weg.gestao_escolar.dto.aluno.AlunoRequisicaoDTO;
import com.weg.gestao_escolar.dto.aluno.AlunoRespostaDTO;
import com.weg.gestao_escolar.model.Aluno;

public interface AlunoService {

    Aluno saveAluno(AlunoRequisicaoDTO requisicaoDto) throws SQLException;
    List<Aluno> findAllContatos() throws SQLException;
    Optional<Aluno> findPorId(Long id) throws SQLException;
    void atualizarAluno(Aluno aluno) throws SQLException;
    void deletePorId(Long id) throws SQLException;
    Aluno buscarPorId(Long id);
    List<Aluno> findAllAlunos() throws SQLException;
    Aluno saveAluno(Aluno aluno) throws SQLException;

    
}