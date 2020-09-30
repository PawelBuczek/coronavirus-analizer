package pl.sdacademy.weather;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Double temperatureCelsius;
    Double cloudCover;
    Double windSpeedKmPerH;

    public Weather(Double temperatureKelvin, Double cloudCover, Double windSpeed) {
        this.temperatureCelsius = temperatureKelvin;
        this.cloudCover = cloudCover;
        this.windSpeedKmPerH = windSpeed;
    }

    public Weather() {
    }

    public Integer getId() {
        return id;
    }


    public void setTemperatureCelsius(Double temperatureCelsius) {
        this.temperatureCelsius = temperatureCelsius;
    }

    public void setCloudCover(Double cloudCover) {
        this.cloudCover = cloudCover;
    }

    public void setWindSpeedKmPerH(Double windSpeedKmPerH) {
        this.windSpeedKmPerH = windSpeedKmPerH;
    }

    public Double getTemperatureCelsius() {
        return temperatureCelsius;
    }

    public Double getCloudCover() {
        return cloudCover;
    }

    public Double getWindSpeedKmPerH() {
        return windSpeedKmPerH;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", temperatureCelsius=" + temperatureCelsius +
                ", cloudCover=" + cloudCover +
                ", windSpeedKmPerH=" + windSpeedKmPerH +
                '}';
    }
}
