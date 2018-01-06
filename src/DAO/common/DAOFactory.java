package DAO.common;

import DAO.DAOImplementation.UserDAOImp;

public class DAOFactory {

    //Get User
    public static UserDAOImp getUser(){
        UserDAOImp userDAOImp = new UserDAOImp();
        return userDAOImp;
    }
}