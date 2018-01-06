package DAO.DAOImplementation;

import BackingBeans.UserDTO;
import DAO.DAOInterfaces.UserDAO;
import DAO.common.AbstractHibernateDao;
import EntityModels.UserEntity;
import HibernateDB.Main;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.faces.context.FacesContext;
import java.util.List;

public class UserDAOImp extends AbstractHibernateDao<UserEntity,Integer> implements UserDAO {

/*
    @Override
    public boolean addUser(UserDTO user) {
        Session s = Main.openSession();
        Transaction t = s.beginTransaction();
        try{
            UserEntity usersEntity = new UserEntity();
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
*/

    @Override
    public boolean authUser(UserDTO user) {
        Session s = Main.openSession();
        Transaction t = s.beginTransaction();
        try{
            System.out.println("auth");
            Query query = s.createQuery("from UserEntity where userEmail=:email and userPassword=:pass");
            query.setString("email",user.getEmail());
            query.setString("pass",user.getPassword());
            List<UserEntity> list = query.list();
            if (list.size()==1) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.getExternalContext().getSessionMap().put("email",user.getEmail());
                if (list.get(0).getEmpOrComp()==0)
                    context.getExternalContext().getSessionMap().put("jobseeker",true);
                else
                    context.getExternalContext().getSessionMap().put("company",true);
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Exception");
            t.rollback();
        }
        return false;
    }
}
