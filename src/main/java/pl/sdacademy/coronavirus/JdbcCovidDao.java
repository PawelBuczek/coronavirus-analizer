package pl.sdacademy.coronavirus;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JdbcCovidDao implements CovidDao {
    private final MysqlDataSource dataSource = new MysqlDataSource();
    private final PreparedStatement preparedSaveCountry;
    private final PreparedStatement preparedSaveDateCountryCovidStatus;
    private final PreparedStatement preparedSelectAllFromCountries;
    private final PreparedStatement preparedSelectByCountryAndDateRange;
    private final PreparedStatement preparedSelectByCountry;


    public JdbcCovidDao(String yourPassword) throws SQLException {
        dataSource.setUser("root");
        dataSource.setPassword(yourPassword);
        dataSource.setDatabaseName("coronavirus-analizer");
        dataSource.setServerTimezone("UTC");
        Connection connection = getDataSource().getConnection();
        preparedSaveDateCountryCovidStatus = connection.prepareStatement(
                "INSERT INTO `coronavirus-analizer`.datecountrycovidstatus (activeCases, date, deathsOnThatDay, newCasesOnThatDay, recoveredOnThatDay, totalCases, totalDeaths, totalRecovered, country_id)" +
                        " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
        preparedSaveCountry = connection.prepareStatement(
                "INSERT INTO `coronavirus-analizer`.country (name, numberOfCitizens, twoLetterCode)"
                        + " VALUES(?, ?, ?)");
        preparedSelectAllFromCountries = connection.prepareStatement(
                "SELECT * FROM `coronavirus-analizer`.country");
        preparedSelectByCountryAndDateRange = connection.prepareStatement(
                "SELECT * FROM `coronavirus-analizer`.datecountrycovidstatus status LEFT JOIN `coronavirus-analizer`.country ON status.country_id = country.id" +
                        " WHERE status.country_id = ? AND status.date BETWEEN ? AND ?");
        preparedSelectByCountry = connection.prepareStatement(
                "SELECT * FROM `coronavirus-analizer`.datecountrycovidstatus status LEFT JOIN `coronavirus-analizer`.country ON status.country_id = country.id" +
                        " WHERE status.country_id = ?");
    }

    public MysqlDataSource getDataSource() {
        return dataSource;
    }

    @Override
    public List<Country> getCountries() {
        try {
            ResultSet resultSet = preparedSelectAllFromCountries.executeQuery();
            List<Country> countries = new ArrayList<>();
            while (resultSet.next()) {
                countries.add(new Country(
                        resultSet.getString("name"),
                        resultSet.getString("twoLetterCode"),
                        resultSet.getLong("numberOfCitizens")));
            }
            return countries;
        } catch (SQLException e) {
            throw new RuntimeException("Błąd");
        }
    }

    @Override
    public List<DateCountryCovidStatus> getDataByCountryAndDateRange(Integer countryId, LocalDate startDate, LocalDate lastDate) {
        try {
            preparedSelectByCountryAndDateRange.setInt(1, countryId);
            preparedSelectByCountryAndDateRange.setDate(2, java.sql.Date.valueOf(startDate));
            preparedSelectByCountryAndDateRange.setDate(3, java.sql.Date.valueOf(lastDate));
            return getListOfDataCountryCovidStatuses();
        } catch (SQLException e) {
            throw new RuntimeException("Błąd");
        }
    }

    @Override
    public List<DateCountryCovidStatus> getCurrentDataByCountry(Integer countryId) {
        try {
            preparedSelectByCountryAndDateRange.setInt(1, countryId);
            return getListOfDataCountryCovidStatuses();
        } catch (SQLException e) {
            throw new RuntimeException("Błąd");
        }
    }

    @Override
    public List<DateCountryCovidStatus> getCurrentWorldData() {
        return null;
    }

    @Override
    public void storeData(List<DateCountryCovidStatus> dataCountryCovidList) {
        Set<Country> countries = new HashSet<>();
        dataCountryCovidList.forEach(dataRow -> countries.add(dataRow.getCountry()));
        countries.forEach(this::storeCountry);
        dataCountryCovidList.forEach(this::storeDateCountryCovidStatus);
    }

    private void storeCountry(Country country) {
        try {
            preparedSaveCountry.setString(1, country.getName() == null ? "" : country.getName());
            preparedSaveCountry.setLong(2, country.getNumberOfCitizens() == null ? 0L : country.getNumberOfCitizens());
            preparedSaveCountry.setString(3, country.getTwoLetterCode() == null ? "" : country.getTwoLetterCode());
            preparedSaveCountry.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void storeDateCountryCovidStatus(DateCountryCovidStatus dataRow) {
        try {
            preparedSaveDateCountryCovidStatus.setLong(1, dataRow.getActiveCases());
            preparedSaveDateCountryCovidStatus.setDate(1, java.sql.Date.valueOf(dataRow.getDate()));
            preparedSaveDateCountryCovidStatus.setLong(1, dataRow.getDeathsOnThatDay());
            preparedSaveDateCountryCovidStatus.setLong(1, dataRow.getNewCasesOnThatDay());
            preparedSaveDateCountryCovidStatus.setLong(1, dataRow.getRecoveredOnThatDay());
            preparedSaveDateCountryCovidStatus.setLong(1, dataRow.getTotalCases());
            preparedSaveDateCountryCovidStatus.setLong(1, dataRow.getTotalDeaths());
            preparedSaveDateCountryCovidStatus.setLong(1, dataRow.getTotalRecovered());
            preparedSaveDateCountryCovidStatus.setLong(1, dataRow.getCountry().getId());
            preparedSaveDateCountryCovidStatus.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private List<DateCountryCovidStatus> getListOfDataCountryCovidStatuses() throws SQLException {
        ResultSet resultSet = preparedSelectByCountryAndDateRange.executeQuery();
        List<DateCountryCovidStatus> dataRows = new ArrayList<>();
        while (resultSet.next()) {
            dataRows.add(new DateCountryCovidStatus(
                    new Country(resultSet.getString("name"),
                            resultSet.getString("twoLetterCode"),
                            resultSet.getLong("numberOfCitizens")),
                    ((Date) resultSet.getObject("date")).toLocalDate(),
                    (Long) resultSet.getObject("totalCases"),
                    (Long) resultSet.getObject("totalDeaths"),
                    (Long) resultSet.getObject("totalRecovered"),
                    (Long) resultSet.getObject("newCasesOnThatDay"),
                    (Long) resultSet.getObject("deathsOnThatDay"),
                    (Long) resultSet.getObject("recoveredOnThatDay")
            ));
        }
        return dataRows;
    }
}
