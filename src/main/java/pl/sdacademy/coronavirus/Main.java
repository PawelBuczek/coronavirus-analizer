package pl.sdacademy.coronavirus;

import com.google.gson.Gson;
import pl.sdacademy.utils.DateUtils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new Gson();
        List<CovidCountryStatus> listOfCovidCountryStatus = new ArrayList<>();

        List<Map<String, ?>> objects = gson.fromJson(new FileReader("src/main/resources/CovidCountryStatus.json"), (Type) Object.class);
        objects.forEach(mapObject -> listOfCovidCountryStatus.add(new CovidCountryStatus(
                (String) mapObject.get("country"),
                (String) mapObject.get("last_update"),
                (Double) mapObject.get("cases"),
                (Double) mapObject.get("deaths"),
                (Double) mapObject.get("recovered")
        )));
        //example of getting the data out of the list
        System.out.println(listOfCovidCountryStatus.get(2));

        DateUtils dateUtils = new DateUtils();
        List<LocalDate> listOfDates = new ArrayList<>();
        listOfDates.add(LocalDate.of(1993,11,15));
        listOfDates.add(LocalDate.of(1993,11,15));
        listOfDates.add(LocalDate.of(1993,11,15));
        System.out.println(dateUtils.datesMissing(listOfDates));


    }
}
