/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Usuario;
import java.util.List;
import javax.persistence.NoResultException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Vinicius Faria
 */
public class UsuarioDao {
   
    
    public Usuario getUsuario(String login, String senha) {
        try {
            Session session
                = HibernateUtil.getSessionFactory().openSession();
            Transaction t = session.beginTransaction();
            Query query = session.getNamedQuery("Usuario.findByLoginAndSenha").setParameter("login", login).setParameter("senha", senha) ;
                    //createQuery("SELECT u from Usuario u where u.login = "+login+" and u.senha = "+senha);
            Usuario usuario = (Usuario) query.uniqueResult();
            t.commit();
            return usuario;
        } catch (NoResultException e) {
             return null;
        }
    }
    
    public Usuario getlogin(String login) {
        try {
            Session session
                = HibernateUtil.getSessionFactory().openSession();
            Transaction t = session.beginTransaction();
            Query query = session.getNamedQuery("Usuario.findByLogin").setParameter("login", login);
                    //createQuery("SELECT u from Usuario u where u.login = "+login+" and u.senha = "+senha);
            Usuario usuario = (Usuario) query.uniqueResult();
            t.commit();
            return usuario;
        } catch (NoResultException e) {
             return null;
        }
    }
    
    public void cadastrar(Usuario usuario) {
        Session session
                = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(usuario);
        t.commit();
    }
    
    public void editar(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Query query = session.createQuery("from Usuario u ORDER BY u.nome ASC");
    }
    
    public List<Usuario> listar() {
        Session session
                = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Query query = session.createQuery("from Usuario u ORDER BY u.nome ASC");
        List<Usuario> listaUsuarios = query.list();
        t.commit();
        return listaUsuarios;
    }
    
    
    
}
