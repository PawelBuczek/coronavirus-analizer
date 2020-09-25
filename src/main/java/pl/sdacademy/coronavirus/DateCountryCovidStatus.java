package pl.sdacademy.coronavirus;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class DateCountryCovidStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Country country;
    private LocalDate date;
    private Long totalCases;
    private Long totalDeaths;
    private Long totalRecovered;
    private Long activeCases;
    private Long deathsOnThatDay;

    public DateCountryCovidStatus(Country country, LocalDate date, Long totalCases, Long totalDeaths, Long totalRecovered, Long deathsOnThatDay) {
        this.country = country;
        this.date = date;
        this.totalCases = totalCases;
        this.totalDeaths = totalDeaths;
        this.totalRecovered = totalRecovered;
        this.activeCases = totalCases - (totalRecovered + totalDeaths);
        this.deathsOnThatDay = deathsOnThatDay;
    }

    public DateCountryCovidStatus() {

    }

    public Integer getId() {
        return id;
    }

    public Country getCountry() {
        return country;
    }

    public LocalDate getDate() {
        return date;
    }

    public Long getTotalCases() {
        return totalCases;
    }

    public Long getTotalRecovered() {
        return totalRecovered;
    }

    public Long getTotalDeaths() {
        return totalDeaths;
    }

    public Long getActiveCases() {
        return activeCases;
    }

    public Long getDeathsOnThatDay() {
        return deathsOnThatDay;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateCountryCovidStatus that = (DateCountryCovidStatus) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(country, that.country) &&
                Objects.equals(date, that.date) &&
                Objects.equals(totalCases, that.totalCases) &&
                Objects.equals(totalRecovered, that.totalRecovered) &&
                Objects.equals(totalDeaths, that.totalDeaths) &&
                Objects.equals(activeCases, that.activeCases) &&
                Objects.equals(deathsOnThatDay, that.deathsOnThatDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, date, totalCases, totalRecovered, totalDeaths, activeCases, deathsOnThatDay);
    }

    @Override
    public String toString() {
        return "DateCountryCovidStatus{" +
                "id=" + id +
                ", country=" + country +
                ", date=" + date +
                ", totalCases=" + totalCases +
                ", totalDeaths=" + totalDeaths +
                ", totalRecovered=" + totalRecovered +
                ", activeCases=" + activeCases +
                ", deathsOnThatDay=" + deathsOnThatDay +
                '}';
    }
}
