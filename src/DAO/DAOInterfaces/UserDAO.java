package DAO.DAOInterfaces;

import BackingBeans.User;

public interface UserDAO {
    public boolean addUser(User user);
    public boolean authUser(User user);
}
