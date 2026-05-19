package com.weg.gestao_escolar.repository.Professor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.weg.gestao_escolar.Connection.Conexao;
import com.weg.gestao_escolar.model.Professor;

@Repository
public class ProfessorRepositoryImpl implements ProfessorRepository{

    @Override
    public Professor saveProfessor(Professor  professor) throws SQLException {
                String command = """
                INSERT INTO professor
                ( nome, email, id, diciplina)
                VALUES
                (?,?,?,?)
                """;

        try(Connection conn = Conexao.getConexao();
            PreparedStatement stmt = conn.prepareStatement(command,Statement.RETURN_GENERATED_KEYS)){
                
            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getEmail());
            stmt.setLong(3, professor.getId());
            stmt.setString(4, professor.getDiciplina());

            ResultSet rs = stmt.getGeneratedKeys();

            if(rs.next()){
                Long id = rs.getLong(1);
                professor.setId(id);
                return professor;
            }
        }

        throw new RuntimeException("Erro ao salvar professor!");
    }

    @Override
    public List<Professor> findAllProfessor() throws SQLException {
            List<Professor> professores = new ArrayList<>();
        String query = """
                    SELECT id
                          ,nome
                          ,email
                          ,diciplina
                    FROM professor
                """;
        try(Connection conn = Conexao.getConexao();
            PreparedStatement stmt = conn.prepareStatement(query)){

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                Long id = rs.getLong("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String diciplina=rs.getString("diciplina");

                professores.add(new Professor(
                   id,
                   nome,
                   email,
                   diciplina
                ));
            }
             
        } return professores;
    }

    @Override
    public Optional<Professor> findPorId(Long id) throws SQLException {
        List<Professor> professores = new ArrayList<>();
               String query = """
                    SELECT nome
                          ,email
                          ,diciplina
                    FROM professor
                    WHERE id = ?
                """;
        try(Connection conn = Conexao.getConexao();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String diciplina=rs.getString("diciplina");

                professores.add(new Professor(
                   id,
                   nome,
                   email,
                   diciplina
                ));
            }
        }
        return Optional.empty();
    }

    @Override
    public void atualizarProfessor(Professor professor) throws SQLException {
            String command = """
                UPDATE professor
                SET nome =? ,
                email =?, 
                id=?, 
                diciplina =?
                WHERE  id 
                """;
        try(Connection conn = Conexao.getConexao();
            PreparedStatement stmt = conn.prepareStatement(command)){

            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getEmail());
            stmt.setLong(3,professor.getId());
            stmt.setString(4, professor.getDiciplina());

            stmt.executeUpdate();
        }
    }
    @Override
    public void deletePorId(Long id) throws SQLException {
        String command = """
                DELETE FROM professor
                WHERE id = ?
                """;

        try(Connection conn =Conexao.getConexao();
            PreparedStatement stmt = conn.prepareStatement(command)){

            stmt.setLong(1,id);
            stmt.execute();
        }
        return;
    }

}
