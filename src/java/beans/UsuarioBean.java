/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.UsuarioDao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.entities.Usuario;

/**
 *
 * @author Vinicius Faria
 */
@ManagedBean
@SessionScoped
public class UsuarioBean {

    private Usuario novoUsuario;
    
    public UsuarioBean() {
        novoUsuario = new Usuario();
    }
    
    public void cadastrarUsuario() {
        UsuarioDao usuarioDao = new UsuarioDao();
        usuarioDao.cadastrar(novoUsuario);
    }

    public Usuario getNovoUsuario() {
        return novoUsuario;
    }

    public void setNovoUsuario(Usuario novoUsuario) {
        this.novoUsuario = novoUsuario;
    }
    
    
}
