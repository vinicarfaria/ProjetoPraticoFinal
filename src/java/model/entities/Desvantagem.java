/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Vinicius Faria
 */
@Entity
@Table(name = "desvantagem")
@NamedQueries({
    @NamedQuery(name = "Desvantagem.findAll", query = "SELECT d FROM Desvantagem d")
    , @NamedQuery(name = "Desvantagem.findByDesvantagemID", query = "SELECT d FROM Desvantagem d WHERE d.desvantagemID = :desvantagemID")
    , @NamedQuery(name = "Desvantagem.findByNome", query = "SELECT d FROM Desvantagem d WHERE d.nome = :nome")})
public class Desvantagem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "desvantagemID")
    private Integer desvantagemID;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Lob
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "desvantagem")
    private List<Desvantagempersonagem> desvantagempersonagemList;

    public Desvantagem() {
    }

    public Desvantagem(Integer desvantagemID) {
        this.desvantagemID = desvantagemID;
    }

    public Desvantagem(Integer desvantagemID, String nome, String descricao) {
        this.desvantagemID = desvantagemID;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Integer getDesvantagemID() {
        return desvantagemID;
    }

    public void setDesvantagemID(Integer desvantagemID) {
        this.desvantagemID = desvantagemID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Desvantagempersonagem> getDesvantagempersonagemList() {
        return desvantagempersonagemList;
    }

    public void setDesvantagempersonagemList(List<Desvantagempersonagem> desvantagempersonagemList) {
        this.desvantagempersonagemList = desvantagempersonagemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (desvantagemID != null ? desvantagemID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Desvantagem)) {
            return false;
        }
        Desvantagem other = (Desvantagem) object;
        if ((this.desvantagemID == null && other.desvantagemID != null) || (this.desvantagemID != null && !this.desvantagemID.equals(other.desvantagemID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entities.Desvantagem[ desvantagemID=" + desvantagemID + " ]";
    }
    
}
