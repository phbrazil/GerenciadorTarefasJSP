/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciarTarefas.controller;

import gerenciarTarefas.dao.DeleteTarefaDAO;
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

@WebServlet(name = "/iniciarTarefa", urlPatterns = {"/iniciarTarefa"})
public class IniciarTarefa extends HttpServlet {

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

        IniciarTarefaDAO iniciar = new IniciarTarefaDAO();

        iniciar.iniciarTarefa(id);

        ListarTarefasDAO listar = new ListarTarefasDAO();

        ArrayList<tarefa> lista = listar.Tarefas();

        request.setAttribute("lista", lista);

        sessao.setAttribute("result", "Tarefa iniciada");

        response.sendRedirect("ListarTarefas");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
