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
@WebServlet(name = "cadastrarprod", urlPatterns = {"/cadastrarprod"})

public class cadastrarprod extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nomeprod = request.getParameter("nomeprod");
        String codigoprod = request.getParameter("codigoprod");
        String descricaoprod = request.getParameter("descricaoprod");
        String categoriaprod = request.getParameter("categoriaprod");
        String valorprod = request.getParameter("valorprod");
        int qtdestoque = Integer.valueOf(request.getParameter("qtdestoque"));

        Produtos produtos = new Produtos(codigoprod, Double.valueOf(valorprod), nomeprod, descricaoprod, qtdestoque, categoriaprod);
        
        gravarprod gravarprod = new gravarprod();

        gravarprod.gravarproduto(produtos);
        
        System.out.println(produtos.getNomeprod()+" suadhusahduahu");

    }



}
