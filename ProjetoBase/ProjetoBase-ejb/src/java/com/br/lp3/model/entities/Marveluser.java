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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "MARVELUSER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Marveluser.findAll", query = "SELECT m FROM Marveluser m"),
    @NamedQuery(name = "Marveluser.findByIdUser", query = "SELECT m FROM Marveluser m WHERE m.idUser = :idUser"),
    @NamedQuery(name = "Marveluser.findByUsername", query = "SELECT m FROM Marveluser m WHERE m.username = :username"),
    @NamedQuery(name = "Marveluser.findByPassword", query = "SELECT m FROM Marveluser m WHERE m.password = :password")})
public class Marveluser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_USER")
    private Long idUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "PASSWORD")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private List<Marvelmatch> marvelmatchList;
    @JoinColumn(name = "ID_USER", referencedColumnName = "ID_USERINFO", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Userinfo userinfo;

    public Marveluser() {
    }

    public Marveluser(Long idUser) {
        this.idUser = idUser;
    }

    public Marveluser(Long idUser, String username, String password) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public List<Marvelmatch> getMarvelmatchList() {
        return marvelmatchList;
    }

    public void setMarvelmatchList(List<Marvelmatch> marvelmatchList) {
        this.marvelmatchList = marvelmatchList;
    }

    public Userinfo getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(Userinfo userinfo) {
        this.userinfo = userinfo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Marveluser)) {
            return false;
        }
        Marveluser other = (Marveluser) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.lp3.model.entities.Marveluser[ idUser=" + idUser + " ]";
    }
    
}
