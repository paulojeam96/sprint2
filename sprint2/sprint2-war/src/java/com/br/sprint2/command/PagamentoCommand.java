/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.sprint2.command;

import com.br.sprint2.dao.PagamentoDAO;
import com.br.sprint2.entities.Pagamento;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Paulo
 */
public class PagamentoCommand implements Command {

    PagamentoDAO pagamentoDAO = lookupPagamentoDAOBean();
    
    

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
        
        pagamentoDAO = new PagamentoDAO();
        
        pagamentoDAO.persist(pagamento);
        
        List<Pagamento> confirmacao = pagamentoDAO.read();
        
        request.getSession().setAttribute("confimacao", confirmacao);
        
        returnPage = "confirmacao.jsp";
    }

    @Override
    public String getReturnPage() {
        return this.returnPage;
    }

    private PagamentoDAO lookupPagamentoDAOBean() {
        try {
            Context c = new InitialContext();
            return (PagamentoDAO) c.lookup("java:global/sprint2/sprint2-ejb/PagamentoDAO!com.br.sprint2.dao.PagamentoDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
