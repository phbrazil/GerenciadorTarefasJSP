/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciarTarefas.controller;

import gerenciarTarefas.dao.ListarTarefasDAO;
import gerenciarTarefas.model.tarefa;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "/ListarTarefas", urlPatterns = {"/ListarTarefas"})
public class ListarTarefas extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");

        ListarTarefasDAO listar = new ListarTarefasDAO();

        ArrayList<tarefa> lista = listar.Tarefas();
        
        request.setAttribute("lista", lista);

        request.getRequestDispatcher("ListarTarefas.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
