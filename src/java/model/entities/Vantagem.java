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
@Table(name = "vantagem")
@NamedQueries({
    @NamedQuery(name = "Vantagem.findAll", query = "SELECT v FROM Vantagem v")
    , @NamedQuery(name = "Vantagem.findByVantagemID", query = "SELECT v FROM Vantagem v WHERE v.vantagemID = :vantagemID")
    , @NamedQuery(name = "Vantagem.findByNome", query = "SELECT v FROM Vantagem v WHERE v.nome = :nome")})
public class Vantagem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vantagemID")
    private Integer vantagemID;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Lob
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vantagem")
    private List<Vantagempersonagem> vantagempersonagemList;

    public Vantagem() {
    }

    public Vantagem(Integer vantagemID) {
        this.vantagemID = vantagemID;
    }

    public Vantagem(Integer vantagemID, String nome, String descricao) {
        this.vantagemID = vantagemID;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Integer getVantagemID() {
        return vantagemID;
    }

    public void setVantagemID(Integer vantagemID) {
        this.vantagemID = vantagemID;
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

    public List<Vantagempersonagem> getVantagempersonagemList() {
        return vantagempersonagemList;
    }

    public void setVantagempersonagemList(List<Vantagempersonagem> vantagempersonagemList) {
        this.vantagempersonagemList = vantagempersonagemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vantagemID != null ? vantagemID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vantagem)) {
            return false;
        }
        Vantagem other = (Vantagem) object;
        if ((this.vantagemID == null && other.vantagemID != null) || (this.vantagemID != null && !this.vantagemID.equals(other.vantagemID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entities.Vantagem[ vantagemID=" + vantagemID + " ]";
    }
    
}
