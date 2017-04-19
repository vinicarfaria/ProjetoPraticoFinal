/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Vinicius Faria
 */
@Entity
@Table(name = "usuariopersonagem")
@NamedQueries({
    @NamedQuery(name = "Usuariopersonagem.findAll", query = "SELECT u FROM Usuariopersonagem u")
    , @NamedQuery(name = "Usuariopersonagem.findByUsuarioPersonagemID", query = "SELECT u FROM Usuariopersonagem u WHERE u.usuarioPersonagemID = :usuarioPersonagemID")})
public class Usuariopersonagem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usuarioPersonagemID")
    private Integer usuarioPersonagemID;
    @JoinColumn(name = "usuarioID", referencedColumnName = "usuarioID")
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "personagemID", referencedColumnName = "personagemID")
    @ManyToOne(optional = false)
    private Personagem personagem;

    public Usuariopersonagem() {
    }

    public Usuariopersonagem(Integer usuarioPersonagemID) {
        this.usuarioPersonagemID = usuarioPersonagemID;
    }

    public Integer getUsuarioPersonagemID() {
        return usuarioPersonagemID;
    }

    public void setUsuarioPersonagemID(Integer usuarioPersonagemID) {
        this.usuarioPersonagemID = usuarioPersonagemID;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioPersonagemID != null ? usuarioPersonagemID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuariopersonagem)) {
            return false;
        }
        Usuariopersonagem other = (Usuariopersonagem) object;
        if ((this.usuarioPersonagemID == null && other.usuarioPersonagemID != null) || (this.usuarioPersonagemID != null && !this.usuarioPersonagemID.equals(other.usuarioPersonagemID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Usuariopersonagem[ usuarioPersonagemID=" + usuarioPersonagemID + " ]";
    }
    
}
