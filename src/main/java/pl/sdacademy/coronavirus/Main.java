package pl.sdacademy.coronavirus;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws SQLException {
        LocalDate df;
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        Session session = factory.openSession();
        try {
            List<CovidDataForDateAndCountryFromAPI> listDataSample = ApiDataProvider.getListOfCovidCountryStatusFromJason("src/main/resources/covidData_25Sep_2020_sample.json");
            // example of getting the data out of the list
            System.out.println(listDataSample.get(2));
            System.out.println(listDataSample.get(1567));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("second quick test:" + System.lineSeparator());
        ApiObjectToEntityMapper mapper = new ApiObjectToEntityMapper();
        try {
            List<CovidDataForDateAndCountryFromAPI> listDataFromAPI = ApiDataProvider.getListOfCovidCountryStatusFromJason();
            List<DateCountryCovidStatus> mappedList = mapper.map(listDataFromAPI);
            for (int i = 1928; i < 1948; i++) {
                System.out.println(mappedList.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
