/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.UsuarioDao;
import java.util.List;
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
    
    public List<Usuario> listaUsuarios() {
        //List<SelectItem> listaSelectItems;
        //SelectItem selItem = new SelectItem("value", "label");
        UsuarioDao usuarioDao = new UsuarioDao();
        return usuarioDao.listar();
    }

    public Usuario getNovoUsuario() {
        return novoUsuario;
    }

    public void setNovoUsuario(Usuario novoUsuario) {
        this.novoUsuario = novoUsuario;
    }
    
    
}
