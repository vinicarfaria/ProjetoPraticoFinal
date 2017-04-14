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
@Table(name = "personagem")
@NamedQueries({
    @NamedQuery(name = "Personagem.findAll", query = "SELECT p FROM Personagem p")
    , @NamedQuery(name = "Personagem.findByPersonagemID", query = "SELECT p FROM Personagem p WHERE p.personagemID = :personagemID")
    , @NamedQuery(name = "Personagem.findByNome", query = "SELECT p FROM Personagem p WHERE p.nome = :nome")
    , @NamedQuery(name = "Personagem.findByNivel", query = "SELECT p FROM Personagem p WHERE p.nivel = :nivel")
    , @NamedQuery(name = "Personagem.findByRaca", query = "SELECT p FROM Personagem p WHERE p.raca = :raca")
    , @NamedQuery(name = "Personagem.findByIdade", query = "SELECT p FROM Personagem p WHERE p.idade = :idade")
    , @NamedQuery(name = "Personagem.findByPeso", query = "SELECT p FROM Personagem p WHERE p.peso = :peso")
    , @NamedQuery(name = "Personagem.findByAltura", query = "SELECT p FROM Personagem p WHERE p.altura = :altura")
    , @NamedQuery(name = "Personagem.findBySexo", query = "SELECT p FROM Personagem p WHERE p.sexo = :sexo")})
public class Personagem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "personagemID")
    private Integer personagemID;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "nivel")
    private int nivel;
    @Basic(optional = false)
    @Column(name = "raca")
    private String raca;
    @Basic(optional = false)
    @Column(name = "idade")
    private int idade;
    @Basic(optional = false)
    @Column(name = "peso")
    private float peso;
    @Basic(optional = false)
    @Column(name = "altura")
    private float altura;
    @Basic(optional = false)
    @Column(name = "sexo")
    private String sexo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personagem")
    private List<Usuariopersonagem> usuariopersonagemList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personagem")
    private List<Magiapersonagem> magiapersonagemList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personagem")
    private List<Atributopersonagem> atributopersonagemList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personagem")
    private List<Vantagempersonagem> vantagempersonagemList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personagem")
    private List<Desvantagempersonagem> desvantagempersonagemList;

    public Personagem() {
    }

    public Personagem(Integer personagemID) {
        this.personagemID = personagemID;
    }

    public Personagem(Integer personagemID, String nome, int nivel, String raca, int idade, float peso, float altura, String sexo) {
        this.personagemID = personagemID;
        this.nome = nome;
        this.nivel = nivel;
        this.raca = raca;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
        this.sexo = sexo;
    }

    public Integer getPersonagemID() {
        return personagemID;
    }

    public void setPersonagemID(Integer personagemID) {
        this.personagemID = personagemID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public List<Usuariopersonagem> getUsuariopersonagemList() {
        return usuariopersonagemList;
    }

    public void setUsuariopersonagemList(List<Usuariopersonagem> usuariopersonagemList) {
        this.usuariopersonagemList = usuariopersonagemList;
    }

    public List<Magiapersonagem> getMagiapersonagemList() {
        return magiapersonagemList;
    }

    public void setMagiapersonagemList(List<Magiapersonagem> magiapersonagemList) {
        this.magiapersonagemList = magiapersonagemList;
    }

    public List<Atributopersonagem> getAtributopersonagemList() {
        return atributopersonagemList;
    }

    public void setAtributopersonagemList(List<Atributopersonagem> atributopersonagemList) {
        this.atributopersonagemList = atributopersonagemList;
    }

    public List<Vantagempersonagem> getVantagempersonagemList() {
        return vantagempersonagemList;
    }

    public void setVantagempersonagemList(List<Vantagempersonagem> vantagempersonagemList) {
        this.vantagempersonagemList = vantagempersonagemList;
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
        hash += (personagemID != null ? personagemID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personagem)) {
            return false;
        }
        Personagem other = (Personagem) object;
        if ((this.personagemID == null && other.personagemID != null) || (this.personagemID != null && !this.personagemID.equals(other.personagemID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entities.Personagem[ personagemID=" + personagemID + " ]";
    }
    
}
