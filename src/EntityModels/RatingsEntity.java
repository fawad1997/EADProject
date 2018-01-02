package EntityModels;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "ratings", schema = "ead", catalog = "")
public class RatingsEntity {
    private int rateId;
    private BigDecimal ratePoints;
    private String rateDetails;

    @Id
    @Column(name = "rate_id")
    public int getRateId() {
        return rateId;
    }

    public void setRateId(int rateId) {
        this.rateId = rateId;
    }

    @Basic
    @Column(name = "rate_points")
    public BigDecimal getRatePoints() {
        return ratePoints;
    }

    public void setRatePoints(BigDecimal ratePoints) {
        this.ratePoints = ratePoints;
    }

    @Basic
    @Column(name = "rate_details")
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
                Objects.equals(ratePoints, that.ratePoints) &&
                Objects.equals(rateDetails, that.rateDetails);
    }

    @Override
    public int hashCode() {

        return Objects.hash(rateId, ratePoints, rateDetails);
    }
}
