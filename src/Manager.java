import BackingBeans.User;
import DAO.DAOFactory;
import EntityModels.UsersEntity;
import HibernateDB.Main;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean(name = "testbean")
public class Manager {

    //Fields
    private User user = new User();
    //Constructors
    public Manager() {
    }
    //Getter and Setters

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    //My Methods
    public String addUser(){
/*        System.out.println(user.getName());
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        System.out.println(user.getRptPassword());
        System.out.println(user.getCategory());
        System.out.println(user.getCity());
        System.out.println(user.getCountry());*/
        if(DAOFactory.getUser().addUser(user)) {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Record Successfull", null);
        }else{
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error Inserting Record", null);
        }
        return null;
    }

    public String authenticateUser(){
        if(DAOFactory.getUser().authUser(user)){
            return "welcome.xhtml?faces-redirect=true";
        }else {
            System.out.println("Else Part");
            return "login.xhtml?faces-redirect=true";
        }
    }
    //Logout
    public String invalidate(){
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ec = context.getExternalContext();
        final HttpServletRequest request = (HttpServletRequest)ec.getRequest();
        request.getSession( false ).invalidate();
        //FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index.xhtml?faces-redirect=true";
    }
    public String editUser(){
        return "editUser.xhtml?faces-redirect=true";
    }
}
