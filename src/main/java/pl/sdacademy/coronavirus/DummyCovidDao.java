package pl.sdacademy.coronavirus;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class DummyCovidDao implements CovidDao {

    Country country1 = new Country("Poland", "PL", 38000000L);
    Country country2 = new Country("Portugal", "PR", 3802132300L);
    Country country3 = new Country("Peru", "PE", 31220L);
    List<Country> countryList = Arrays.asList(country1, country2, country3);


    @Override
    public List<Country> getCountries() {
        return countryList;
    }

    @Override
    public List<DateCountryCovidStatus> getDataByCountryAndDateRange(Integer id, LocalDate startDate, LocalDate lastDate) {
        return Arrays.asList(
                new DateCountryCovidStatus(country1, LocalDate.of(2020, 5, 12), 4324L, 435L, 1434L, 435L, 34L, 6L),
                new DateCountryCovidStatus(country1, LocalDate.of(2020, 7, 15), 4324L, 435L, 1434L, 435L, 34L, 6L),
                new DateCountryCovidStatus(country1, LocalDate.of(2020, 9, 21), 4324L, 435L, 1434L, 435L, 34L, 6L)


        );
    }

    @Override
    public List<DateCountryCovidStatus> getCurrentDataByCountry(Integer id) {
        return Arrays.asList(
        new DateCountryCovidStatus(country3, LocalDate.now(), 15L, 15L,25L,56L,77L,33L));
    }

    @Override
    public List<DateCountryCovidStatus> getCurrentWorldData() {
        return Arrays.asList(
                new DateCountryCovidStatus(country1, LocalDate.now(), 4325554L, 4352L, 14314L, 4353L, 34L, 61L),
                new DateCountryCovidStatus(country2, LocalDate.now(), 43242L, 4335L, 14324L, 4345L, 34L, 65L),
                new DateCountryCovidStatus(country3, LocalDate.now(), 43124L, 4335L, 11434L, 4365L, 34L, 622L));
    }

    @Override
    public void storeData(List<DateCountryCovidStatus> countryList) {

    }
}

