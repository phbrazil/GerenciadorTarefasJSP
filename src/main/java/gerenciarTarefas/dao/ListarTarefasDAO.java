/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciarTarefas.dao;

import gerenciarTarefas.model.tarefa;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ListarTarefasDAO {

    private Connection conexao = null;

    public ArrayList<tarefa> Tarefas() {
        
        ArrayList<tarefa> lista = null;

        String selectgeral = "";

        Conexao bancoconexao = new Conexao();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            selectgeral = "select * from tarefas;";
            ResultSet resultgeral = st.executeQuery(selectgeral);
            
            while(resultgeral.next()){
                
                tarefa tarefa = new tarefa();
                
                tarefa.setId(resultgeral.getInt("id"));
                tarefa.setNome(resultgeral.getString("nome"));
                
                lista.add(tarefa);
                
            }


            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }
        return lista;
    }

}
