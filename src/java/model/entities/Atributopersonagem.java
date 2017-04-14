/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

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
@Table(name = "atributopersonagem")
@NamedQueries({
    @NamedQuery(name = "Atributopersonagem.findAll", query = "SELECT a FROM Atributopersonagem a")
    , @NamedQuery(name = "Atributopersonagem.findByAtributoPersonagemID", query = "SELECT a FROM Atributopersonagem a WHERE a.atributoPersonagemID = :atributoPersonagemID")})
public class Atributopersonagem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "atributoPersonagemID")
    private Integer atributoPersonagemID;
    @JoinColumn(name = "personagemID", referencedColumnName = "personagemID")
    @ManyToOne(optional = false)
    private Personagem personagem;
    @JoinColumn(name = "atributoID", referencedColumnName = "atributoID")
    @ManyToOne(optional = false)
    private Atributo atributo;

    public Atributopersonagem() {
    }

    public Atributopersonagem(Integer atributoPersonagemID) {
        this.atributoPersonagemID = atributoPersonagemID;
    }

    public Integer getAtributoPersonagemID() {
        return atributoPersonagemID;
    }

    public void setAtributoPersonagemID(Integer atributoPersonagemID) {
        this.atributoPersonagemID = atributoPersonagemID;
    }

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }

    public Atributo getAtributo() {
        return atributo;
    }

    public void setAtributo(Atributo atributo) {
        this.atributo = atributo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (atributoPersonagemID != null ? atributoPersonagemID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Atributopersonagem)) {
            return false;
        }
        Atributopersonagem other = (Atributopersonagem) object;
        if ((this.atributoPersonagemID == null && other.atributoPersonagemID != null) || (this.atributoPersonagemID != null && !this.atributoPersonagemID.equals(other.atributoPersonagemID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entities.Atributopersonagem[ atributoPersonagemID=" + atributoPersonagemID + " ]";
    }
    
}
