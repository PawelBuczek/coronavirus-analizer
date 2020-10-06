package pl.sdacademy.coronavirus.dao;

import com.mysql.cj.jdbc.MysqlDataSource;
import pl.sdacademy.coronavirus.Country;
import pl.sdacademy.coronavirus.DateCountryCovidStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class DbCovidDao implements CovidDao {
    private final MysqlDataSource dataSource = new MysqlDataSource();

    public DbCovidDao(String yourPassword) throws SQLException {
        dataSource.setUser("root");
        dataSource.setPassword(yourPassword);
        dataSource.setDatabaseName("coronavirus-analizer");
        dataSource.setServerTimezone("UTC");
        Connection connection = getDataSource().getConnection();
    }

    public MysqlDataSource getDataSource() {
        return dataSource;
    }

    @Override
    public List<Country> getCountries() {
        return null;
    }

    @Override
    public List<DateCountryCovidStatus> getDataByCountryAndDateRange(Integer countryId, LocalDate startDate, LocalDate lastDate) {
        return null;
    }

    @Override
    public List<DateCountryCovidStatus> getCurrentDataByCountry(Integer countryId) {
        return null;
    }

    private List<DateCountryCovidStatus> getDateCountryCovidStatuses(PreparedStatement preparedStatement) throws SQLException {
        return null;
    }

    @Override
    public List<DateCountryCovidStatus> getCurrentWorldData() {
        return null;
    }

    @Override
    public void storeData(List<DateCountryCovidStatus> dataCountryCovidList) {

    }

}

