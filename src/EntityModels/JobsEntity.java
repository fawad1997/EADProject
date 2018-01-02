package EntityModels;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "jobs", schema = "ead", catalog = "")
public class JobsEntity {
    private int jobId;
    private String jobTitle;
    private String jobDescription;
    private Timestamp jobPosttime;
    private int jobVacencies;
    private String jobLocation;
    private int jobExperienceRequired;
    private String jobSalary;

    @Id
    @Column(name = "job_id")
    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    @Basic
    @Column(name = "job_title")
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Basic
    @Column(name = "job_description")
    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    @Basic
    @Column(name = "job_posttime")
    public Timestamp getJobPosttime() {
        return jobPosttime;
    }

    public void setJobPosttime(Timestamp jobPosttime) {
        this.jobPosttime = jobPosttime;
    }

    @Basic
    @Column(name = "job_vacencies")
    public int getJobVacencies() {
        return jobVacencies;
    }

    public void setJobVacencies(int jobVacencies) {
        this.jobVacencies = jobVacencies;
    }

    @Basic
    @Column(name = "job_location")
    public String getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }

    @Basic
    @Column(name = "job_experience_required")
    public int getJobExperienceRequired() {
        return jobExperienceRequired;
    }

    public void setJobExperienceRequired(int jobExperienceRequired) {
        this.jobExperienceRequired = jobExperienceRequired;
    }

    @Basic
    @Column(name = "job_salary")
    public String getJobSalary() {
        return jobSalary;
    }

    public void setJobSalary(String jobSalary) {
        this.jobSalary = jobSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobsEntity that = (JobsEntity) o;
        return jobId == that.jobId &&
                jobVacencies == that.jobVacencies &&
                jobExperienceRequired == that.jobExperienceRequired &&
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
}
