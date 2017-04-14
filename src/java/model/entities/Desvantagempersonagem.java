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
@Table(name = "desvantagempersonagem")
@NamedQueries({
    @NamedQuery(name = "Desvantagempersonagem.findAll", query = "SELECT d FROM Desvantagempersonagem d")
    , @NamedQuery(name = "Desvantagempersonagem.findByDesvantagemPersonagemID", query = "SELECT d FROM Desvantagempersonagem d WHERE d.desvantagemPersonagemID = :desvantagemPersonagemID")})
public class Desvantagempersonagem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "desvantagemPersonagemID")
    private Integer desvantagemPersonagemID;
    @JoinColumn(name = "personagemID", referencedColumnName = "personagemID")
    @ManyToOne(optional = false)
    private Personagem personagem;
    @JoinColumn(name = "desvantagemID", referencedColumnName = "desvantagemID")
    @ManyToOne(optional = false)
    private Desvantagem desvantagem;

    public Desvantagempersonagem() {
    }

    public Desvantagempersonagem(Integer desvantagemPersonagemID) {
        this.desvantagemPersonagemID = desvantagemPersonagemID;
    }

    public Integer getDesvantagemPersonagemID() {
        return desvantagemPersonagemID;
    }

    public void setDesvantagemPersonagemID(Integer desvantagemPersonagemID) {
        this.desvantagemPersonagemID = desvantagemPersonagemID;
    }

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }

    public Desvantagem getDesvantagem() {
        return desvantagem;
    }

    public void setDesvantagem(Desvantagem desvantagem) {
        this.desvantagem = desvantagem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (desvantagemPersonagemID != null ? desvantagemPersonagemID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Desvantagempersonagem)) {
            return false;
        }
        Desvantagempersonagem other = (Desvantagempersonagem) object;
        if ((this.desvantagemPersonagemID == null && other.desvantagemPersonagemID != null) || (this.desvantagemPersonagemID != null && !this.desvantagemPersonagemID.equals(other.desvantagemPersonagemID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entities.Desvantagempersonagem[ desvantagemPersonagemID=" + desvantagemPersonagemID + " ]";
    }
    
}
