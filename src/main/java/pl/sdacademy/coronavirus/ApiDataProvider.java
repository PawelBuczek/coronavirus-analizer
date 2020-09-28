package pl.sdacademy.coronavirus;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ApiDataProvider {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/dd/yy");

    @SuppressWarnings("SpellCheckingInspection")
    public static List<CovidDataForDateAndCountryFromAPI> getListOfCovidCountryStatusFromJason(String fileName) throws FileNotFoundException {
        Gson gson = new Gson();
        List<CovidDataForDateAndCountryFromAPI> listOfCovidCountryStatus = new ArrayList<>();

        Map<String, List<Map<String, String>>> mapOfObjects = gson.fromJson(new FileReader(fileName), (Type) Object.class);
        List<Map<String, String>> objects = mapOfObjects.get("data");
        objects.forEach(mapObject ->
                listOfCovidCountryStatus.add(new CovidDataForDateAndCountryFromAPI(
                        mapObject.get("countrycode"),
                        LocalDate.parse(mapObject.get("date"), formatter),
                        //necessary because of some errors in data sets taken from used API
                        Long.parseLong(mapObject.get("cases").equals("") ? "0" : mapObject.get("cases")),
                        Long.parseLong(mapObject.get("deaths").equals("") ? "0" : mapObject.get("deaths")),
                        Long.parseLong(mapObject.get("recovered").equals("") ? "0" : mapObject.get("recovered"))
                )));
        return listOfCovidCountryStatus;
    }

    public static List<CovidDataForDateAndCountryFromAPI> getListOfCovidCountryStatusFromJason() throws IOException {
        InputStream in = new URL("https://thevirustracker.com/timeline/map-data.json").openStream();
        Files.copy(in, Paths.get("src/main/resources/data.json"), StandardCopyOption.REPLACE_EXISTING);
        return getListOfCovidCountryStatusFromJason("src/main/resources/data.json");
    }


}
