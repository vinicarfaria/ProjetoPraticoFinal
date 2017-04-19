/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.ClasseDao;
import entities.Classe;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Vinicius Faria
 */
@ManagedBean
@SessionScoped
public class ClasseBean {

    /**
     * Creates a new instance of ClasseBean
     */
    public ClasseBean() {
    }
    
    public List<Classe> listaClasses() {
        ClasseDao classeDao = new ClasseDao();
        return classeDao.listar();
    }
    
}
