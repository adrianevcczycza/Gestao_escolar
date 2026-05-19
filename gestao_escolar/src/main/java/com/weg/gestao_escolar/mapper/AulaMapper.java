package com.weg.gestao_escolar.mapper;

import com.weg.gestao_escolar.dto.aluno.AlunoRespostaDTO;
import com.weg.gestao_escolar.dto.aula.AulaRequisicaoDTO;
import com.weg.gestao_escolar.model.Aluno;
import com.weg.gestao_escolar.model.Aula;

public class AulaMapper {

        public Aula paraEntidade(
            AulaRequisicaoDTO requisicaoDto
    ){
        return new Aula(
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
            aluno.getNome(),
            aluno.getEmail(),
            aluno.getMatricula(),
            aluno.getData_nascimento()
        );

    }

}
