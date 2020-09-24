package pl.sdacademy.coronavirus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CovidCountryStatus {
    private String name;
    private LocalDateTime lastUpdate;
    private Double cases;
    private Double deaths;
    private Double recovered;

    public CovidCountryStatus(String name, String lastUpdate, Double cases, Double deaths, Double recovered) {
        this.name = name;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        this.lastUpdate =  LocalDateTime.parse(lastUpdate, formatter);
        this.cases = cases;
        this.deaths = deaths;
        this.recovered = recovered;
    }

    public CovidCountryStatus(String name, LocalDateTime lastUpdate, Double cases, Double deaths, Double recovered) {
        this.name = name;
        this.lastUpdate = lastUpdate;
        this.cases = cases;
        this.deaths = deaths;
        this.recovered = recovered;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public Double getCases() {
        return cases;
    }

    public Double getDeaths() {
        return deaths;
    }

    public Double getRecovered() {
        return recovered;
    }

    @Override
    public String toString() {
        return "CovidCountryStatus{" +
                "name='" + name + '\'' +
                ", lastUpdate=" + lastUpdate +
                ", cases=" + cases +
                ", deaths=" + deaths +
                ", recovered=" + recovered +
                '}';
    }
}
