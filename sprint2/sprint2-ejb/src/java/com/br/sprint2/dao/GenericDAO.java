/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.sprint2.dao;

import java.util.List;

/**
 *
 * @author Paulo
 */
public interface GenericDAO<E> {
    public void persist (E e);
    public List<E> read();
    public void update (E e);
    public void remove (E e);
    public E findById (long id);
}