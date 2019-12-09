/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciarTarefas.controller;

import gerenciarTarefas.dao.ConcluirTarefaDAO;
import gerenciarTarefas.dao.IniciarTarefaDAO;
import gerenciarTarefas.dao.ListarTarefasDAO;
import gerenciarTarefas.model.tarefa;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "/concluirTarefa", urlPatterns = {"/concluirTarefa"})
public class ConcluirTarefa extends HttpServlet {

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
        int nota = Integer.valueOf(request.getParameter("nota"));

        ConcluirTarefaDAO concluir = new ConcluirTarefaDAO();

        concluir.concluirTarefa(id, nota);

        ListarTarefasDAO listar = new ListarTarefasDAO();

        ArrayList<tarefa> lista = listar.Tarefas();

        request.setAttribute("lista", lista);

        sessao.setAttribute("result", "Tarefa concluída");

        response.sendRedirect("ListarTarefas");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
