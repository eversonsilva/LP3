package com.br.lp3.ejb;

import com.br.lp3.entities.UserLp3;
import com.br.lp3.model.dao.UserLp3DAO;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Everson
 */
@Stateless
public class UserManager implements UserManagerLocal {

    private UserLp3DAO dao;
    
    public UserManager(){
        dao = new UserLp3DAO();
    }
    
    @Override
    public void insertUser(UserLp3 user) {
        dao.create(user);
    }

    @Override
    public List<UserLp3> searchUsers() {
        return dao.read();
    }

    @Override
    public UserLp3 readByIdUser(long id) {
        return dao.readById(id);
    }

    @Override
    public void updateUser(UserLp3 user) {
        dao.update(user);
    }

    @Override
    public void removeUser(UserLp3 user) {
        dao.delete(user);
    }
    
    
    
    
    
    

    
   
    
}
