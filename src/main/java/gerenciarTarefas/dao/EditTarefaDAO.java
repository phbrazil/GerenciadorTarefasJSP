/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciarTarefas.dao;

import gerenciarTarefas.model.tarefa;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class EditTarefaDAO {

    public void editTarefa(tarefa tarefa) {

        Conexao bancoconexao = new Conexao();

        try {

            Connection conexao = bancoconexao.getConnection();
            PreparedStatement preparedStmt = null;

            String query = ("update tarefa set nome = ?, descricao = ?,"
                    + "responsavel=?, datainicio=?, datafim=? where id = ?");

            preparedStmt = conexao.prepareStatement(query);
            preparedStmt.setString(1, tarefa.getNome());
            preparedStmt.setString(2, tarefa.getDescricao());
            preparedStmt.setString(3, tarefa.getResponsavel());
            preparedStmt.setString(4, tarefa.getDatainicio());
            preparedStmt.setString(5, tarefa.getDatafim());
            preparedStmt.setInt(6, tarefa.getId());

            preparedStmt.execute();

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro edit tarefa " + e.getMessage());

        }

    }
}
