package EntityModels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "job_skills_required", schema = "ead", catalog = "")
public class JobSkillsRequiredEntity {
    private int jsrId;

    @Id
    @Column(name = "jsr_id")
    public int getJsrId() {
        return jsrId;
    }

    public void setJsrId(int jsrId) {
        this.jsrId = jsrId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobSkillsRequiredEntity that = (JobSkillsRequiredEntity) o;
        return jsrId == that.jsrId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(jsrId);
    }
}
