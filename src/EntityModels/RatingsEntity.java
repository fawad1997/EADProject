package EntityModels;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "ratings")
public class RatingsEntity {
    private int rateId;
    private int rateTo;
    private int rateFrom;
    private BigDecimal ratePoints;
    private String rateDetails;
    private UsersEntity usersByRateTo;

    @Id
    @Column(name = "rate_id", nullable = false)
    public int getRateId() {
        return rateId;
    }

    public void setRateId(int rateId) {
        this.rateId = rateId;
    }

//    @Basic
//    @Column(name = "rate_to", nullable = false)
//    public int getRateTo() {
//        return rateTo;
//    }
//
//    public void setRateTo(int rateTo) {
//        this.rateTo = rateTo;
//    }

    @Basic
    @Column(name = "rate_from", nullable = false)
    public int getRateFrom() {
        return rateFrom;
    }

    public void setRateFrom(int rateFrom) {
        this.rateFrom = rateFrom;
    }

    @Basic
    @Column(name = "rate_points", nullable = false, precision = 2)
    public BigDecimal getRatePoints() {
        return ratePoints;
    }

    public void setRatePoints(BigDecimal ratePoints) {
        this.ratePoints = ratePoints;
    }

    @Basic
    @Column(name = "rate_details", nullable = true, length = 200)
    public String getRateDetails() {
        return rateDetails;
    }

    public void setRateDetails(String rateDetails) {
        this.rateDetails = rateDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RatingsEntity that = (RatingsEntity) o;
        return rateId == that.rateId &&
                rateTo == that.rateTo &&
                rateFrom == that.rateFrom &&
                Objects.equals(ratePoints, that.ratePoints) &&
                Objects.equals(rateDetails, that.rateDetails);
    }

    @Override
    public int hashCode() {

        return Objects.hash(rateId, rateTo, rateFrom, ratePoints, rateDetails);
    }

    @ManyToOne
    @JoinColumn(name = "rate_to", referencedColumnName = "user_id", nullable = false)
    public UsersEntity getUsersByRateTo() {
        return usersByRateTo;
    }

    public void setUsersByRateTo(UsersEntity usersByRateTo) {
        this.usersByRateTo = usersByRateTo;
    }
}
