package Controllers;

import BackingBeans.JobDTO;
import BackingBeans.UserDTO;
import DAO.common.DAOFactory;
import EntityModels.CountryEntity;
import EntityModels.JobEntity;
import EntityModels.QualificationEntity;
import EntityModels.UserEntity;
import HibernateDB.Main;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "testbean")
@SessionScoped
public class Manager {

    //Fields
    private UserDTO user = new UserDTO();
    private JobDTO job = new JobDTO();
    private List<JobEntity> lstjobs = null;

    @PostConstruct
    public void init()
    {
        lstjobs = new ArrayList<JobEntity>();
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

    public List<JobEntity> getLstjobs() {
        lstjobs = DAOFactory.getJob().findall();
        return lstjobs;
    }

    public void setLstjobs(List<JobEntity> lstjobs) {
        this.lstjobs = lstjobs;
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
        jobEntity.setJobDescription(job.getDescription());
        jobEntity.setJobExperienceRequired(job.getExperienceYears());
        QualificationEntity qualificationEntity = DAOFactory.getQualification().findById(QualificationEntity.class,job.getMinQualification());
        jobEntity.setQualificationByJobMinQualificaionId(qualificationEntity);
        jobEntity.setJobSalary(job.getSalary());
        jobEntity.setJobVacencies(job.getVacencies());
        jobEntity.setJobLocation(job.getAddress());
        FacesContext context = FacesContext.getCurrentInstance();
        int id =(Integer) context.getExternalContext().getSessionMap().get("id");
        UserEntity userEntity = DAOFactory.getUser().findById(UserEntity.class,id);
        jobEntity.setUsersByCompanyId(userEntity);
        DAOFactory.getJob().create(jobEntity);
        return "jobs.xhtml?faces-redirect=true";
    }

    public boolean deleteJobEntity(int id){
        if (DAOFactory.getJob().deleteJobById(id))
            return true;
        return false;
    }

    public String editJobEntity(int id){
        job.setJobId(id);
//        JobEntity jobEntity = DAOFactory.getJob().getJobById(id);
//        job.setJobId(jobEntity.getJobId());
//        job.setTitle(jobEntity.getJobTitle());
        return "editJob.xhtml?faces-redirect=true";
    }

    public String editExistingJobPost(){
        JobEntity jobEntity = new JobEntity();
        jobEntity.setJobId(job.getJobId());
        jobEntity.setJobTitle(job.getTitle());
        jobEntity.setJobDescription(job.getDescription());
        jobEntity.setJobExperienceRequired(job.getExperienceYears());
        QualificationEntity qualificationEntity = DAOFactory.getQualification().findById(QualificationEntity.class,job.getMinQualification());
        jobEntity.setQualificationByJobMinQualificaionId(qualificationEntity);
        jobEntity.setJobSalary(job.getSalary());
        jobEntity.setJobVacencies(job.getVacencies());
        jobEntity.setJobLocation(job.getAddress());
        FacesContext context = FacesContext.getCurrentInstance();
        int id =(Integer) context.getExternalContext().getSessionMap().get("id");
        UserEntity userEntity = DAOFactory.getUser().findById(UserEntity.class,id);
        jobEntity.setUsersByCompanyId(userEntity);
        DAOFactory.getJob().create(jobEntity);
        return "jobs.xhtml?faces-redirect=true";
    }

}
