package pl.sdacademy.coronavirus;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class JdbcCovidDao implements CovidDao {
    //Utwórz implementację interfejsu CovidDao (DB3) o nazwie JdbcCovidDao.
// Implementacja korzysta bezpośrednio ze sterownika JDBC. Zaimplementuj metodę getCountries.
// Pozostałe metody zaimplementuj  w sposób zaślepkowy.


    private Connection connection;
public JdbcCovidDao(Connection connection) {
    this.connection = connection;
}



    @Override
    public List<Country> getCountries() throws SQLException {
        try (Statement statement = connection.createStatement()){
            try (ResultSet resultSet = statement.executeQuery("" +
                    " SELECT " +
                    " * " +
                    "FROM " +
                    " country")) {
            }
        } catch (SQLException e) {
            throw new RuntimeException("Brak danych z listy krajów");
        }

    }

    @Override
    public DateCountryCovidStatus getDataByCountryAndDateRange(Integer id, LocalDate startDate, LocalDate lastDate) {
        return null;
    }

    @Override
    public DateCountryCovidStatus getCurrentDataByCountry(Integer id) {
        return null;
    }

    @Override
    public DateCountryCovidStatus getCurrentWorldData() {
        return null;
    }

    @Override
    public void storeData(List<Country> countryList) {

    }
}
