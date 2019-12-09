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
        
        ArrayList<tarefa> lista = new ArrayList<>();

        String selectgeral = "";

        Conexao bancoconexao = new Conexao();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            selectgeral = "select * from tarefa;";
            ResultSet resultgeral = st.executeQuery(selectgeral);
            
            while(resultgeral.next()){
                                
                tarefa tarefa = new tarefa();
                
                tarefa.setId(resultgeral.getInt("id"));
                tarefa.setNome(resultgeral.getString("nome"));
                tarefa.setDescricao(resultgeral.getString("descricao"));
                tarefa.setStatus(resultgeral.getString("status"));
                tarefa.setResponsavel(resultgeral.getString("responsavel"));
                tarefa.setDatainicio(resultgeral.getString("datainicio"));
                tarefa.setDatafim(resultgeral.getString("datafim"));
                tarefa.setNota(resultgeral.getInt("nota"));
                
                lista.add(tarefa);
                
            }


            conexao.close();

        } catch (Exception e) {

            System.out.println("erro " + e.getMessage());

        }
        return lista;
    }

}
