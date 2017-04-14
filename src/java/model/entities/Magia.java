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
@Table(name = "magia")
@NamedQueries({
    @NamedQuery(name = "Magia.findAll", query = "SELECT m FROM Magia m")
    , @NamedQuery(name = "Magia.findByMagiaID", query = "SELECT m FROM Magia m WHERE m.magiaID = :magiaID")
    , @NamedQuery(name = "Magia.findByNome", query = "SELECT m FROM Magia m WHERE m.nome = :nome")
    , @NamedQuery(name = "Magia.findByEscola", query = "SELECT m FROM Magia m WHERE m.escola = :escola")
    , @NamedQuery(name = "Magia.findByCusto", query = "SELECT m FROM Magia m WHERE m.custo = :custo")
    , @NamedQuery(name = "Magia.findByAlcance", query = "SELECT m FROM Magia m WHERE m.alcance = :alcance")})
public class Magia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "magiaID")
    private Integer magiaID;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "escola")
    private String escola;
    @Basic(optional = false)
    @Column(name = "custo")
    private String custo;
    @Basic(optional = false)
    @Column(name = "alcance")
    private String alcance;
    @Basic(optional = false)
    @Lob
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "magia")
    private List<Magiapersonagem> magiapersonagemList;

    public Magia() {
    }

    public Magia(Integer magiaID) {
        this.magiaID = magiaID;
    }

    public Magia(Integer magiaID, String nome, String escola, String custo, String alcance, String descricao) {
        this.magiaID = magiaID;
        this.nome = nome;
        this.escola = escola;
        this.custo = custo;
        this.alcance = alcance;
        this.descricao = descricao;
    }

    public Integer getMagiaID() {
        return magiaID;
    }

    public void setMagiaID(Integer magiaID) {
        this.magiaID = magiaID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEscola() {
        return escola;
    }

    public void setEscola(String escola) {
        this.escola = escola;
    }

    public String getCusto() {
        return custo;
    }

    public void setCusto(String custo) {
        this.custo = custo;
    }

    public String getAlcance() {
        return alcance;
    }

    public void setAlcance(String alcance) {
        this.alcance = alcance;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Magiapersonagem> getMagiapersonagemList() {
        return magiapersonagemList;
    }

    public void setMagiapersonagemList(List<Magiapersonagem> magiapersonagemList) {
        this.magiapersonagemList = magiapersonagemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (magiaID != null ? magiaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Magia)) {
            return false;
        }
        Magia other = (Magia) object;
        if ((this.magiaID == null && other.magiaID != null) || (this.magiaID != null && !this.magiaID.equals(other.magiaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entities.Magia[ magiaID=" + magiaID + " ]";
    }
    
}
