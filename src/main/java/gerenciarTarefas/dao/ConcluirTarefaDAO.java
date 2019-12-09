/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciarTarefas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ConcluirTarefaDAO {

    public void concluirTarefa(int id, int nota) {

        Conexao bancoconexao = new Conexao();

        try {

            Connection conexao = bancoconexao.getConnection();
            PreparedStatement preparedStmt = null;

            String query = ("update tarefa set status = 'Finalizada', nota = ? where id = ?");

            preparedStmt = conexao.prepareStatement(query);
            preparedStmt.setInt(1, nota);
            preparedStmt.setInt(2, id);

            preparedStmt.execute();

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro finalizar tarefa " + e.getMessage());

        }

    }
}
