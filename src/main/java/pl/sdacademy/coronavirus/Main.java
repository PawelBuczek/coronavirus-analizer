package pl.sdacademy.coronavirus;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<CovidCountryStatus> listOfCovidCountryStatus = ApiDataProvider.getListOfCovidCountryStatusFromJason("src/main/resources/CovidCountryStatus.json");
            // example of getting the data out of the list
            System.out.println(listOfCovidCountryStatus.size());
            System.out.println(listOfCovidCountryStatus.get(2));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            List<CovidCountryStatus> listOfCovidCountryStatus2 = ApiDataProvider.getListOfCovidCountryStatusFromJason();
            // example of getting the data out of the list
            System.out.println(listOfCovidCountryStatus2.size());
            System.out.println(listOfCovidCountryStatus2.get(3));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
