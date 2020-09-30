package pl.sdacademy.coronavirus;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcCovidDao implements CovidDao {
    private final MysqlDataSource dataSource = new MysqlDataSource();

    public JdbcCovidDao() throws SQLException {
        dataSource.setUser("root");
        dataSource.setPassword("Twoje hasło");
        dataSource.setDatabaseName("coronavirus-analizer");
        dataSource.setServerTimezone("UTC");
    }

    public MysqlDataSource getDataSource(){
        return dataSource;
    }

    @Override
    public List<Country> getCountries() {
//        try (Connection connection = getDataSource().getConnection()) {
//            PreparedStatement preparedStatement = connection.prepareStatement("SELECT DISTINCT * FROM `coronavirus-analizer`.country");
//            ResultSet resultSet = preparedStatement.executeQuery();
//            List<Country> countries = new ArrayList<>();
//            while (resultSet.next()) {
//                String fullName = resultSet.getString("name");
//                String shortName = resultSet.getString("twoLetterCode");
//                Long population = resultSet.getLong("numberOfCitizens");
//                countries.add(new Country(fullName, shortName, population));
//            }
//            return countries;
//        } catch (SQLException e) {
//            throw new RuntimeException("Błąd");
//        }
        return null;
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
    public void storeData(List<Country> countryList) {

    }
}
