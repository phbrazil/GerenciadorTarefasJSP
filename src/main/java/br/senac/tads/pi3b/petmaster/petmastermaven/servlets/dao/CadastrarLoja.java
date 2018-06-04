/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.dao;

import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Loja;
import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Cliente;
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
@WebServlet(name = "CadastrarCliente", urlPatterns = {"/CadastrarCliente"})

public class CadastrarLoja extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idloja = request.getParameter("idloja");
        String nomeLoja = request.getParameter("nomeloja");
        String logradouro = request.getParameter("logradouro");
        String pais = request.getParameter("pais");
        String cidade = request.getParameter("cidade");
        String bairro = request.getParameter("bairro");
        String uf = request.getParameter("uf");
        String cep = request.getParameter("cep").replace("-", "").replace(".", "");
        String telefone = request.getParameter("telefone");

        BancoLoja bancoLoja = new BancoLoja();

        int qtdclicadastrado = bancoLoja.ValidaCadastradoLoja(idloja);

        if (qtdclicadastrado == 0) {

            Loja loja = new Loja(idloja, nomeLoja, logradouro, cidade, bairro, cep, uf, pais);
            
            bancoLoja.gravarLoja(loja);
            request.setAttribute("nomeloja", nomeLoja);
            request.setAttribute("mensagem", "Loja cadastrada com sucesso!");

            request.getRequestDispatcher("CadastrarCliente.jsp").forward(request, response);

        } else {

            request.setAttribute("nomeloja", nomeLoja);
            request.setAttribute("mensagem", "falha");

            request.getRequestDispatcher("CadastrarCliente.jsp").forward(request, response);

        }

    }

}