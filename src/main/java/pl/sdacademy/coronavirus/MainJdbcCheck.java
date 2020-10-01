package pl.sdacademy.coronavirus;

import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class MainJdbcCheck {
    public static void main(String[] args) {
        //just to make our beloved hibernate do all the work for our testing purposes
        //.cfg.xml file should be set as "create-drop for this
        new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        System.out.println("this takes way too long for now (around 3 long minutes)");
        try {
            List<CovidDataForDateAndCountryFromAPI> listDataFromAPI = ApiDataProvider.getListOfCovidCountryStatusFromJason("src/main/resources/covidData_25Sep_2020_sample.json");
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

            List<DateCountryCovidStatus> dataRowsCountryCurrent = dao.getCurrentDataByCountry(67);
            System.out.println(System.lineSeparator() + "check of getCurrentDataByCountry");
            dataRowsCountryCurrent.forEach(System.out::println);

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }


    }
}
