package com.weg.gestao_escolar.mapper;

import org.springframework.stereotype.Component;
import com.weg.gestao_escolar.dto.aluno.AlunoRequisicaoDTO;
import com.weg.gestao_escolar.dto.aluno.AlunoRespostaDTO;
import com.weg.gestao_escolar.model.Aluno;

@Component
public class AlunoMapper {

    public Aluno paraEntidade(
            AlunoRequisicaoDTO requisicaoDto
    ){
        return new Aluno(
                requisicaoDto.nome(),
                requisicaoDto.email(),
                requisicaoDto.matricula(),
                requisicaoDto.data_nascimento()
        );
    }

    public AlunoRespostaDTO paraRespostaDto(
           Aluno aluno
    ){
        return new AlunoRespostaDTO(
            aluno.getId(),
            aluno.getNome(),
            aluno.getEmail(),
            aluno.getMatricula(),
            aluno.getData_nascimento()
        );

    }
}