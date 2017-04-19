/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
public class PersonagensDao {
    
    public void cadastrar(Personagem personagem) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(personagem);
        t.commit();
    }
    
    public void excluir(Personagem personagem) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(personagem);
        t.commit();
    }
    
    public List<Personagem> listar(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Query query = session.createQuery("SELECT p FROM Personagem p WHERE p.usuario.usuarioID = "+usuario.getUsuarioID());
        List<Personagem> listaPersonagens = query.list();
        t.commit();
        return listaPersonagens;
    }
}
