/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Classe;
import entities.Personagem;
import entities.Usuario;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Vinicius Faria
 */
public class ClasseDao {
    
    public List<Classe> listar() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Query query = session.createQuery("from Classe c ORDER BY c.classeID ASC");
        List<Classe> listaClasses = query.list();
        t.commit();
        return listaClasses;
    }
}
