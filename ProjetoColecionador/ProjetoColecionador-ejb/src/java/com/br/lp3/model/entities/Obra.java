/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Everson
 */
@Entity
@Table(name = "OBRA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Obra.findAll", query = "SELECT o FROM Obra o"),
    @NamedQuery(name = "Obra.findByIdObra", query = "SELECT o FROM Obra o WHERE o.idObra = :idObra"),
    @NamedQuery(name = "Obra.findByNomeobra", query = "SELECT o FROM Obra o WHERE o.nomeobra = :nomeobra")})
public class Obra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_OBRA")
    private Long idObra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "NOMEOBRA")
    private String nomeobra;
    @JoinColumn(name = "ID_AUTOR", referencedColumnName = "ID_AUTOR")
    @ManyToOne(optional = false)
    private Autor idAutor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idObra")
    private List<Emprestimo> emprestimoList;

    public Obra() {
    }

    public Obra(Long idObra) {
        this.idObra = idObra;
    }

    public Obra(Long idObra, String nomeobra) {
        this.idObra = idObra;
        this.nomeobra = nomeobra;
    }

    public Long getIdObra() {
        return idObra;
    }

    public void setIdObra(Long idObra) {
        this.idObra = idObra;
    }

    public String getNomeobra() {
        return nomeobra;
    }

    public void setNomeobra(String nomeobra) {
        this.nomeobra = nomeobra;
    }

    public Autor getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Autor idAutor) {
        this.idAutor = idAutor;
    }

    @XmlTransient
    public List<Emprestimo> getEmprestimoList() {
        return emprestimoList;
    }

    public void setEmprestimoList(List<Emprestimo> emprestimoList) {
        this.emprestimoList = emprestimoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idObra != null ? idObra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Obra)) {
            return false;
        }
        Obra other = (Obra) object;
        if ((this.idObra == null && other.idObra != null) || (this.idObra != null && !this.idObra.equals(other.idObra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.lp3.model.entities.Obra[ idObra=" + idObra + " ]";
    }
    
}
