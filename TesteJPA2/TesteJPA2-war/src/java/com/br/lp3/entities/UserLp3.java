/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Everson
 */

@Entity
@Table(name = "userlp3")
public class UserLp3 implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_user;
    
    @Size(max = 100)
    private String username;
    
    @Size(max = 32)
    private String password;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userlp3")
    private UserInfo userinfo;

    public UserLp3() {
    }

    public long getId_user() {
        return id_user;
    }


    public void setId_user(long id_user) {
        this.id_user = id_user;
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

    public UserInfo getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(UserInfo userinfo) {
        this.userinfo = userinfo;
    }

    @Override
    public String toString(){
        return "UserLp3{" + "id_user =" +id_user+ ", username=" +username+ ", password=" +password+ ", userinfo=" +userinfo+ '}';
    }

}
