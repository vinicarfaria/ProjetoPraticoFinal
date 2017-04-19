/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.UsuarioDao;
import entities.Usuario;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Vinicius Faria
 */
@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean {

    /**
     * Creates a new instance of LoginBean
     */
    private UsuarioDao usuarioDAO = new UsuarioDao();
    private Usuario usuario = new Usuario();
    
    //private String usuario;
    private String senha;

    public String envia() {
        usuario = usuarioDAO.getUsuario(usuario.getLogin(), usuario.getSenha());
        if (usuario == null) {
            usuario = new Usuario();
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!",
                    "Erro no Login!"));
             return null;
        } else {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", this.usuario);
            return "/home";
        }
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    

    public String getSenha() {
        return senha;
    }
    
    public String cadastrar() {
        return "cadastrar";
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    public LoginBean() {
    }
    
}
