/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.dao;

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
@WebServlet(name = "AlterarCli", urlPatterns = {"/AlterarCli"})

public class AlterarLoja extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean deletado = false;
        BancoCli bancocli = new BancoCli();

        String acaocliente = String.valueOf(request.getParameter("AcaoCliente"));

        if (acaocliente.equals("alterar")) {

            String nomeCliente = request.getParameter("nomecliente");
            String logradouro = request.getParameter("logradouro");
            String RGCliente = request.getParameter("rgcliente");
            String CPFCliente = request.getParameter("cpfcliente");
            String email = request.getParameter("email");
            String pais = request.getParameter("pais");
            String cidade = request.getParameter("cidade");
            String bairro = request.getParameter("bairro");
            String uf = request.getParameter("uf");
            String estado = request.getParameter("estado");
            String cep = request.getParameter("cep").replace("-", "").replace(".", "");
            String telefone = request.getParameter("telefone");
            String celular = request.getParameter("celular");
            String sexo = request.getParameter("sexo");
            String estadocivil = request.getParameter("estadocivil");
            String nascimento = request.getParameter("nascimento");

            Cliente clientes = new Cliente(CPFCliente, nascimento, nomeCliente, logradouro, bairro, cidade, cep, estado, uf, email, sexo, telefone, celular, pais, RGCliente, estadocivil);
            bancocli.atualizarCli(clientes);

            request.setAttribute("mensagem", "Cliente Alterado");

            request.getRequestDispatcher("ConsultaCli.jsp").forward(request, response);

        } else if (acaocliente.equals("excluir")) {

            deletado = bancocli.deletaCliente(String.valueOf(request.getParameter("cpfcliente")));

            if (deletado == true) {
                request.setAttribute("mensagem", "Cliente Deletado");

                request.getRequestDispatcher("ConsultaCli.jsp").forward(request, response);

            } else {

                System.out.println("falhou na hora de deletar");
            }

        }

    }

}
