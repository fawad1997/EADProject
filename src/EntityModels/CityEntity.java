package EntityModels;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "city")
public class CityEntity {
    private int cityId;
    private String cityName;
//    private int countryId;
    private CountryEntity countryByCountryId;
//    private UsersEntity usersByCountryId;

    @Id
    @Column(name = "city_id", nullable = false)
    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Basic
    @Column(name = "city_name", nullable = false, length = 50)
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

//    @Basic
//    @Column(name = "country_id", nullable = false)
//    public int getCountryId() {
//        return countryId;
//    }
//
//    public void setCountryId(int countryId) {
//        this.countryId = countryId;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityEntity that = (CityEntity) o;
        return cityId == that.cityId &&
//                countryId == that.countryId &&
                Objects.equals(cityName, that.cityName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(cityId, cityName);
    }

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "country_id", nullable = false)
    public CountryEntity getCountryByCountryId() {
        return countryByCountryId;
    }

    public void setCountryByCountryId(CountryEntity countryByCountryId) {
        this.countryByCountryId = countryByCountryId;
    }

//    @ManyToOne
//    @JoinColumn(name = "country_id", referencedColumnName = "city_id", nullable = false)
//    public UsersEntity getUsersByCountryId() {
//        return usersByCountryId;
//    }
//
//    public void setUsersByCountryId(UsersEntity usersByCountryId) {
//        this.usersByCountryId = usersByCountryId;
//    }
}
