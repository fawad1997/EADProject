package EntityModels;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "user_experience", schema = "ead", catalog = "")
public class UserExperienceEntity {
    private int userExperienceId;
    private Timestamp ueStartDate;
    private Timestamp ueEndDate;
    private String ueCompanyName;
    private String uePosition;

    @Id
    @Column(name = "user_experience_id")
    public int getUserExperienceId() {
        return userExperienceId;
    }

    public void setUserExperienceId(int userExperienceId) {
        this.userExperienceId = userExperienceId;
    }

    @Basic
    @Column(name = "ue_start_date")
    public Timestamp getUeStartDate() {
        return ueStartDate;
    }

    public void setUeStartDate(Timestamp ueStartDate) {
        this.ueStartDate = ueStartDate;
    }

    @Basic
    @Column(name = "ue_end_date")
    public Timestamp getUeEndDate() {
        return ueEndDate;
    }

    public void setUeEndDate(Timestamp ueEndDate) {
        this.ueEndDate = ueEndDate;
    }

    @Basic
    @Column(name = "ue_company_name")
    public String getUeCompanyName() {
        return ueCompanyName;
    }

    public void setUeCompanyName(String ueCompanyName) {
        this.ueCompanyName = ueCompanyName;
    }

    @Basic
    @Column(name = "ue_position")
    public String getUePosition() {
        return uePosition;
    }

    public void setUePosition(String uePosition) {
        this.uePosition = uePosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserExperienceEntity that = (UserExperienceEntity) o;
        return userExperienceId == that.userExperienceId &&
                Objects.equals(ueStartDate, that.ueStartDate) &&
                Objects.equals(ueEndDate, that.ueEndDate) &&
                Objects.equals(ueCompanyName, that.ueCompanyName) &&
                Objects.equals(uePosition, that.uePosition);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userExperienceId, ueStartDate, ueEndDate, ueCompanyName, uePosition);
    }
}
