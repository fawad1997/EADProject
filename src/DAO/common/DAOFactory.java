package DAO.common;

import DAO.DAOImplementation.UserDAOImp;

public class DAOFactory {

    //Get UserDTO
    public static UserDAOImp getUser(){
        UserDAOImp userDAOImp = new UserDAOImp();
        return userDAOImp;
    }
}