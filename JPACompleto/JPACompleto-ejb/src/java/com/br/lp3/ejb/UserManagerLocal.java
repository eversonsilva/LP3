package com.br.lp3.ejb;

import com.br.lp3.entities.UserLp3;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Everson
 */
@Local
public interface UserManagerLocal {

    void insertUser(UserLp3 user);

    List<UserLp3> searchUsers();

    UserLp3 readByIdUser(long id);

    void updateUser(UserLp3 user);

    void removeUser(UserLp3 user);
    
}
