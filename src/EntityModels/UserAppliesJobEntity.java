package EntityModels;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "user_applies_job", schema = "ead", catalog = "")
public class UserAppliesJobEntity {
    private int uajId;
    private String coverLeter;
    private Timestamp applyTime;

    @Id
    @Column(name = "uaj_id")
    public int getUajId() {
        return uajId;
    }

    public void setUajId(int uajId) {
        this.uajId = uajId;
    }

    @Basic
    @Column(name = "cover_leter")
    public String getCoverLeter() {
        return coverLeter;
    }

    public void setCoverLeter(String coverLeter) {
        this.coverLeter = coverLeter;
    }

    @Basic
    @Column(name = "apply_time")
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
                Objects.equals(coverLeter, that.coverLeter) &&
                Objects.equals(applyTime, that.applyTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(uajId, coverLeter, applyTime);
    }
}
