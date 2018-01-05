package EntityModels;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "qualification")
public class QualificationEntity {
    private int qualificationId;
    private String qualificationTitle;
    private Collection<JobsEntity> jobsByQualificationId;
    private Collection<UserEducationEntity> userEducationsByQualificationId;

    @Id
    @Column(name = "qualification_id", nullable = false)
    public int getQualificationId() {
        return qualificationId;
    }

    public void setQualificationId(int qualificationId) {
        this.qualificationId = qualificationId;
    }

    @Basic
    @Column(name = "qualification_title", nullable = false, length = 50)
    public String getQualificationTitle() {
        return qualificationTitle;
    }

    public void setQualificationTitle(String qualificationTitle) {
        this.qualificationTitle = qualificationTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QualificationEntity that = (QualificationEntity) o;
        return qualificationId == that.qualificationId &&
                Objects.equals(qualificationTitle, that.qualificationTitle);
    }

    @Override
    public int hashCode() {

        return Objects.hash(qualificationId, qualificationTitle);
    }

    @OneToMany(mappedBy = "qualificationByJobMinQualificaionId")
    public Collection<JobsEntity> getJobsByQualificationId() {
        return jobsByQualificationId;
    }

    public void setJobsByQualificationId(Collection<JobsEntity> jobsByQualificationId) {
        this.jobsByQualificationId = jobsByQualificationId;
    }

    @OneToMany(mappedBy = "qualificationByQualificationId")
    public Collection<UserEducationEntity> getUserEducationsByQualificationId() {
        return userEducationsByQualificationId;
    }

    public void setUserEducationsByQualificationId(Collection<UserEducationEntity> userEducationsByQualificationId) {
        this.userEducationsByQualificationId = userEducationsByQualificationId;
    }
}
