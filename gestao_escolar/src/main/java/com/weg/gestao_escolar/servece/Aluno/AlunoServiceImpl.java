package com.weg.gestao_escolar.servece.Aluno;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.weg.gestao_escolar.dto.aluno.AlunoRequisicaoDTO;
import com.weg.gestao_escolar.dto.aluno.AlunoRespostaDTO;
import com.weg.gestao_escolar.mapper.AlunoMapper;
import com.weg.gestao_escolar.model.Aluno;
import com.weg.gestao_escolar.repository.Aluno.AlunoRepository;

@Service
public class AlunoServiceImpl implements AlunoService{
    private AlunoRepository alunoRepository;
    private AlunoMapper alunoMapper;


    @Override
    public AlunoRespostaDTO saveAluno(AlunoRequisicaoDTO requisicaoDto) throws SQLException {
        
        Aluno aluno
        = alunoMapper.paraEntidade(requisicaoDto);
        alunoRepository.saveAluno(aluno);
        return alunoMapper.paraRespostaDto(aluno);
    }

    @Override
    public Optional<Aluno> findPorId(Long id) throws SQLException {
       Aluno aluno=AlunoRepository.findAlunoPorId(id)
                .orElseThrow(() -> new RuntimeException("O contato não foi encontrado!"));

        return Optional.ofNullable(aluno);
    }
    @Override
    public AlunoRespostaDTO atualizarAluno(Long id, AlunoRequisicaoDTO alunoRequisicaoDTO) throws SQLException {
            if(!alunoRepository.existsPorId(id)){
            throw new RuntimeException("Usuário não encontrado!");
        }

        Aluno aluno = alunoMapper.paraEntidade(alunoRequisicaoDTO);
        aluno.setId(id);
        aluno = alunoRepository.atualizarAluno(aluno);

        return alunoMapper.paraRespostaDto(aluno);
    }
    @Override
    public void deletePorId(Long id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletePorId'");
    }

    @Override
    public AlunoRespostaDTO buscarPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorId'");
    }

    @Override
    public List<Aluno> findAllAlunos() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllAlunos'");
    }
}
