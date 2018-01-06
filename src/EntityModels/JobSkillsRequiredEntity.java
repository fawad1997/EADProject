package EntityModels;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "job_skills_required")
public class JobSkillsRequiredEntity {
    private int jsrId;
//    private int jobId;
//    private int skillId;
    private JobEntity jobsByJobId;
    private SkillEntity skillsBySkillId;

    @Id
    @Column(name = "jsr_id", nullable = false)
    public int getJsrId() {
        return jsrId;
    }

    public void setJsrId(int jsrId) {
        this.jsrId = jsrId;
    }

//    @Basic
//    @Column(name = "job_id", nullable = false)
//    public int getJobId() {
//        return jobId;
//    }
//
//    public void setJobId(int jobId) {
//        this.jobId = jobId;
//    }
//
//    @Basic
//    @Column(name = "skill_id", nullable = false)
//    public int getSkillId() {
//        return skillId;
//    }
//
//    public void setSkillId(int skillId) {
//        this.skillId = skillId;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobSkillsRequiredEntity that = (JobSkillsRequiredEntity) o;
        return jsrId == that.jsrId;
//                jobId == that.jobId &&
//                skillId == that.skillId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(jsrId);
    }

    @ManyToOne
    @JoinColumn(name = "job_id", referencedColumnName = "job_id", nullable = false)
    public JobEntity getJobsByJobId() {
        return jobsByJobId;
    }

    public void setJobsByJobId(JobEntity jobsByJobId) {
        this.jobsByJobId = jobsByJobId;
    }

    @ManyToOne
    @JoinColumn(name = "skill_id", referencedColumnName = "skill_id", nullable = false)
    public SkillEntity getSkillsBySkillId() {
        return skillsBySkillId;
    }

    public void setSkillsBySkillId(SkillEntity skillsBySkillId) {
        this.skillsBySkillId = skillsBySkillId;
    }
}
