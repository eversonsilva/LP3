/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.entities;

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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Everson
 */
@Entity
@Table(name = "MARVELMATCH")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Marvelmatch.findAll", query = "SELECT m FROM Marvelmatch m"),
    @NamedQuery(name = "Marvelmatch.findByIdMarvelmatch", query = "SELECT m FROM Marvelmatch m WHERE m.idMarvelmatch = :idMarvelmatch"),
    @NamedQuery(name = "Marvelmatch.findByCodHero", query = "SELECT m FROM Marvelmatch m WHERE m.codHero = :codHero"),
    @NamedQuery(name = "Marvelmatch.findByCodEnemy", query = "SELECT m FROM Marvelmatch m WHERE m.codEnemy = :codEnemy"),
    @NamedQuery(name = "Marvelmatch.findByStatus", query = "SELECT m FROM Marvelmatch m WHERE m.status = :status")})
public class Marvelmatch implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_MARVELMATCH")
    private Long idMarvelmatch;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_HERO")
    private long codHero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_ENEMY")
    private long codEnemy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS")
    private int status;
    @JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER")
    @ManyToOne(optional = false)
    private Marveluser idUser;

    public Marvelmatch() {
    }

    public Marvelmatch(Long idMarvelmatch) {
        this.idMarvelmatch = idMarvelmatch;
    }

    public Marvelmatch(Long idMarvelmatch, long codHero, long codEnemy, int status) {
        this.idMarvelmatch = idMarvelmatch;
        this.codHero = codHero;
        this.codEnemy = codEnemy;
        this.status = status;
    }

    public Long getIdMarvelmatch() {
        return idMarvelmatch;
    }

    public void setIdMarvelmatch(Long idMarvelmatch) {
        this.idMarvelmatch = idMarvelmatch;
    }

    public long getCodHero() {
        return codHero;
    }

    public void setCodHero(long codHero) {
        this.codHero = codHero;
    }

    public long getCodEnemy() {
        return codEnemy;
    }

    public void setCodEnemy(long codEnemy) {
        this.codEnemy = codEnemy;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Marveluser getIdUser() {
        return idUser;
    }

    public void setIdUser(Marveluser idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMarvelmatch != null ? idMarvelmatch.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Marvelmatch)) {
            return false;
        }
        Marvelmatch other = (Marvelmatch) object;
        if ((this.idMarvelmatch == null && other.idMarvelmatch != null) || (this.idMarvelmatch != null && !this.idMarvelmatch.equals(other.idMarvelmatch))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.lp3.model.entities.Marvelmatch[ idMarvelmatch=" + idMarvelmatch + " ]";
    }
    
}
