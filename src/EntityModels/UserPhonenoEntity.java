package EntityModels;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_phoneno", schema = "ead", catalog = "")
public class UserPhonenoEntity {
    private int userPhoneId;
    private String phoneNo;

    @Id
    @Column(name = "user_phone_id")
    public int getUserPhoneId() {
        return userPhoneId;
    }

    public void setUserPhoneId(int userPhoneId) {
        this.userPhoneId = userPhoneId;
    }

    @Basic
    @Column(name = "phone_no")
    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPhonenoEntity that = (UserPhonenoEntity) o;
        return userPhoneId == that.userPhoneId &&
                Objects.equals(phoneNo, that.phoneNo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userPhoneId, phoneNo);
    }
}
