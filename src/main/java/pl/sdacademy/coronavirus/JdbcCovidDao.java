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
    Session session;

    public JdbcCovidDao(String yourPassword) throws SQLException {
        dataSource.setUser("root");
        dataSource.setPassword(yourPassword);
        dataSource.setDatabaseName("coronavirus-analizer");
        dataSource.setServerTimezone("UTC");
        connection = getDataSource().getConnection();
        preparedSelectAllFromCountries = connection.prepareStatement("SELECT * FROM `coronavirus-analizer`.country");
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        session = factory.openSession();
    }

    public MysqlDataSource getDataSource(){
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
    public List<DateCountryCovidStatus> getDataByCountryAndDateRange(Integer id, LocalDate startDate, LocalDate lastDate) {
        return null;
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
        Transaction transaction = session.beginTransaction();
        dataCountryCovidList.forEach(dataRow -> session.save(dataRow));
        Set<Country> countries = new HashSet<>();
        dataCountryCovidList.forEach(dataRow -> countries.add(dataRow.getCountry()));
        countries.forEach(country -> session.save(country));
        transaction.commit();
    }
}
