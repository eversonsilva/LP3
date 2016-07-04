/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Everson
 */
@Entity
@Table(name = "SPOILER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Spoiler.findAll", query = "SELECT s FROM Spoiler s"),
    @NamedQuery(name = "Spoiler.findByIdSpoiler", query = "SELECT s FROM Spoiler s WHERE s.idSpoiler = :idSpoiler"),
    @NamedQuery(name = "Spoiler.findByAutor", query = "SELECT s FROM Spoiler s WHERE s.autor = :autor"),
    @NamedQuery(name = "Spoiler.findByTexto", query = "SELECT s FROM Spoiler s WHERE s.texto = :texto"),
    @NamedQuery(name = "Spoiler.findBySerie", query = "SELECT s FROM Spoiler s WHERE s.serie = :serie"),
    @NamedQuery(name = "Spoiler.findByDataSpoiler", query = "SELECT s FROM Spoiler s WHERE s.dataSpoiler = :dataSpoiler")})
public class Spoiler implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_SPOILER")
    private Long idSpoiler;
    @Size(max = 100)
    @Column(name = "AUTOR")
    private String autor;
    @Size(max = 140)
    @Column(name = "TEXTO")
    private String texto;
    @Size(max = 100)
    @Column(name = "SERIE")
    private String serie;
    @Column(name = "DATA_SPOILER")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataSpoiler;

    public Spoiler() {
    }

    public Spoiler(Long idSpoiler) {
        this.idSpoiler = idSpoiler;
    }

    public Long getIdSpoiler() {
        return idSpoiler;
    }

    public void setIdSpoiler(Long idSpoiler) {
        this.idSpoiler = idSpoiler;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Date getDataSpoiler() {
        return dataSpoiler;
    }

    public void setDataSpoiler(Date dataSpoiler) {
        this.dataSpoiler = dataSpoiler;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSpoiler != null ? idSpoiler.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Spoiler)) {
            return false;
        }
        Spoiler other = (Spoiler) object;
        if ((this.idSpoiler == null && other.idSpoiler != null) || (this.idSpoiler != null && !this.idSpoiler.equals(other.idSpoiler))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Spoiler{" + "idSpoiler=" + idSpoiler + ", autor=" + autor + ", texto=" + texto + ", serie=" + serie + ", dataSpoiler=" + dataSpoiler + '}';
    }

}
