package EntityModels;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "skills", schema = "ead", catalog = "")
public class SkillsEntity {
    private int skillId;
    private String skillTitle;
    private int skillApproveStat;

    @Id
    @Column(name = "skill_id")
    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    @Basic
    @Column(name = "skill_title")
    public String getSkillTitle() {
        return skillTitle;
    }

    public void setSkillTitle(String skillTitle) {
        this.skillTitle = skillTitle;
    }

    @Basic
    @Column(name = "skill_approve_stat")
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
        SkillsEntity that = (SkillsEntity) o;
        return skillId == that.skillId &&
                skillApproveStat == that.skillApproveStat &&
                Objects.equals(skillTitle, that.skillTitle);
    }

    @Override
    public int hashCode() {

        return Objects.hash(skillId, skillTitle, skillApproveStat);
    }
}
