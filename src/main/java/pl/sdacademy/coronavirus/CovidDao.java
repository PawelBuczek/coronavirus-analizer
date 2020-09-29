package pl.sdacademy.coronavirus;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface CovidDao {
    List<Country> getCountries() throws SQLException;
    DateCountryCovidStatus getDataByCountryAndDateRange(Integer id, LocalDate startDate, LocalDate lastDate);
    DateCountryCovidStatus getCurrentDataByCountry(Integer id);
    DateCountryCovidStatus getCurrentWorldData();
    void storeData(List<Country> countryList);
}

