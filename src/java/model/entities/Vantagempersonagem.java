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
@Table(name = "vantagempersonagem")
@NamedQueries({
    @NamedQuery(name = "Vantagempersonagem.findAll", query = "SELECT v FROM Vantagempersonagem v")
    , @NamedQuery(name = "Vantagempersonagem.findByVantagemPersonagemID", query = "SELECT v FROM Vantagempersonagem v WHERE v.vantagemPersonagemID = :vantagemPersonagemID")})
public class Vantagempersonagem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vantagemPersonagemID")
    private Integer vantagemPersonagemID;
    @JoinColumn(name = "personagemID", referencedColumnName = "personagemID")
    @ManyToOne(optional = false)
    private Personagem personagem;
    @JoinColumn(name = "vantagemID", referencedColumnName = "vantagemID")
    @ManyToOne(optional = false)
    private Vantagem vantagem;

    public Vantagempersonagem() {
    }

    public Vantagempersonagem(Integer vantagemPersonagemID) {
        this.vantagemPersonagemID = vantagemPersonagemID;
    }

    public Integer getVantagemPersonagemID() {
        return vantagemPersonagemID;
    }

    public void setVantagemPersonagemID(Integer vantagemPersonagemID) {
        this.vantagemPersonagemID = vantagemPersonagemID;
    }

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }

    public Vantagem getVantagem() {
        return vantagem;
    }

    public void setVantagem(Vantagem vantagem) {
        this.vantagem = vantagem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vantagemPersonagemID != null ? vantagemPersonagemID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vantagempersonagem)) {
            return false;
        }
        Vantagempersonagem other = (Vantagempersonagem) object;
        if ((this.vantagemPersonagemID == null && other.vantagemPersonagemID != null) || (this.vantagemPersonagemID != null && !this.vantagemPersonagemID.equals(other.vantagemPersonagemID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entities.Vantagempersonagem[ vantagemPersonagemID=" + vantagemPersonagemID + " ]";
    }
    
}
