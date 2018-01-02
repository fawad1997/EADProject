package EntityModels;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "user_education", schema = "ead", catalog = "")
public class UserEducationEntity {
    private int uedId;
    private Timestamp startDate;
    private Timestamp endDate;
    private String qualificationSpecilization;
    private BigDecimal qualificationMarks;

    @Id
    @Column(name = "ued_id")
    public int getUedId() {
        return uedId;
    }

    public void setUedId(int uedId) {
        this.uedId = uedId;
    }

    @Basic
    @Column(name = "start_date")
    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "end_date")
    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "qualification_specilization")
    public String getQualificationSpecilization() {
        return qualificationSpecilization;
    }

    public void setQualificationSpecilization(String qualificationSpecilization) {
        this.qualificationSpecilization = qualificationSpecilization;
    }

    @Basic
    @Column(name = "qualification_marks")
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
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(qualificationSpecilization, that.qualificationSpecilization) &&
                Objects.equals(qualificationMarks, that.qualificationMarks);
    }

    @Override
    public int hashCode() {

        return Objects.hash(uedId, startDate, endDate, qualificationSpecilization, qualificationMarks);
    }
}
