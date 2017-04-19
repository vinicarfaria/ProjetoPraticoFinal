/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

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
@Table(name = "personagem")
@NamedQueries({
    @NamedQuery(name = "Personagem.findAll", query = "SELECT p FROM Personagem p")
    , @NamedQuery(name = "Personagem.findByPersonagemID", query = "SELECT p FROM Personagem p WHERE p.personagemID = :personagemID")
    , @NamedQuery(name = "Personagem.findByNome", query = "SELECT p FROM Personagem p WHERE p.nome = :nome")
    , @NamedQuery(name = "Personagem.findByNivel", query = "SELECT p FROM Personagem p WHERE p.nivel = :nivel")
    , @NamedQuery(name = "Personagem.findByForca", query = "SELECT p FROM Personagem p WHERE p.forca = :forca")
    , @NamedQuery(name = "Personagem.findByHabilidade", query = "SELECT p FROM Personagem p WHERE p.habilidade = :habilidade")
    , @NamedQuery(name = "Personagem.findByResistencia", query = "SELECT p FROM Personagem p WHERE p.resistencia = :resistencia")
    , @NamedQuery(name = "Personagem.findByArmadura", query = "SELECT p FROM Personagem p WHERE p.armadura = :armadura")
    , @NamedQuery(name = "Personagem.findByVida", query = "SELECT p FROM Personagem p WHERE p.vida = :vida")})
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
    @JoinColumn(name = "racaID", referencedColumnName = "racaID")
    @ManyToOne(optional = false)
    private Raca raca;
    @JoinColumn(name = "classeID", referencedColumnName = "classeID")
    @ManyToOne(optional = false)
    private Classe classe;
    @JoinColumn(name = "usuarioID", referencedColumnName = "usuarioID")
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Personagem() {
        raca = new Raca();
        classe = new Classe();
        usuario = new Usuario();
    }

    public Personagem(Integer personagemID) {
        this.personagemID = personagemID;
    }

    public Personagem(Integer personagemID, String nome, int nivel, int forca, int habilidade, int resistencia, int armadura, int vida) {
        this.personagemID = personagemID;
        this.nome = nome;
        this.nivel = nivel;
        this.forca = forca;
        this.habilidade = habilidade;
        this.resistencia = resistencia;
        this.armadura = armadura;
        this.vida = vida;
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

    public Raca getRaca() {
        return raca;
    }

    public void setRaca(Raca raca) {
        this.raca = raca;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
        return "entities.Personagem[ personagemID=" + personagemID + " ]";
    }
    
}
