/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.PersonagensDao;
import dao.UsuarioDao;
import entities.Personagem;
import entities.Usuario;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Vinicius Faria
 */
@ManagedBean
@SessionScoped
public class PersonagensBean {

    /**
     * Creates a new instance of PersonagensBean
     */
    private Personagem novoPersonagem; 
    private Personagem personagemSelecionado;
    private Usuario usuario ;
    
    public PersonagensBean() {
        
        novoPersonagem = new Personagem();
        usuario = new Usuario();
        usuario = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
    }
    
    public void cadastrarPersonagem() {
        PersonagensDao personagemDao = new PersonagensDao();
        novoPersonagem.setUsuario(usuario);
        personagemDao.cadastrar(novoPersonagem);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successo!",  "O personagem "+novoPersonagem.getNome()+" foi cadastrado.") );
        
    }
    
    public void excluirPersonagem(Personagem personagem) {
        personagemSelecionado = new Personagem();
        this.personagemSelecionado = personagem;
        PersonagensDao personagemDao = new PersonagensDao();
        personagemDao.excluir(personagemSelecionado);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successo!",  "O personagem foi excluído.") );
        
    }
    
    public List<Personagem> listaPersonagens() {
        PersonagensDao personagemDao = new PersonagensDao();
        return personagemDao.listar(usuario);
    }

    public Personagem getNovoPersonagem() {
        return novoPersonagem;
    }

    public void setNovoPersonagem(Personagem novoPersonagem) {
        this.novoPersonagem = novoPersonagem;
    }

    public Personagem getPersonagemSelecionado() {
        return personagemSelecionado;
    }

    public void setPersonagemSelecionado(Personagem personagemSelecionado) {
        this.personagemSelecionado = personagemSelecionado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
