package EntityModels;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "users")
public class UsersEntity {
    private int userId;
    private String name;
    private String userEmail;
    private String userPassword;
    private String description;
    private String address;
//    private Integer countryId;
    private int cityId;
    private int empOrComp;
    private Collection<JobsEntity> jobsByUserId;
    private Collection<RatingsEntity> ratingsByUserId;
    private Collection<UserAppliesJobEntity> userAppliesJobsByUserId;
    private Collection<UserEducationEntity> userEducationsByUserId;
    private Collection<UserExperienceEntity> userExperiencesByUserId;
    private Collection<UserPhonenoEntity> userPhonenosByUserId;
    private Collection<UserSkillsEntity> userSkillsByUserId;
    private CountryEntity countryByCountryId;

    @Id
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 80)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "user_email", nullable = false, length = 80)
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Basic
    @Column(name = "user_password", nullable = false, length = 80)
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "description", nullable = true, length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "address", nullable = false, length = -1)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

//    @Basic
//    @Column(name = "country_id", nullable = true)
//    public Integer getCountryId() {
//        return countryId;
//    }
//
//    public void setCountryId(Integer countryId) {
//        this.countryId = countryId;
//    }

    @Basic
    @Column(name = "city_id", nullable = false)
    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Basic
    @Column(name = "emp_or_comp", nullable = false)
    public int getEmpOrComp() {
        return empOrComp;
    }

    public void setEmpOrComp(int empOrComp) {
        this.empOrComp = empOrComp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity that = (UsersEntity) o;
        return userId == that.userId &&
                cityId == that.cityId &&
                empOrComp == that.empOrComp &&
                Objects.equals(name, that.name) &&
                Objects.equals(userEmail, that.userEmail) &&
                Objects.equals(userPassword, that.userPassword) &&
                Objects.equals(description, that.description) &&
                Objects.equals(address, that.address);
//                Objects.equals(countryId, that.countryId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, name, userEmail, userPassword, description, address, cityId, empOrComp);
    }

    @OneToMany(mappedBy = "usersByCompanyId")
    public Collection<JobsEntity> getJobsByUserId() {
        return jobsByUserId;
    }

    public void setJobsByUserId(Collection<JobsEntity> jobsByUserId) {
        this.jobsByUserId = jobsByUserId;
    }

    @OneToMany(mappedBy = "usersByRateTo")
    public Collection<RatingsEntity> getRatingsByUserId() {
        return ratingsByUserId;
    }

    public void setRatingsByUserId(Collection<RatingsEntity> ratingsByUserId) {
        this.ratingsByUserId = ratingsByUserId;
    }

    @OneToMany(mappedBy = "usersByUserId")
    public Collection<UserAppliesJobEntity> getUserAppliesJobsByUserId() {
        return userAppliesJobsByUserId;
    }

    public void setUserAppliesJobsByUserId(Collection<UserAppliesJobEntity> userAppliesJobsByUserId) {
        this.userAppliesJobsByUserId = userAppliesJobsByUserId;
    }

    @OneToMany(mappedBy = "usersByUserId")
    public Collection<UserEducationEntity> getUserEducationsByUserId() {
        return userEducationsByUserId;
    }

    public void setUserEducationsByUserId(Collection<UserEducationEntity> userEducationsByUserId) {
        this.userEducationsByUserId = userEducationsByUserId;
    }

    @OneToMany(mappedBy = "usersByUserId")
    public Collection<UserExperienceEntity> getUserExperiencesByUserId() {
        return userExperiencesByUserId;
    }

    public void setUserExperiencesByUserId(Collection<UserExperienceEntity> userExperiencesByUserId) {
        this.userExperiencesByUserId = userExperiencesByUserId;
    }

    @OneToMany(mappedBy = "usersByUserId")
    public Collection<UserPhonenoEntity> getUserPhonenosByUserId() {
        return userPhonenosByUserId;
    }

    public void setUserPhonenosByUserId(Collection<UserPhonenoEntity> userPhonenosByUserId) {
        this.userPhonenosByUserId = userPhonenosByUserId;
    }

    @OneToMany(mappedBy = "usersByUserId")
    public Collection<UserSkillsEntity> getUserSkillsByUserId() {
        return userSkillsByUserId;
    }

    public void setUserSkillsByUserId(Collection<UserSkillsEntity> userSkillsByUserId) {
        this.userSkillsByUserId = userSkillsByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "country_id")
    public CountryEntity getCountryByCountryId() {
        return countryByCountryId;
    }

    public void setCountryByCountryId(CountryEntity countryByCountryId) {
        this.countryByCountryId = countryByCountryId;
    }
}
