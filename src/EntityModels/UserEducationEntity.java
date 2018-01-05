package EntityModels;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "user_education")
public class UserEducationEntity {
    private int uedId;
    private int userId;
    private Timestamp startDate;
    private Timestamp endDate;
//    private int qualificationId;
    private String qualificationSpecilization;
    private BigDecimal qualificationMarks;
    private UsersEntity usersByUserId;
    private QualificationEntity qualificationByQualificationId;

    @Id
    @Column(name = "ued_id", nullable = false)
    public int getUedId() {
        return uedId;
    }

    public void setUedId(int uedId) {
        this.uedId = uedId;
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

    @Basic
    @Column(name = "start_date", nullable = false)
    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "end_date", nullable = true)
    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

//    @Basic
//    @Column(name = "qualification_id", nullable = false)
//    public int getQualificationId() {
//        return qualificationId;
//    }
//
//    public void setQualificationId(int qualificationId) {
//        this.qualificationId = qualificationId;
//    }

    @Basic
    @Column(name = "qualification_specilization", nullable = true, length = 50)
    public String getQualificationSpecilization() {
        return qualificationSpecilization;
    }

    public void setQualificationSpecilization(String qualificationSpecilization) {
        this.qualificationSpecilization = qualificationSpecilization;
    }

    @Basic
    @Column(name = "qualification_marks", nullable = true, precision = 2)
    public BigDecimal getQualificationMarks() {
        return qualificationMarks;
    }

    public void setQualificationMarks(BigDecimal qualificationMarks) {
        this.qualificationMarks = qualificationMarks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEducationEntity that = (UserEducationEntity) o;
        return uedId == that.uedId &&
                userId == that.userId &&
//                qualificationId == that.qualificationId &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(qualificationSpecilization, that.qualificationSpecilization) &&
                Objects.equals(qualificationMarks, that.qualificationMarks);
    }

    @Override
    public int hashCode() {

        return Objects.hash(uedId, userId, startDate, endDate, qualificationSpecilization, qualificationMarks);
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    public UsersEntity getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(UsersEntity usersByUserId) {
        this.usersByUserId = usersByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "qualification_id", referencedColumnName = "qualification_id", nullable = false)
    public QualificationEntity getQualificationByQualificationId() {
        return qualificationByQualificationId;
    }

    public void setQualificationByQualificationId(QualificationEntity qualificationByQualificationId) {
        this.qualificationByQualificationId = qualificationByQualificationId;
    }
}
