/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Everson
 */

@Entity
@Table(name = "userinfo")
public class UserInfo implements Serializable{
    
    @Id
    @Column (name = "id_userinfo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_userinfo;
    
    @Column(name = "fullname")
    @Size(max = 100)
    private String fullname;
   
    @Column(name = "email")
    @Size(max = 100)
    private String email;

    @JoinColumn(name = "ID_USERINFO", referencedColumnName = "ID_USER", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private UserLp3 userlp3;

    public UserLp3 getUserlp3() {
        return userlp3;
    }

    public void setUserlp3(UserLp3 userlp3) {
        this.userlp3 = userlp3;
    }

    public UserInfo() {
    }

    public long getId_userinfo() {
        return id_userinfo;
    }

    public void setId_userinfo(long id_userinfo) {
        this.id_userinfo = id_userinfo;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString(){
        return "UserInfo{" + "id_userinfo=" +id_userinfo+ " fullname=" +fullname+ ", email=" +email+ ", userlp3=" +userlp3+ '}';
    }

}
