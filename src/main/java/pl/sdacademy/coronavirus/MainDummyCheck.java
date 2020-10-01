package pl.sdacademy.coronavirus;

import org.hibernate.cfg.Configuration;
import java.time.LocalDate;
import java.util.List;

public class MainDummyCheck {
    public static void main(String[] args) {
        //just to make our beloved hibernate do all the work for our testing purposes
        //.cfg.xml file should be set as "create-drop for this
        new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        System.out.println("DummyCovidDao test");
        DummyCovidDao dao = new DummyCovidDao();
        List<Country> countries = dao.getCountries();
        System.out.println(countries.get(2));
        System.out.println(countries.get(1));

        System.out.println(System.lineSeparator() + "check to get lines");
        List<DateCountryCovidStatus> dataRows = dao.getDataByCountryAndDateRange(
                4,
                LocalDate.of(2020,5,15),
                LocalDate.of(2020,7,10)
        );
        dataRows.forEach(System.out::println);

        List<DateCountryCovidStatus> dataRowsCountryCurrent = dao.getCurrentDataByCountry(67);
        System.out.println(System.lineSeparator() + "check of getCurrentDataByCountry");
        dataRowsCountryCurrent.forEach(System.out::println);


    }
}
