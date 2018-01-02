package EntityModels;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "admin", schema = "ead", catalog = "")
public class AdminEntity {
    private int adminId;
    private String adminName;
    private String adminEmail;
    private String adminPassword;

    @Id
    @Column(name = "admin_id")
    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    @Basic
    @Column(name = "admin_name")
    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    @Basic
    @Column(name = "admin_email")
    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    @Basic
    @Column(name = "admin_password")
    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminEntity that = (AdminEntity) o;
        return adminId == that.adminId &&
                Objects.equals(adminName, that.adminName) &&
                Objects.equals(adminEmail, that.adminEmail) &&
                Objects.equals(adminPassword, that.adminPassword);
    }

    @Override
    public int hashCode() {

        return Objects.hash(adminId, adminName, adminEmail, adminPassword);
    }
}
