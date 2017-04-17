/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.entities.Usuario;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Vinicius Faria
 */
public class UsuarioDao {
    
    public void cadastrar(Usuario usuario) {
        Session session
                = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(usuario);
        t.commit();
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
