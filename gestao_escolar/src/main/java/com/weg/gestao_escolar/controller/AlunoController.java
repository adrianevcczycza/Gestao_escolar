package com.weg.gestao_escolar.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weg.gestao_escolar.dto.aluno.AlunoRequisicaoDTO;
import com.weg.gestao_escolar.dto.aluno.AlunoRespostaDTO;
import com.weg.gestao_escolar.model.Aluno;
import com.weg.gestao_escolar.servece.Aluno.AlunoService;

@RestController
@RequestMapping("/alunoController")
public class AlunoController {
     private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService){
        this.alunoService= alunoService;
    }

    @PostMapping
    public AlunoRespostaDTO postContato(
            @RequestBody AlunoRequisicaoDTO requisicaoDto){
        try{
            AlunoRespostaDTO repostaDTO = alunoService.saveAluno( requisicaoDto);
            return repostaDTO;
        }catch (SQLException | RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping
    public List<Aluno> findAllAlunos(){
        try{
            List<Aluno> alunos = alunoService.findAllAlunos();
            return alunos;
        }catch (SQLException | RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }


    public Optional<Aluno> findPorId() {
        try{
            List<Aluno> alunos = alunoService.findAllAlunos();
            return Optional.empty();
        }catch (SQLException | RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }

    }

    @PutMapping("/{id}")
    public AlunoRespostaDTO atualizarAluno(@PathVariable Long id, @RequestBody AlunoRequisicaoDTO aluno){
        try{
            return alunoService.atualizarAluno(id, aluno);
        }catch(SQLException | RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }


    @DeleteMapping("/{id}")
    public void deletePorId(@PathVariable Long id){
        try{
            alunoService.deletePorId(id);
        } catch(SQLException | RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}

