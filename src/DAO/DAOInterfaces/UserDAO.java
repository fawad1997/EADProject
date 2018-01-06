package DAO.DAOInterfaces;

import BackingBeans.UserDTO;
import DAO.common.GenericDao;
import EntityModels.UserEntity;

public interface UserDAO extends GenericDao<UserEntity,Integer> {
//    public boolean addUser(UserDTO user);
    public boolean authUser(UserDTO user);
}
