/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.sprint2.dao;

import com.br.sprint2.entities.Pagamento;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 *
 * @author Paulo
 */
@Stateless
@LocalBean
public class PagamentoDAO implements GenericDAO<Pagamento>{

    @PersistenceContext(unitName = "sprint2jndi", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;
    
    @Override
    public void persist(Pagamento e) {
        em.persist(e);
    }

    @Override
    public List<Pagamento> read() {
        return em.createNamedQuery("Pagamento.findAll", Pagamento.class).getResultList();
    }

    @Override
    public void update(Pagamento e) {
        em.merge(e);
    }

    @Override
    public void remove(Pagamento e) {
        em.remove(e);
    }

    @Override
    public Pagamento findById(long id) {
        return em.find(Pagamento.class, id);
    }
    
    public Pagamento findByUsuario(String user){
        return em.find(Pagamento.class, user);
    }

    public Pagamento findByPreco(long preco){
        return em.find(Pagamento.class, preco);
    }
    
    public Pagamento findByData(String data){
        return em.find(Pagamento.class, data);
    }
    
}
