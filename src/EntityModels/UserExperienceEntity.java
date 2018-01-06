package EntityModels;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "user_experience")
public class UserExperienceEntity {
    private int userExperienceId;
//    private int userId;
    private Timestamp ueStartDate;
    private Timestamp ueEndDate;
    private String ueCompanyName;
    private String uePosition;
    private UserEntity usersByUserId;

    @Id
    @Column(name = "user_experience_id", nullable = false)
    public int getUserExperienceId() {
        return userExperienceId;
    }

    public void setUserExperienceId(int userExperienceId) {
        this.userExperienceId = userExperienceId;
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
    @Column(name = "ue_start_date", nullable = false)
    public Timestamp getUeStartDate() {
        return ueStartDate;
    }

    public void setUeStartDate(Timestamp ueStartDate) {
        this.ueStartDate = ueStartDate;
    }

    @Basic
    @Column(name = "ue_end_date", nullable = true)
    public Timestamp getUeEndDate() {
        return ueEndDate;
    }

    public void setUeEndDate(Timestamp ueEndDate) {
        this.ueEndDate = ueEndDate;
    }

    @Basic
    @Column(name = "ue_company_name", nullable = false, length = 50)
    public String getUeCompanyName() {
        return ueCompanyName;
    }

    public void setUeCompanyName(String ueCompanyName) {
        this.ueCompanyName = ueCompanyName;
    }

    @Basic
    @Column(name = "ue_position", nullable = false, length = 50)
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

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    public UserEntity getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(UserEntity usersByUserId) {
        this.usersByUserId = usersByUserId;
    }
}
