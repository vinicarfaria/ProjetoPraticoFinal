/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Vinicius Faria
 */
@Entity
@Table(name = "classe")
@NamedQueries({
    @NamedQuery(name = "Classe.findAll", query = "SELECT c FROM Classe c")
    , @NamedQuery(name = "Classe.findByClasseID", query = "SELECT c FROM Classe c WHERE c.classeID = :classeID")
    , @NamedQuery(name = "Classe.findByNome", query = "SELECT c FROM Classe c WHERE c.nome = :nome")})
public class Classe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "classeID")
    private Integer classeID;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classe")
    private List<Personagem> personagemList;

    public Classe() {
    }

    public Classe(Integer classeID) {
        this.classeID = classeID;
    }

    public Classe(Integer classeID, String nome) {
        this.classeID = classeID;
        this.nome = nome;
    }

    public Integer getClasseID() {
        return classeID;
    }

    public void setClasseID(Integer classeID) {
        this.classeID = classeID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Personagem> getPersonagemList() {
        return personagemList;
    }

    public void setPersonagemList(List<Personagem> personagemList) {
        this.personagemList = personagemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (classeID != null ? classeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Classe)) {
            return false;
        }
        Classe other = (Classe) object;
        if ((this.classeID == null && other.classeID != null) || (this.classeID != null && !this.classeID.equals(other.classeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Classe[ classeID=" + classeID + " ]";
    }
    
}
