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
@Table(name = "raca")
@NamedQueries({
    @NamedQuery(name = "Raca.findAll", query = "SELECT r FROM Raca r")
    , @NamedQuery(name = "Raca.findByRacaID", query = "SELECT r FROM Raca r WHERE r.racaID = :racaID")
    , @NamedQuery(name = "Raca.findByNome", query = "SELECT r FROM Raca r WHERE r.nome = :nome")})
public class Raca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "racaID")
    private Integer racaID;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "raca")
    private List<Personagem> personagemList;

    public Raca() {
    }

    public Raca(Integer racaID) {
        this.racaID = racaID;
    }

    public Raca(Integer racaID, String nome) {
        this.racaID = racaID;
        this.nome = nome;
    }

    public Integer getRacaID() {
        return racaID;
    }

    public void setRacaID(Integer racaID) {
        this.racaID = racaID;
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
        hash += (racaID != null ? racaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Raca)) {
            return false;
        }
        Raca other = (Raca) object;
        if ((this.racaID == null && other.racaID != null) || (this.racaID != null && !this.racaID.equals(other.racaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Raca[ racaID=" + racaID + " ]";
    }
    
}
