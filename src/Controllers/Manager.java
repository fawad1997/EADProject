package Controllers;

import BackingBeans.UserDTO;
import DAO.common.DAOFactory;
import EntityModels.CountryEntity;
import EntityModels.UserEntity;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean(name = "testbean")
public class Manager {

    //Fields
    private UserDTO user = new UserDTO();
    //Constructors
    public Manager() {
    }
    //Getter and Setters

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }


    //My Methods
    public String addUser(){
        UserEntity userEntity = new UserEntity();
        userEntity.setName(user.getName());
        userEntity.setUserEmail(user.getEmail());
        userEntity.setUserPassword(user.getPassword());
        userEntity.setAddress("");
        userEntity.setCityId(user.getCity());
        userEntity.setDescription("");
        userEntity.setEmpOrComp(user.getCategory());
        CountryEntity countryEntity = DAOFactory.getCountry().findById(CountryEntity.class,user.getCountry());
        userEntity.setCountryByCountryId(countryEntity);
        DAOFactory.getUser().create(userEntity);
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
