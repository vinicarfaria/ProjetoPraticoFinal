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
@Table(name = "magiapersonagem")
@NamedQueries({
    @NamedQuery(name = "Magiapersonagem.findAll", query = "SELECT m FROM Magiapersonagem m")
    , @NamedQuery(name = "Magiapersonagem.findByMagiaPersonagemID", query = "SELECT m FROM Magiapersonagem m WHERE m.magiaPersonagemID = :magiaPersonagemID")})
public class Magiapersonagem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "magiaPersonagemID")
    private Integer magiaPersonagemID;
    @JoinColumn(name = "personagemID", referencedColumnName = "personagemID")
    @ManyToOne(optional = false)
    private Personagem personagem;
    @JoinColumn(name = "magiaID", referencedColumnName = "magiaID")
    @ManyToOne(optional = false)
    private Magia magia;

    public Magiapersonagem() {
    }

    public Magiapersonagem(Integer magiaPersonagemID) {
        this.magiaPersonagemID = magiaPersonagemID;
    }

    public Integer getMagiaPersonagemID() {
        return magiaPersonagemID;
    }

    public void setMagiaPersonagemID(Integer magiaPersonagemID) {
        this.magiaPersonagemID = magiaPersonagemID;
    }

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }

    public Magia getMagia() {
        return magia;
    }

    public void setMagia(Magia magia) {
        this.magia = magia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (magiaPersonagemID != null ? magiaPersonagemID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Magiapersonagem)) {
            return false;
        }
        Magiapersonagem other = (Magiapersonagem) object;
        if ((this.magiaPersonagemID == null && other.magiaPersonagemID != null) || (this.magiaPersonagemID != null && !this.magiaPersonagemID.equals(other.magiaPersonagemID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entities.Magiapersonagem[ magiaPersonagemID=" + magiaPersonagemID + " ]";
    }
    
}
