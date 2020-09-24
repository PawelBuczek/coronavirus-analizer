package pl.sdacademy.coronavirus;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<CovidCountryStatus> listOfCovidCountryStatus = null;
        try {
            listOfCovidCountryStatus = ApiDataProvider.getListOfCovidCountryStatusFromJason("src/main/resources/CovidCountryStatus.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //example of getting the data out of the list
        assert listOfCovidCountryStatus != null;
        System.out.println(listOfCovidCountryStatus.size());
        System.out.println(listOfCovidCountryStatus.get(2));
    }
}
