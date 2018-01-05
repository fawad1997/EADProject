package EntityModels;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_phoneno")
public class UserPhonenoEntity {
    private int userPhoneId;
    private String phoneNo;
//    private int userId;
    private UsersEntity usersByUserId;

    @Id
    @Column(name = "user_phone_id", nullable = false)
    public int getUserPhoneId() {
        return userPhoneId;
    }

    public void setUserPhoneId(int userPhoneId) {
        this.userPhoneId = userPhoneId;
    }

    @Basic
    @Column(name = "phone_no", nullable = false, length = 20)
    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPhonenoEntity that = (UserPhonenoEntity) o;
        return userPhoneId == that.userPhoneId &&
//                userId == that.userId &&
                Objects.equals(phoneNo, that.phoneNo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userPhoneId, phoneNo);
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    public UsersEntity getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(UsersEntity usersByUserId) {
        this.usersByUserId = usersByUserId;
    }
}
