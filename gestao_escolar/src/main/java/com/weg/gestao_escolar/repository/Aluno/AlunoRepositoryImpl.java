package com.weg.gestao_escolar.repository.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.weg.gestao_escolar.Connection.Conexao;
import com.weg.gestao_escolar.dto.aluno.AlunoRequisicaoDTO;
import com.weg.gestao_escolar.model.Aluno;

@Repository
public class AlunoRepositoryImpl implements AlunoRepository{

    @Override
    public Aluno saveAluno(Aluno aluno) throws SQLException {
                String command = """
                INSERT INTO aluno
                (nome, email, matricula, data_nascimento)
                VALUES
                (?,?,?,?)
                """;

        try(Connection conn = Conexao.getConexao();
            PreparedStatement stmt = conn.prepareStatement(command,Statement.RETURN_GENERATED_KEYS)){
                
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());
            stmt.setString(3, aluno.getMatricula());
            stmt.setDate(4, java.sql.Date.valueOf(aluno.getData_nascimento()));

            ResultSet rs = stmt.getGeneratedKeys();

            if(rs.next()){
                Long id = rs.getLong(1);
                aluno.setId(id);
                return aluno;
            }
        }

        throw new RuntimeException("Erro ao salvar aluno!");
    }

    @Override
    public List<Aluno> findAllAlunos() throws SQLException {
        List<Aluno> alunos = new ArrayList<>();
        String query = """
                    SELECT id
                          ,nome
                          ,email
                          ,matricula
                          ,data_nascimento
                    FROM aluno
                """;
        try(Connection conn = Conexao.getConexao();
            PreparedStatement stmt = conn.prepareStatement(query)){

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                Long id = rs.getLong("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String matricula =rs.getString("matricula");
                LocalDate data_nascimento=rs.getDate("data_nascimento").toLocalDate();

                alunos.add(new Aluno(
                   id,
                   nome,
                   email,
                   matricula,
                   data_nascimento
                ));
            }
        }

        return alunos;
    }

    public Optional<Aluno> findAlunoPorId(Long id) throws SQLException {
        String query = """
                    SELECT nome
                          ,email
                          ,matricula
                          ,data-nascimento
                    FROM contato
                    WHERE id = ?
                """;
        try(Connection conn = Conexao.getConexao();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setLong(1,id);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                String nome = rs.getString("nome");
                String email= rs.getString("email");
                String matricula=rs.getString("matricula");
                LocalDate data_nascimento=rs.getDate("data_nascimento").toLocalDate();
                
               
                return Optional.of(
                        new Aluno(id
                                ,nome
                                ,email
                                ,matricula
                                ,data_nascimento
                            ));
            }
        }

        return Optional.empty();
    }

    @Override
    public void deletePorId(Long id) throws SQLException {
        String command = """
                DELETE FROM contato
                WHERE id = ?
                """;

        try(Connection conn =Conexao.getConexao();
            PreparedStatement stmt = conn.prepareStatement(command)){

            stmt.setLong(1,id);
            stmt.execute();
        }
        return ;
    }

    @Override
    public Aluno atualizarAluno(Aluno aluno) throws SQLException {
                String command = """
                UPDATE aluno
                SET nome =? ,
                email =?,
                matricula =?, 
                data_nascimento = ?
                WHERE  id = ?
                """;
        try(Connection conn = Conexao.getConexao();
            PreparedStatement stmt = conn.prepareStatement(command)){

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());
            stmt.setString(3, aluno.getMatricula());
            stmt.setDate(4, java.sql.Date.valueOf(aluno.getData_nascimento()));

            stmt.executeUpdate();
        }
        return aluno;
    }

    @Override
    public boolean existsPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsPorId'");
    }

    @Override
    public void atualizarAluno() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizarAluno'");
    }
}
        