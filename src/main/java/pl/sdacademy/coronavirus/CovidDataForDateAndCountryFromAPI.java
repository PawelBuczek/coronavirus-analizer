package pl.sdacademy.coronavirus;

import java.time.LocalDate;

public class CovidDataForDateAndCountryFromAPI {
    private String country;
    private LocalDate date;
    private Long totalCases;
    private Long totalDeaths;
    private Long totalRecovered;

    public CovidDataForDateAndCountryFromAPI(String country, LocalDate date, Long totalCases, Long totalDeaths, Long totalRecovered) {
        this.country = country;
        this.date = date;
        this.totalCases = totalCases;
        this.totalDeaths = totalDeaths;
        this.totalRecovered = totalRecovered;
    }

    public String getCountryName() {
        return country;
    }

    public LocalDate getDate() {
        return date;
    }

    public Long getTotalCases() {
        return totalCases;
    }

    public Long getTotalDeaths() {
        return totalDeaths;
    }

    public Long getTotalRecovered() {
        return totalRecovered;
    }

    @Override
    public String toString() {
        return "CovidCountryStatus{" +
                "country='" + country + '\'' +
                ", date=" + date +
                ", totalCases=" + totalCases +
                ", totalDeaths=" + totalDeaths +
                ", totalRecovered=" + totalRecovered +
                '}';
    }
}
