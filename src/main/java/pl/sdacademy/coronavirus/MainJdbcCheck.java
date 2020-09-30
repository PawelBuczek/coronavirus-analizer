package pl.sdacademy.coronavirus;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class MainJdbcCheck {
    public static void main(String[] args) {
        try {
            List<CovidDataForDateAndCountryFromAPI> listDataFromAPI = ApiDataProvider.getListOfCovidCountryStatusFromJason();
            JdbcCovidDao dao = new JdbcCovidDao("password");
            ApiObjectToEntityMapper mapper = new ApiObjectToEntityMapper();
            dao.storeData(mapper.map(listDataFromAPI));
            List<Country> countries = dao.getCountries();
            System.out.println(countries.get(3));
            System.out.println(countries.get(7));
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
