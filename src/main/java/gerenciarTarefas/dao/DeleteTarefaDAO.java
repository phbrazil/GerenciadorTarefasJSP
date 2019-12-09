/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciarTarefas.dao;

import gerenciarTarefas.model.tarefa;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteTarefaDAO {

    public void deleteTarefa(int id) {

        Conexao bancoconexao = new Conexao();

        try {

            Connection conexao = bancoconexao.getConnection();
            PreparedStatement preparedStmt = null;

            String query = ("delete from tarefa where id = ?");

            preparedStmt = conexao.prepareStatement(query);
            preparedStmt.setInt(1, id);

            preparedStmt.execute();

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro delete tarefa " + e.getMessage());

        }

    }
}
