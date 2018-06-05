/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetorreforta.dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author jose
 * @param <T>
 * @param <S>
 */
public interface GenericDAO<T,S extends Serializable> {
    public List<T> getTots();
    public T getItemPerId(S clau);
    public void inserir(T valor);
    public void modificar(T valor);
    public void eliminar(T valor);
    
}
