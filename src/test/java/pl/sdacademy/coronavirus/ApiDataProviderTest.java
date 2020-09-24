package pl.sdacademy.coronavirus;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiDataProviderTest {
    private static List<CovidCountryStatus> listOfCovidCountryStatus;

    @BeforeAll
    public static void beforeAll() throws FileNotFoundException {
        listOfCovidCountryStatus = ApiDataProvider.getListOfCovidCountryStatusFromJason("src/main/resources/CovidCountryStatus.json");
    }

    @Test
    public void shouldReturnBR() {
        assertEquals(listOfCovidCountryStatus.get(2).getName(),"BR");
    }

    @Test
    public void shouldReturnCorrectDate() {
        assertEquals(listOfCovidCountryStatus.get(3).getLastUpdate(), LocalDateTime.of(2020,9,23,16,23,32));
        //"2020-09-23T16:23:32"
    }

    @Test
    public void shouldReturnCases777537() {
        assertEquals(listOfCovidCountryStatus.get(4).getCases(),777537);
    }

    @Test
    public void shouldReturnDeaths31568() {
        assertEquals(listOfCovidCountryStatus.get(5).getDeaths(),31568);
    }

    @Test
    public void shouldReturnRecovered598953() {
        assertEquals(listOfCovidCountryStatus.get(6).getRecovered(),598953);
    }

}
