package com.weg.gestao_escolar.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL="jdbc:mysql://localhost:3356/gestao_escolar?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC\n";

    private static final String USER="root";

    private static final String PASSWORD="root";

    public static Connection getConexao() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
