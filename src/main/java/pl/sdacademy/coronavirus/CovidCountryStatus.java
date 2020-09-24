package pl.sdacademy.coronavirus;

import java.time.LocalDate;

public class CovidCountryStatus {
    private String name;
    private LocalDate date;
    private Long cases;
    private Long deaths;
    private Long recovered;

    public CovidCountryStatus(String name, LocalDate date, Long cases, Long deaths, Long recovered) {
        this.name = name;
        this.date = date;
        this.cases = cases;
        this.deaths = deaths;
        this.recovered = recovered;
    }

    public String getName() {
        return name;
    }

    public LocalDate getLastUpdate() {
        return date;
    }

    public Long getCases() {
        return cases;
    }

    public Long getDeaths() {
        return deaths;
    }

    public Long getRecovered() {
        return recovered;
    }

    @Override
    public String toString() {
        return "CovidCountryStatus{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", cases=" + cases +
                ", deaths=" + deaths +
                ", recovered=" + recovered +
                '}';
    }
}
