package DAO.common;

import DAO.DAOImplementation.*;
import DAO.DAOInterfaces.*;

public class DAOFactory {

    //Get User
    public static UserDAOImp getUser(){
        UserDAOImp userDAOImp = new UserDAOImp();
        return userDAOImp;
    }

    //Get Admin
    public static AdminDAO getAdmin(){
        return new AdminDAOImpl();
    }

    //Get City
    public static CityDAO getCity(){
        return new CityDAOImpl();
    }

    //get ContactUs
    public static ContactUsDAO getContactUs(){
        return new ContactUsDAOImpl();
    }

    //Get Country
    public static CountryDAO getCountry(){
        return new CountryDAOImpl();
    }

    //GetJob
    public static JobDAO getJob(){
        return new JobDAOImpl();
    }

    //Get JobSkillRequired
    public static JobSkillsRequiredDAO getJobSkillRequired(){
        return new JobSkillRequiredDAOImpl();
    }

    //get Qualification
    public static QualificationDAO getQualification(){
        return new QualificationDAOImpl();
    }

    //Get Rating
    public static RatingDAO getRating(){
        return new RatingDAOImpl();
    }

    //Get SKill
    public static SkillDAO getSkill(){
        return new SkillDAOImpl();
    }

    //Get UserAppliesJob
    public static UserAppliesJobDAO getUserAppliesJob(){
        return new UserAppliesJobDAOImpl();
    }

    //Get UserEducation
    public static UserEducationDAO getUserEducation(){
        return new UserEducationDAOImpl();
    }

    //get UserExperience
    public static UserExperienceDAO getUserExperience(){
        return new UserExperienceDAOImpl();
    }

    //Get UserPhoneNo
    public static UserPhonenoDAO getUserPhoneNo(){
        return new UserPhonenoDAOImpl();
    }
}