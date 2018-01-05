import BackingBeans.User;
import EntityModels.UsersEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
        Transaction t = null;
        Session s = Main.getSession();
        t = s.beginTransaction();

        UsersEntity userEntity = new UsersEntity();
        userEntity.setName("test");
        userEntity.setUserEmail("test1");
        userEntity.setUserPassword("test2");
        userEntity.setAddress("test3");
        userEntity.setCityId(1);
        userEntity.setDescription("test5");
        userEntity.setEmpOrComp(1);

        s.save(userEntity);
        t.commit();
        s.close();
        return null;
    }
    //Login
    public String authenticateUser(){
        System.out.println("Auth Method "+user.getEmail()+" : "+user.getPassword());
        if(user.getEmail().equals("fawad_12@outlook.com") && user.getPassword().equals("secret")){

            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getSessionMap().put("email",user.getEmail());
            context.getExternalContext().getSessionMap().put("jobseeker",true);
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
