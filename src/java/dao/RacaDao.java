/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Raca;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Vinicius Faria
 */
public class RacaDao {
    public List<Raca> listar() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Query query = session.createQuery("from Raca c ORDER BY c.racaID ASC");
        List<Raca> listaRacas = query.list();
        t.commit();
        return listaRacas;
    }
}
