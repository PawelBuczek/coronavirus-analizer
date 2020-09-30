package pl.sdacademy.coronavirus;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
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
            System.out.println(System.lineSeparator() + "check to get lines");
            List<DateCountryCovidStatus> dataRows = dao.getDataByCountryAndDateRange(
                    4,
                    LocalDate.of(2020,5,30),
                    LocalDate.of(2020,6,10)
            );
            dataRows.forEach(System.out::println);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
