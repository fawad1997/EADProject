import TestBackingBeans.User;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "testbean")
public class TestBean {
    //Fields
    private User user = new User();

    //Constructors
    public TestBean() {
    }
    //Getter and Setters

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    //My Methods
    //Login
    public String authenticateUser(){
        System.out.println("Auth Method "+user.getEmail()+" : "+user.getPassword());
        if(user.getEmail().equals("fawad_12@outlook.com") && user.getPassword().equals("secret")){
            System.out.println("Not Null");
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
}
