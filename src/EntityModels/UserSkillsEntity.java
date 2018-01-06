package EntityModels;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_skills")
public class UserSkillsEntity {
    private int usId;
//    private transient int userId;
//    private int skillId;
    private UserEntity usersByUserId;
    private SkillEntity skillsBySkillId;

    @Id
    @Column(name = "us_id", nullable = false)
    public int getUsId() {
        return usId;
    }

    public void setUsId(int usId) {
        this.usId = usId;
    }


//    public int getUserId() {
//        return userId;
//    }
//
//    public void setUserId(int userId) {
//        this.userId = userId;
//    }

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
        UserSkillsEntity that = (UserSkillsEntity) o;
        return usId == that.usId;
//                userId == that.userId &&
//                skillId == that.skillId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(usId);
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    public UserEntity getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(UserEntity usersByUserId) {
        this.usersByUserId = usersByUserId;
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
