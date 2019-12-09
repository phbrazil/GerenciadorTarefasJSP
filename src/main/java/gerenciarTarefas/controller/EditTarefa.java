/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciarTarefas.controller;

import gerenciarTarefas.dao.AddTarefaDAO;
import gerenciarTarefas.dao.EditTarefaDAO;
import gerenciarTarefas.model.tarefa;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "/editTarefa", urlPatterns = {"/editTarefa"})
public class EditTarefa extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        HttpSession sessao = request.getSession(true);

        int id = Integer.valueOf(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        String status = request.getParameter("status");
        String responsavel = request.getParameter("responsavel");
        String datainicio = request.getParameter("datainicio");
        String datafim = request.getParameter("datafim");
        int nota = Integer.valueOf(request.getParameter("nota"));
        
        tarefa tarefa = new tarefa(id,nome, descricao, status, responsavel, datainicio, datafim, nota);
        
        EditTarefaDAO edit = new EditTarefaDAO();
        
        edit.editTarefa(tarefa);
        
        sessao.setAttribute("result", "Tarefa atualizada");
        
        response.sendRedirect("ListarTarefas");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
