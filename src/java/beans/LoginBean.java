/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

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
    private String usuario;
    private String senha;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
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
