package DAO.DAOImplementation;

import BackingBeans.User;
import DAO.DAOFactory;
import DAO.DAOInterfaces.UserDAO;
import EntityModels.CountryEntity;
import EntityModels.UsersEntity;
import HibernateDB.Main;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.faces.context.FacesContext;
import java.util.List;

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

    @Override
    public boolean authUser(User user) {
        Session s = Main.getSession();
        Transaction t = s.beginTransaction();
        try{
            System.out.println("auth");
            Query query = s.createQuery("from UsersEntity where userEmail=:email and userPassword=:pass");
            query.setString("email",user.getEmail());
            query.setString("pass",user.getPassword());
            List<UsersEntity> list = query.list();
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
