/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.sprint2.command;

import com.br.sprint2.dao.PagamentoDAO;
import com.br.sprint2.entities.Pagamento;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Paulo
 */
public class PagamentoCommand implements Command {

    private String returnPage = "confirmacao.html";
    private HttpServletRequest request;
    private HttpServletResponse response;

    @Override
    public void init(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public void execute() {
        String user = request.getParameter("user");
        Double value = Double.parseDouble(request.getParameter("value"));
        String date = request.getParameter("date");
        
        
        Pagamento pagamento = new Pagamento(user, value, date);
        
        PagamentoDAO pDAO = new PagamentoDAO();
        
        pDAO.persist(pagamento);
        
        RequestDispatcher rd = request.getRequestDispatcher(returnPage);
        
        try {
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(PagamentoCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getReturnPage() {
        return this.returnPage;
    }

}
