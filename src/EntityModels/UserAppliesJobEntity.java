package EntityModels;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "user_applies_job")
public class UserAppliesJobEntity {
    private int uajId;
//    private int userId;
//    private int jobId;
    private String coverLeter;
    private Timestamp applyTime;
    private UserEntity usersByUserId;
    private JobEntity jobsByJobId;

    @Id
    @Column(name = "uaj_id", nullable = false)
    public int getUajId() {
        return uajId;
    }

    public void setUajId(int uajId) {
        this.uajId = uajId;
    }

//    @Basic
//    @Column(name = "user_id", nullable = false)
//    public int getUserId() {
//        return userId;
//    }
//
//    public void setUserId(int userId) {
//        this.userId = userId;
//    }

//    @Basic
//    @Column(name = "job_id", nullable = false)
//    public int getJobId() {
//        return jobId;
//    }
//
//    public void setJobId(int jobId) {
//        this.jobId = jobId;
//    }

    @Basic
    @Column(name = "cover_leter", nullable = true, length = -1)
    public String getCoverLeter() {
        return coverLeter;
    }

    public void setCoverLeter(String coverLeter) {
        this.coverLeter = coverLeter;
    }

    @Basic
    @Column(name = "apply_time", nullable = false)
    public Timestamp getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Timestamp applyTime) {
        this.applyTime = applyTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAppliesJobEntity that = (UserAppliesJobEntity) o;
        return uajId == that.uajId &&
//                userId == that.userId &&
//                jobId == that.jobId &&
                Objects.equals(coverLeter, that.coverLeter) &&
                Objects.equals(applyTime, that.applyTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(uajId, coverLeter, applyTime);
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    public UserEntity getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(UserEntity usersByUserId) {
        this.usersByUserId = usersByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "job_id", referencedColumnName = "job_id", nullable = false)
    public JobEntity getJobsByJobId() {
        return jobsByJobId;
    }

    public void setJobsByJobId(JobEntity jobsByJobId) {
        this.jobsByJobId = jobsByJobId;
    }
}
