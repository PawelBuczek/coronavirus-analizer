package pl.sdacademy.coronavirus;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JdbcCovidDao implements CovidDao {
    private final MysqlDataSource dataSource = new MysqlDataSource();
    private final Connection connection;
    PreparedStatement preparedSelectAllFromCountries;
    PreparedStatement preparedSelectByCountryAndDateRange;
    Session session;

    public JdbcCovidDao(String yourPassword) throws SQLException {
        dataSource.setUser("root");
        dataSource.setPassword(yourPassword);
        dataSource.setDatabaseName("coronavirus-analizer");
        dataSource.setServerTimezone("UTC");
        connection = getDataSource().getConnection();
        preparedSelectAllFromCountries = connection.prepareStatement(
                "SELECT * FROM `coronavirus-analizer`.country");
        preparedSelectByCountryAndDateRange = connection.prepareStatement(
                "SELECT * FROM `coronavirus-analizer`.datecountrycovidstatus status LEFT JOIN `coronavirus-analizer`.country ON status.country_id = country.id" +
                        " WHERE status.country_id = ? AND status.date BETWEEN ? AND ?");
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        session = factory.openSession();
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
            ResultSet resultSet = preparedSelectByCountryAndDateRange.executeQuery();
            List<DateCountryCovidStatus> dataRows = new ArrayList<>();
            while (resultSet.next()) {
                dataRows.add(new DateCountryCovidStatus(
                        new Country(resultSet.getString("name"),
                                resultSet.getString("twoLetterCode"),
                                resultSet.getLong("numberOfCitizens")),
                        ((java.sql.Date) resultSet.getObject("date")).toLocalDate(),
                        (Long) resultSet.getObject("totalCases"),
                        (Long) resultSet.getObject("totalDeaths"),
                        (Long) resultSet.getObject("totalRecovered"),
                        (Long) resultSet.getObject("newCasesOnThatDay"),
                        (Long) resultSet.getObject("deathsOnThatDay"),
                        (Long) resultSet.getObject("recoveredOnThatDay")
                ));
            }
            return dataRows;
        } catch (SQLException e) {
            throw new RuntimeException("Błąd");
        }
    }

    @Override
    public List<DateCountryCovidStatus> getCurrentDataByCountry(Integer id) {
        return null;
    }

    @Override
    public List<DateCountryCovidStatus> getCurrentWorldData() {
        return null;
    }

    @Override
    public void storeData(List<DateCountryCovidStatus> dataCountryCovidList) {
        Set<Country> countries = new HashSet<>();
        dataCountryCovidList.forEach(dataRow -> countries.add(dataRow.getCountry()));
        Transaction transaction = session.beginTransaction();
        countries.forEach(country -> session.save(country));
        dataCountryCovidList.forEach(dataRow -> session.save(dataRow));
        transaction.commit();
    }
}
