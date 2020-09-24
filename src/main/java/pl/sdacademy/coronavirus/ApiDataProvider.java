package pl.sdacademy.coronavirus;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ApiDataProvider {
    public static List<CovidCountryStatus> getListOfCovidCountryStatusFromJason(String fileName) throws FileNotFoundException {
        Gson gson = new Gson();
        List<CovidCountryStatus> listOfCovidCountryStatus = new ArrayList<>();

        List<Map<String, ?>> objects = gson.fromJson(new FileReader(fileName), (Type) Object.class);
        objects.forEach(mapObject -> listOfCovidCountryStatus.add(new CovidCountryStatus(
                (String) mapObject.get("country"),
                (String) mapObject.get("last_update"),
                (Double) mapObject.get("cases"),
                (Double) mapObject.get("deaths"),
                (Double) mapObject.get("recovered")
        )));
        return listOfCovidCountryStatus;
    }
    public static List<CovidCountryStatus> getListOfCovidCountryStatusFromJason() throws IOException {
        InputStream in = new URL("https://covid19-api.org/api/status").openStream();
        Files.copy(in, Paths.get("src/main/resources/data.json"), StandardCopyOption.REPLACE_EXISTING);
        return getListOfCovidCountryStatusFromJason("src/main/resources/data.json");
    }


}
