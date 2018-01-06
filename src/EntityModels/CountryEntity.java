package EntityModels;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "country")
public class CountryEntity {
    private int countryId;
    private String countryName;
    private Collection<CityEntity> citiesByCountryId;
    private Collection<UserEntity> usersByCountryId;

    @Id
    @Column(name = "country_id", nullable = false)
    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    @Basic
    @Column(name = "country_name", nullable = false, length = 50)
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryEntity that = (CountryEntity) o;
        return countryId == that.countryId &&
                Objects.equals(countryName, that.countryName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(countryId, countryName);
    }

    @OneToMany(mappedBy = "countryByCountryId")
    public Collection<CityEntity> getCitiesByCountryId() {
        return citiesByCountryId;
    }

    public void setCitiesByCountryId(Collection<CityEntity> citiesByCountryId) {
        this.citiesByCountryId = citiesByCountryId;
    }

    @OneToMany(mappedBy = "countryByCountryId")
    public Collection<UserEntity> getUsersByCountryId() {
        return usersByCountryId;
    }

    public void setUsersByCountryId(Collection<UserEntity> usersByCountryId) {
        this.usersByCountryId = usersByCountryId;
    }
}
