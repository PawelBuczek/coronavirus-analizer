package pl.sdacademy.coronavirus;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<CovidCountryStatus> listOfCovidCountryStatus = ApiDataProvider.getListOfCovidCountryStatusFromJason("src/main/resources/CovidCountryStatus.json");
            //example of getting the data out of the list
            System.out.println(listOfCovidCountryStatus.size());
            System.out.println(listOfCovidCountryStatus.get(2));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
