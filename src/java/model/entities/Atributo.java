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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Vinicius Faria
 */
@Entity
@Table(name = "atributo")
@NamedQueries({
    @NamedQuery(name = "Atributo.findAll", query = "SELECT a FROM Atributo a")
    , @NamedQuery(name = "Atributo.findByAtributoID", query = "SELECT a FROM Atributo a WHERE a.atributoID = :atributoID")
    , @NamedQuery(name = "Atributo.findByForca", query = "SELECT a FROM Atributo a WHERE a.forca = :forca")
    , @NamedQuery(name = "Atributo.findByHabilidade", query = "SELECT a FROM Atributo a WHERE a.habilidade = :habilidade")
    , @NamedQuery(name = "Atributo.findByResistencia", query = "SELECT a FROM Atributo a WHERE a.resistencia = :resistencia")
    , @NamedQuery(name = "Atributo.findByArmadura", query = "SELECT a FROM Atributo a WHERE a.armadura = :armadura")
    , @NamedQuery(name = "Atributo.findByVida", query = "SELECT a FROM Atributo a WHERE a.vida = :vida")
    , @NamedQuery(name = "Atributo.findByMagia", query = "SELECT a FROM Atributo a WHERE a.magia = :magia")})
public class Atributo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "atributoID")
    private Integer atributoID;
    @Basic(optional = false)
    @Column(name = "forca")
    private int forca;
    @Basic(optional = false)
    @Column(name = "habilidade")
    private int habilidade;
    @Basic(optional = false)
    @Column(name = "resistencia")
    private int resistencia;
    @Basic(optional = false)
    @Column(name = "armadura")
    private int armadura;
    @Basic(optional = false)
    @Column(name = "vida")
    private int vida;
    @Basic(optional = false)
    @Column(name = "magia")
    private int magia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "atributo")
    private List<Atributopersonagem> atributopersonagemList;

    public Atributo() {
    }

    public Atributo(Integer atributoID) {
        this.atributoID = atributoID;
    }

    public Atributo(Integer atributoID, int forca, int habilidade, int resistencia, int armadura, int vida, int magia) {
        this.atributoID = atributoID;
        this.forca = forca;
        this.habilidade = habilidade;
        this.resistencia = resistencia;
        this.armadura = armadura;
        this.vida = vida;
        this.magia = magia;
    }

    public Integer getAtributoID() {
        return atributoID;
    }

    public void setAtributoID(Integer atributoID) {
        this.atributoID = atributoID;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(int habilidade) {
        this.habilidade = habilidade;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public int getArmadura() {
        return armadura;
    }

    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getMagia() {
        return magia;
    }

    public void setMagia(int magia) {
        this.magia = magia;
    }

    public List<Atributopersonagem> getAtributopersonagemList() {
        return atributopersonagemList;
    }

    public void setAtributopersonagemList(List<Atributopersonagem> atributopersonagemList) {
        this.atributopersonagemList = atributopersonagemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (atributoID != null ? atributoID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Atributo)) {
            return false;
        }
        Atributo other = (Atributo) object;
        if ((this.atributoID == null && other.atributoID != null) || (this.atributoID != null && !this.atributoID.equals(other.atributoID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entities.Atributo[ atributoID=" + atributoID + " ]";
    }
    
}
