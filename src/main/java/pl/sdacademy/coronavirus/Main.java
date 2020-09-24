package pl.sdacademy.coronavirus;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new Gson();
        List<CovidCountryStatus> listOfCovidCountryStatus = new ArrayList<>();

        List<Map<String, ?>> objects = gson.fromJson(new FileReader("CovidCountryStatus.json"), (Type) Object.class);
        objects.forEach(mapObject -> listOfCovidCountryStatus.add(new CovidCountryStatus(
                (String) mapObject.get("country"),
                (String) mapObject.get("last_update"),
                (Double) mapObject.get("cases"),
                (Double) mapObject.get("deaths"),
                (Double) mapObject.get("recovered")
        )));
        //example of getting the data out of the list
        System.out.println(listOfCovidCountryStatus.get(2));




    }
}
