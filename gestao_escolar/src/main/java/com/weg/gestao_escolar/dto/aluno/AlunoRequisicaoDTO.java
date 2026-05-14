package com.weg.gestao_escolar.dto.aluno;

import java.time.LocalDate;
public record AlunoRequisicaoDTO(
    String nome,
    String email,
    String matricula,
    LocalDate data_nascimento
) {

}
