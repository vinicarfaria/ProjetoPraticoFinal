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
import entities.Usuario;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Vinicius Faria
 */
@ManagedBean
@SessionScoped
public class UsuarioBean {

    private Usuario usuario = new Usuario();
    private Usuario novoUsuario;
    private Usuario usuarioLogado;
    
    public UsuarioBean() {
        novoUsuario = new Usuario();
        usuarioLogado = new Usuario();
        usuarioLogado = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
    }
    
    public String sair(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        usuarioLogado = null;
        return "index";
    }
    
    public void editarUsuario() {
        UsuarioDao alunoDao = new UsuarioDao();
        alunoDao.editar(usuarioLogado);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().replace("usuario", this.usuarioLogado);//put("usuario", this.usuario);
        FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Successo!",  "Alterações salvas.") );
    }
    
    public void cadastrarUsuario() {
            UsuarioDao usuarioDao = new UsuarioDao();
            usuario = usuarioDao.getlogin(novoUsuario.getLogin());
        if(usuario == null){
            usuarioDao.cadastrar(novoUsuario);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Successo!",  "O usuário "+novoUsuario.getLogin()+" foi cadastrado. "
                    + "Agora você pode voltar para tela de login ou cadastrar mais usuários.") );
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Atenção!",  "O nome de usuário "+novoUsuario.getLogin()+" já foi usado! "
                    + "Por favor, escolha outro nome de usuário!") );
        }
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

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }
    
    
    
    
}
