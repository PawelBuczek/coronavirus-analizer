package pl.sdacademy.coronavirus;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiDataProviderTest {
    private static List<CovidDataForDateAndCountryFromAPI> listOfCovidCountryStatus;

    @BeforeAll
    public static void beforeAll() throws FileNotFoundException {
        listOfCovidCountryStatus = ApiDataProvider.getListOfCovidCountryStatusFromJason("src/main/resources/covidData_25Sep_2020_sample.json");
    }

    @Test
    public void shouldReturnBR() {
        assertEquals("KR", listOfCovidCountryStatus.get(2).getName());
    }

    @Test
    public void shouldReturnCorrectDate() {
        assertEquals(LocalDate.of(2020,1,22), listOfCovidCountryStatus.get(3).getLastUpdate());
    }

    @Test
    public void shouldReturnCases777537() {
        assertEquals(1, listOfCovidCountryStatus.get(5).getCases());
    }

    @Test
    public void shouldReturnDeaths31568() {
        assertEquals(25, listOfCovidCountryStatus.get(6).getDeaths());
    }

    @Test
    public void shouldReturnRecovered598953() {
        assertEquals(36, listOfCovidCountryStatus.get(14).getRecovered());
    }

}
