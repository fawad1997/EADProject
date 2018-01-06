package EntityModels;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "skills")
public class SkillEntity {
    private int skillId;
    private String skillTitle;
    private int skillApproveStat;
    private Collection<JobSkillsRequiredEntity> jobSkillsRequiredsBySkillId;
    private Collection<UserSkillsEntity> userSkillsBySkillId;

    @Id
    @Column(name = "skill_id", nullable = false)
    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    @Basic
    @Column(name = "skill_title", nullable = false, length = 50)
    public String getSkillTitle() {
        return skillTitle;
    }

    public void setSkillTitle(String skillTitle) {
        this.skillTitle = skillTitle;
    }

    @Basic
    @Column(name = "skill_approve_stat", nullable = false)
    public int getSkillApproveStat() {
        return skillApproveStat;
    }

    public void setSkillApproveStat(int skillApproveStat) {
        this.skillApproveStat = skillApproveStat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SkillEntity that = (SkillEntity) o;
        return skillId == that.skillId &&
                skillApproveStat == that.skillApproveStat &&
                Objects.equals(skillTitle, that.skillTitle);
    }

    @Override
    public int hashCode() {

        return Objects.hash(skillId, skillTitle, skillApproveStat);
    }

    @OneToMany(mappedBy = "skillsBySkillId")
    public Collection<JobSkillsRequiredEntity> getJobSkillsRequiredsBySkillId() {
        return jobSkillsRequiredsBySkillId;
    }

    public void setJobSkillsRequiredsBySkillId(Collection<JobSkillsRequiredEntity> jobSkillsRequiredsBySkillId) {
        this.jobSkillsRequiredsBySkillId = jobSkillsRequiredsBySkillId;
    }

    @OneToMany(mappedBy = "skillsBySkillId")
    public Collection<UserSkillsEntity> getUserSkillsBySkillId() {
        return userSkillsBySkillId;
    }

    public void setUserSkillsBySkillId(Collection<UserSkillsEntity> userSkillsBySkillId) {
        this.userSkillsBySkillId = userSkillsBySkillId;
    }
}
