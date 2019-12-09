/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciarTarefas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private String url = "jdbc:mysql://localhost:3306/tarefas?useTimezone=true&serverTimezone=UTC";

    //private String driver = "com.mysql.jdbc.Driver";
    private String driver = "com.mysql.cj.jdbc.Driver";

    private Connection conexao = null;

    private String userName = "root";
    private String password = "admin";

    public Connection getConnection() throws SQLException {

        try {
            Class.forName(driver);
            if (conexao == null) {

                conexao = DriverManager.getConnection(url, userName, password);

            }
        } catch (Exception e) {
            System.out.print("Erro na conexao: " + e.getMessage());
        }
        return conexao;
    }
}
