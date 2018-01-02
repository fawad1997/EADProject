package EntityModels;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "qualification", schema = "ead", catalog = "")
public class QualificationEntity {
    private int qualificationId;
    private String qualificationTitle;

    @Id
    @Column(name = "qualification_id")
    public int getQualificationId() {
        return qualificationId;
    }

    public void setQualificationId(int qualificationId) {
        this.qualificationId = qualificationId;
    }

    @Basic
    @Column(name = "qualification_title")
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
}
