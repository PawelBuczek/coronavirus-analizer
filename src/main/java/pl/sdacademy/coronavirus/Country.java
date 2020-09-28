package pl.sdacademy.coronavirus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String twoLetterCode;
    private Long numberOfCitizens;

    public Country(String name, String twoLetterCode, Long numberOfCitizens) {
        this.name = name;
        this.twoLetterCode = twoLetterCode;
        this.numberOfCitizens = numberOfCitizens;
    }

    public Country(String twoLetterCode) {
        this.twoLetterCode = twoLetterCode;
    }

    public Country() {

    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTwoLetterCode() {
        return twoLetterCode;
    }

    public Long getNumberOfCitizens() {
        return numberOfCitizens;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(id, country.id) &&
                Objects.equals(name, country.name) &&
                Objects.equals(twoLetterCode, country.twoLetterCode) &&
                Objects.equals(numberOfCitizens, country.numberOfCitizens);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, twoLetterCode, numberOfCitizens);
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", twoLetterCode='" + twoLetterCode + '\'' +
                ", numberOfCitizens=" + numberOfCitizens +
                '}';
    }
}
