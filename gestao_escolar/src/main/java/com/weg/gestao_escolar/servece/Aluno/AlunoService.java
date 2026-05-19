package com.weg.gestao_escolar.servece.Aluno;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.weg.gestao_escolar.dto.aluno.AlunoRequisicaoDTO;
import com.weg.gestao_escolar.dto.aluno.AlunoRespostaDTO;
import com.weg.gestao_escolar.model.Aluno;


public interface AlunoService {

    AlunoRespostaDTO saveAluno(AlunoRequisicaoDTO requisicaoDto) throws SQLException;
    Optional<Aluno> findPorId(Long id) throws SQLException;
    void deletePorId(Long id) throws SQLException;
    AlunoRespostaDTO buscarPorId(Long id);
    List<Aluno> findAllAlunos() throws SQLException;
    AlunoRespostaDTO atualizarAluno(Long id, AlunoRequisicaoDTO aluno) throws SQLException;


}