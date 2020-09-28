package pl.sdacademy.coronavirus;

import java.time.LocalDate;
import java.util.List;

public interface CovidDao {
    List<Country> getCountries();
    DateCountryCovidStatus getDataByCountryAndDateRange(Integer id, LocalDate startDate, LocalDate lastDate);
    DateCountryCovidStatus getCurrentDataByCountry(Integer id);
    DateCountryCovidStatus getCurrentWorldDate();
    void storeData();
}

