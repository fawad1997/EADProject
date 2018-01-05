package DAO.DAOImplementation;

import BackingBeans.User;
import DAO.DAOFactory;
import DAO.DAOInterfaces.UserDAO;
import EntityModels.CountryEntity;
import EntityModels.UsersEntity;
import HibernateDB.Main;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDAOImp implements UserDAO {

    @Override
    public boolean addUser(User user) {
        Session s = Main.getSession();
        Transaction t = s.beginTransaction();
        try{
            UsersEntity usersEntity = new UsersEntity();
            usersEntity.setName(user.getName());
            usersEntity.setUserEmail(user.getEmail());
            usersEntity.setAddress(" ");
            usersEntity.setUserPassword(user.getPassword());
            usersEntity.setEmpOrComp(user.getCategory());
            usersEntity.setCityId(user.getCity());
            s.save(usersEntity);
            t.commit();
            return true;
        }catch (Exception e){
            t.rollback();
        }
        return false;
    }
}
