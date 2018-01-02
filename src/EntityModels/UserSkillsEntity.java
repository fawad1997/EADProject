package EntityModels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "user_skills", schema = "ead", catalog = "")
public class UserSkillsEntity {
    private int usId;

    @Id
    @Column(name = "us_id")
    public int getUsId() {
        return usId;
    }

    public void setUsId(int usId) {
        this.usId = usId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserSkillsEntity that = (UserSkillsEntity) o;
        return usId == that.usId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(usId);
    }
}
