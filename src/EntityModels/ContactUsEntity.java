package EntityModels;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "contact_us", schema = "ead", catalog = "")
public class ContactUsEntity {
    private int csId;
    private int csType;
    private String csSubject;
    private String csBody;
    private String csEmail;
    private Timestamp csTime;

    @Id
    @Column(name = "cs_id")
    public int getCsId() {
        return csId;
    }

    public void setCsId(int csId) {
        this.csId = csId;
    }

    @Basic
    @Column(name = "cs_type")
    public int getCsType() {
        return csType;
    }

    public void setCsType(int csType) {
        this.csType = csType;
    }

    @Basic
    @Column(name = "cs_subject")
    public String getCsSubject() {
        return csSubject;
    }

    public void setCsSubject(String csSubject) {
        this.csSubject = csSubject;
    }

    @Basic
    @Column(name = "cs_body")
    public String getCsBody() {
        return csBody;
    }

    public void setCsBody(String csBody) {
        this.csBody = csBody;
    }

    @Basic
    @Column(name = "cs_email")
    public String getCsEmail() {
        return csEmail;
    }

    public void setCsEmail(String csEmail) {
        this.csEmail = csEmail;
    }

    @Basic
    @Column(name = "cs_time")
    public Timestamp getCsTime() {
        return csTime;
    }

    public void setCsTime(Timestamp csTime) {
        this.csTime = csTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactUsEntity that = (ContactUsEntity) o;
        return csId == that.csId &&
                csType == that.csType &&
                Objects.equals(csSubject, that.csSubject) &&
                Objects.equals(csBody, that.csBody) &&
                Objects.equals(csEmail, that.csEmail) &&
                Objects.equals(csTime, that.csTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(csId, csType, csSubject, csBody, csEmail, csTime);
    }
}
