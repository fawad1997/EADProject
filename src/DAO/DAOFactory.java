package DAO;

import DAO.DAOImplementation.UserDAOImp;

public class DAOFactory {
    public static UserDAOImp getUser(){
        UserDAOImp userDAOImp = new UserDAOImp();
        return userDAOImp;
    }
}
