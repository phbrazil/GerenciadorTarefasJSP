/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciarTarefas.dao;

import gerenciarTarefas.model.tarefa;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddTarefaDAO {

    public void gravarTarefa(tarefa tarefa) {

        Conexao bancoconexao = new Conexao();

        try {

            Connection conexao = bancoconexao.getConnection();
            PreparedStatement preparedStmt = null;

            String query = ("INSERT INTO tarefa (nome, descricao,"
                    + "status, responsavel, datainicio, datafim, nota) "
                    + "VALUES (?,?,?,?,?,?,?)");

            preparedStmt = conexao.prepareStatement(query);
            preparedStmt.setString(1, tarefa.getNome());
            preparedStmt.setString(2, tarefa.getDescricao());
            preparedStmt.setString(3, tarefa.getStatus());
            preparedStmt.setString(4, tarefa.getResponsavel());
            preparedStmt.setString(5, tarefa.getDatainicio());
            preparedStmt.setString(6, tarefa.getDatafim());
            preparedStmt.setInt(7, tarefa.getNota());

            preparedStmt.execute();

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro add tarefa " + e.getMessage());

        }

    }
}
