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
@Table(name = "TIPOUSUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipousuario.findAll", query = "SELECT t FROM Tipousuario t"),
    @NamedQuery(name = "Tipousuario.findByIdTipousuario", query = "SELECT t FROM Tipousuario t WHERE t.idTipousuario = :idTipousuario"),
    @NamedQuery(name = "Tipousuario.findByNometipousuario", query = "SELECT t FROM Tipousuario t WHERE t.nometipousuario = :nometipousuario")})
public class Tipousuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPOUSUARIO")
    private Long idTipousuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "NOMETIPOUSUARIO")
    private String nometipousuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipousuario")
    private List<Usuario> usuarioList;

    public Tipousuario() {
    }

    public Tipousuario(Long idTipousuario) {
        this.idTipousuario = idTipousuario;
    }

    public Tipousuario(Long idTipousuario, String nometipousuario) {
        this.idTipousuario = idTipousuario;
        this.nometipousuario = nometipousuario;
    }

    public Long getIdTipousuario() {
        return idTipousuario;
    }

    public void setIdTipousuario(Long idTipousuario) {
        this.idTipousuario = idTipousuario;
    }

    public String getNometipousuario() {
        return nometipousuario;
    }

    public void setNometipousuario(String nometipousuario) {
        this.nometipousuario = nometipousuario;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipousuario != null ? idTipousuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipousuario)) {
            return false;
        }
        Tipousuario other = (Tipousuario) object;
        if ((this.idTipousuario == null && other.idTipousuario != null) || (this.idTipousuario != null && !this.idTipousuario.equals(other.idTipousuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.lp3.model.entities.Tipousuario[ idTipousuario=" + idTipousuario + " ]";
    }
    
}
