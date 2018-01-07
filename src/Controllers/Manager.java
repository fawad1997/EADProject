package Controllers;

import BackingBeans.JobDTO;
import BackingBeans.UserDTO;
import DAO.common.DAOFactory;
import EntityModels.CountryEntity;
import EntityModels.JobEntity;
import EntityModels.QualificationEntity;
import EntityModels.UserEntity;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean(name = "testbean")
public class Manager {

    //Fields
    private UserDTO user = new UserDTO();
    private JobDTO job = new JobDTO();
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

    public JobDTO getJob() {
        return job;
    }

    public void setJob(JobDTO job) {
        this.job = job;
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

    //Post Job
    public String postJobPage(){
        return "newJob.xhtml";
    }
    public String createNewJobPost(){
        JobEntity jobEntity = new JobEntity();
        jobEntity.setJobTitle(job.getTitle());
//        System.out.println(job.getTitle());
        jobEntity.setJobDescription(job.getDescription());
//        System.out.println(job.getDescription());
        jobEntity.setJobExperienceRequired(job.getExperienceYears());
//        System.out.println(job.getExperienceYears());
        QualificationEntity qualificationEntity = DAOFactory.getQualification().findById(QualificationEntity.class,job.getMinQualification());
//        System.out.println(job.getMinQualification());
        jobEntity.setQualificationByJobMinQualificaionId(qualificationEntity);
        jobEntity.setJobSalary(job.getSalary());
//        System.out.println(job.getSalary());
        jobEntity.setJobVacencies(job.getVacencies());
//        System.out.println(job.getVacencies());
        jobEntity.setJobLocation(job.getAddress());
//        System.out.println(job.getAddress());
        FacesContext context = FacesContext.getCurrentInstance();
        int id =(Integer) context.getExternalContext().getSessionMap().get("id");
        UserEntity userEntity = DAOFactory.getUser().findById(UserEntity.class,id);
        jobEntity.setUsersByCompanyId(userEntity);
        DAOFactory.getJob().create(jobEntity);
        return "jobs.xhtml?faces-redirect=true";
    }
}
