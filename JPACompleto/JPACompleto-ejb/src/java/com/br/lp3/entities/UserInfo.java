package com.br.lp3.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Everson
 */
@Entity
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_userInfo;

    @Size(max = 100)
    private String fullname;
    
    @Size(max = 150)
    private String email;
    
    @Temporal(TemporalType.DATE)
    private Date birthday;
    
    public Long getId() {
        return id_userInfo;
    }

    public void setId(Long id) {
        this.id_userInfo = id;
    }

    public Long getId_userInfo() {
        return id_userInfo;
    }

    public void setId_userInfo(Long id_userInfo) {
        this.id_userInfo = id_userInfo;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_userInfo != null ? id_userInfo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserInfo)) {
            return false;
        }
        UserInfo other = (UserInfo) object;
        if ((this.id_userInfo == null && other.id_userInfo != null) || (this.id_userInfo != null && !this.id_userInfo.equals(other.id_userInfo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UserInfo{" + "id_userInfo=" + id_userInfo + ", fullname=" + fullname + ", email=" + email + ", birthday=" + birthday + '}';
    }
    
}
