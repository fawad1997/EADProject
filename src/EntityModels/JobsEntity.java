package EntityModels;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "jobs")
public class JobsEntity {
    private int jobId;
    private String jobTitle;
    private String jobDescription;
    private Timestamp jobPosttime;
    private int jobVacencies;
    private String jobLocation;
    private int jobExperienceRequired;
    private String jobSalary;
//    private int jobMinQualificaionId;
//    private int companyId;
    private Collection<JobSkillsRequiredEntity> jobSkillsRequiredsByJobId;
    private QualificationEntity qualificationByJobMinQualificaionId;
    private UsersEntity usersByCompanyId;
    private Collection<UserAppliesJobEntity> userAppliesJobsByJobId;

    @Id
    @Column(name = "job_id", nullable = false)
    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    @Basic
    @Column(name = "job_title", nullable = false, length = 50)
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Basic
    @Column(name = "job_description", nullable = false, length = -1)
    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    @Basic
    @Column(name = "job_posttime", nullable = false)
    public Timestamp getJobPosttime() {
        return jobPosttime;
    }

    public void setJobPosttime(Timestamp jobPosttime) {
        this.jobPosttime = jobPosttime;
    }

    @Basic
    @Column(name = "job_vacencies", nullable = false)
    public int getJobVacencies() {
        return jobVacencies;
    }

    public void setJobVacencies(int jobVacencies) {
        this.jobVacencies = jobVacencies;
    }

    @Basic
    @Column(name = "job_location", nullable = true, length = -1)
    public String getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }

    @Basic
    @Column(name = "job_experience_required", nullable = false)
    public int getJobExperienceRequired() {
        return jobExperienceRequired;
    }

    public void setJobExperienceRequired(int jobExperienceRequired) {
        this.jobExperienceRequired = jobExperienceRequired;
    }

    @Basic
    @Column(name = "job_salary", nullable = true, length = 20)
    public String getJobSalary() {
        return jobSalary;
    }

    public void setJobSalary(String jobSalary) {
        this.jobSalary = jobSalary;
    }

//    @Basic
//    @Column(name = "job_min_qualificaion_id", nullable = false)
//    public int getJobMinQualificaionId() {
//        return jobMinQualificaionId;
//    }
//
//    public void setJobMinQualificaionId(int jobMinQualificaionId) {
//        this.jobMinQualificaionId = jobMinQualificaionId;
//    }

//    @Basic
//    @Column(name = "company_id", nullable = false)
//    public int getCompanyId() {
//        return companyId;
//    }
//
//    public void setCompanyId(int companyId) {
//        this.companyId = companyId;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobsEntity that = (JobsEntity) o;
        return jobId == that.jobId &&
                jobVacencies == that.jobVacencies &&
                jobExperienceRequired == that.jobExperienceRequired &&
//                jobMinQualificaionId == that.jobMinQualificaionId &&
//                companyId == that.companyId &&
                Objects.equals(jobTitle, that.jobTitle) &&
                Objects.equals(jobDescription, that.jobDescription) &&
                Objects.equals(jobPosttime, that.jobPosttime) &&
                Objects.equals(jobLocation, that.jobLocation) &&
                Objects.equals(jobSalary, that.jobSalary);
    }

    @Override
    public int hashCode() {

        return Objects.hash(jobId, jobTitle, jobDescription, jobPosttime, jobVacencies, jobLocation, jobExperienceRequired, jobSalary);
    }

    @OneToMany(mappedBy = "jobsByJobId")
    public Collection<JobSkillsRequiredEntity> getJobSkillsRequiredsByJobId() {
        return jobSkillsRequiredsByJobId;
    }

    public void setJobSkillsRequiredsByJobId(Collection<JobSkillsRequiredEntity> jobSkillsRequiredsByJobId) {
        this.jobSkillsRequiredsByJobId = jobSkillsRequiredsByJobId;
    }

    @ManyToOne
    @JoinColumn(name = "job_min_qualificaion_id", referencedColumnName = "qualification_id", nullable = false)
    public QualificationEntity getQualificationByJobMinQualificaionId() {
        return qualificationByJobMinQualificaionId;
    }

    public void setQualificationByJobMinQualificaionId(QualificationEntity qualificationByJobMinQualificaionId) {
        this.qualificationByJobMinQualificaionId = qualificationByJobMinQualificaionId;
    }

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "user_id", nullable = false)
    public UsersEntity getUsersByCompanyId() {
        return usersByCompanyId;
    }

    public void setUsersByCompanyId(UsersEntity usersByCompanyId) {
        this.usersByCompanyId = usersByCompanyId;
    }

    @OneToMany(mappedBy = "jobsByJobId")
    public Collection<UserAppliesJobEntity> getUserAppliesJobsByJobId() {
        return userAppliesJobsByJobId;
    }

    public void setUserAppliesJobsByJobId(Collection<UserAppliesJobEntity> userAppliesJobsByJobId) {
        this.userAppliesJobsByJobId = userAppliesJobsByJobId;
    }
}
