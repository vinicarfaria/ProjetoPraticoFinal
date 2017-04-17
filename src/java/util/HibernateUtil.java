/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Vinicius Faria
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();
    
    private static SessionFactory buildSessionFactory() {
        
        try {
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");
            StandardServiceRegistryBuilder registradorServico = new StandardServiceRegistryBuilder();
            registradorServico.applySettings(cfg.getProperties());
            StandardServiceRegistry servico = registradorServico.build();
            return cfg.buildSessionFactory(servico);
        } catch (Throwable e) {
            System.out.println("Falha na criacaoo do SessionFactory do Hibernate: "+e.getMessage());
            throw new ExceptionInInitializerError(e);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
