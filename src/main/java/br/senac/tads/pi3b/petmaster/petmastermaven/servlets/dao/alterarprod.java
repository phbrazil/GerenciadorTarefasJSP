/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.dao;

import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Produtos;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Paulo.Bezerra
 */
@WebServlet(name = "alterarprod", urlPatterns = {"/alterarprod"})

public class alterarprod extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean deletado = false;
        bancoprod bancoprod = new bancoprod();

        String alterar = String.valueOf(request.getParameter("alterar"));
        String excluir = String.valueOf(request.getParameter("excluir"));

        if (alterar.equals("alterar")) {

            String nomeprod = request.getParameter("nomeprod");
            String codigobarrasprod = request.getParameter("codigoprod");
            String descricaoprod = request.getParameter("descricaoprod");
            String categoriaprod = request.getParameter("categoriaprod");
            double valorprod = Double.parseDouble(request.getParameter("valorprod"));
            int qtdestoque = Integer.valueOf(request.getParameter("qtdestoque"));
            Produtos produtos = new Produtos(null, 0, null, null, 0, null);

            produtos = new Produtos(nomeprod, valorprod, codigobarrasprod, descricaoprod, qtdestoque, categoriaprod);

            bancoprod.atualizarprod(produtos);

            request.getRequestDispatcher("cadastradosuccess.jsp").forward(request, response);

        } else if (excluir.equals("excluir")) {

            deletado = bancoprod.deletaprod(String.valueOf(request.getParameter("codigoprod")));

            if (deletado == true) {
                request.getRequestDispatcher("deletado.jsp").forward(request, response);

            }else{
                
                System.out.println("fudeu na hora de deletar");
            }

        }

    }

}
