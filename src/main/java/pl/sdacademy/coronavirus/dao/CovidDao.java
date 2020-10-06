package pl.sdacademy.coronavirus.dao;

import pl.sdacademy.coronavirus.Country;
import pl.sdacademy.coronavirus.DateCountryCovidStatus;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface CovidDao {
    List<Country> getCountries() throws SQLException;
    List<DateCountryCovidStatus> getDataByCountryAndDateRange(Integer id, LocalDate startDate, LocalDate lastDate);
    List<DateCountryCovidStatus> getCurrentDataByCountry(Integer id);
    List<DateCountryCovidStatus> getCurrentWorldData();
    void storeData(List<DateCountryCovidStatus> countryList);
}

