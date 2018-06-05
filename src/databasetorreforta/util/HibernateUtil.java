/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetorreforta.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author Eva Gorbano Pinet
 */
public class HibernateUtil {
     private static final SessionFactory sessionFactory;

    static {
            StandardServiceRegistry registre = null;
            try {
                registre = new StandardServiceRegistryBuilder()
			.configure("databasetorreforta/hibernate.cfg.xml") // configures settings from hibernate.cfg.xml
			.build();
                sessionFactory = new MetadataSources(registre).buildMetadata().buildSessionFactory();
            } catch (HibernateException th) {
                // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
		// so destroy it manually.
		StandardServiceRegistryBuilder.destroy(registre);
                System.err.println("Initial SessionFactory creation failed" + th);
                throw new ExceptionInInitializerError(th);
            }
    }
    
    public static SessionFactory getSessionFactory() {
            return sessionFactory;
    }
}
