package com.weg.gestao_escolar.dto.aula;

import java.time.LocalDate;

public record AulaRespostaDTO(
    Long id,
    String nome,
    String email,
    Long matricula,
    LocalDate data_nascimento
) {

}
