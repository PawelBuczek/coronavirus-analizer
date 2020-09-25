package pl.sdacademy.coronavirus;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<CovidDataForDateAndCountryFromAPI> listOfCovidCountryStatus = ApiDataProvider.getListOfCovidCountryStatusFromJason("src/main/resources/covidData_25Sep_2020_sample.json");
            // example of getting the data out of the list
            System.out.println(listOfCovidCountryStatus.size());
            System.out.println(listOfCovidCountryStatus.get(2));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            List<CovidDataForDateAndCountryFromAPI> listOfCovidCountryStatus2 = ApiDataProvider.getListOfCovidCountryStatusFromJason();
            // example of getting the data out of the list
            System.out.println(listOfCovidCountryStatus2.size());
            System.out.println(listOfCovidCountryStatus2.get(3));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
