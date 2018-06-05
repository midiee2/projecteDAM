/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetorreforta.dao;

import databasetorreforta.util.HibernateUtil;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author jose
 * @param <T>
 * @param <S>
 */
public class GenericDAOImpl<T,S extends Serializable> implements GenericDAO<T,S> {
    
    private final Class<T> classe = getDomainClass();
    
    protected Class getDomainClass() {
        Class domainClass = classe;
        if (classe == null) {
            ParameterizedType thisType = (ParameterizedType) getClass().getGenericSuperclass();
            domainClass = (Class) thisType.getActualTypeArguments()[0];
        }
       return domainClass;
    }
    
    @Override
    public List<T> getTots() {
        List<T> tots = null;
        Session sesio = HibernateUtil.getSessionFactory().openSession();
        try {
            sesio.beginTransaction();
            Criteria criteria = sesio.createCriteria(classe);
            tots = criteria.list();
            sesio.getTransaction().commit();
        } catch (HibernateException ex) {
            System.out.println("Error en la consulta");
        }
        sesio.close();
        return tots;        

    }

    @Override
    public T getItemPerId(S clau) {
        T item = null;
        Session sesio = HibernateUtil.getSessionFactory().openSession();
        try {
            sesio.beginTransaction();
            item = (T) sesio.get(classe, clau);
            sesio.getTransaction().commit();
        } catch (HibernateException ex) {
            System.out.println("Error en la consulta");
        }
        sesio.close();
        return item;        
    }

    @Override
    public void inserir(T valor) {
        Session sesio = HibernateUtil.getSessionFactory().openSession();
        try {
            sesio.beginTransaction();
            sesio.save(valor);
            sesio.getTransaction().commit();
        } catch (HibernateException ex) {
            System.out.println("Error en la inserció");
            sesio.getTransaction().rollback();
        }        
        sesio.close();
    }

    @Override
    public void modificar(T valor) {
        Session sesio = HibernateUtil.getSessionFactory().openSession();
        try {
            sesio.beginTransaction();
            sesio.update(valor);
            sesio.getTransaction().commit();
        } catch (HibernateException ex) {
            System.out.println("Error en la actualització");
            sesio.getTransaction().rollback();
        }        
        sesio.close();
    }

    @Override
    public void eliminar(T valor) {
        Session sesio = HibernateUtil.getSessionFactory().openSession();
        try {
            sesio.beginTransaction();
            sesio.delete(valor);
            sesio.getTransaction().commit();
        } catch (HibernateException ex) {
            System.out.println("Error en la eliminació");
            sesio.getTransaction().rollback();
        }        
        sesio.close();
    }
    
}
