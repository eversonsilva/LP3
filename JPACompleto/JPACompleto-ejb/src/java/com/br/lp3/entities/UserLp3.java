package com.br.lp3.entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

/**
 *
 * @author Everson
 */
@Entity
public class UserLp3 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;

    @Size(max = 20)
    private String username;
    
    @Size(max = 32)
    private String password;

    @OneToOne( cascade = CascadeType.ALL, orphanRemoval = true )
    @JoinColumn(name = "id_userinfo")
    private UserInfo userInfo;
    
    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
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

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_user != null ? id_user.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserLp3)) {
            return false;
        }
        UserLp3 other = (UserLp3) object;
        if ((this.id_user == null && other.id_user != null) || (this.id_user != null && !this.id_user.equals(other.id_user))) {
            return false;
        }
        if(this.username != other.username){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UserLp3{" + "id_user=" + id_user + ", username=" + username + ", password=" + password + ", userInfo=" + userInfo + '}';
    }
    
}
