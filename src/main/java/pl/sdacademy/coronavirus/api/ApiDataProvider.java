package pl.sdacademy.coronavirus.api;

import com.google.gson.Gson;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ApiDataProvider {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/dd/yy");

    @SuppressWarnings("SpellCheckingInspection")
    public static List<CovidDataForDateAndCountryFromAPI> getListOfCovidCountryStatusFromJason(String fileName) throws FileNotFoundException {
        Gson gson = new Gson();

        Map<String, List<Map<String, String>>> mapOfObjects = gson.fromJson(new FileReader(fileName), (Type) Object.class);
        List<Map<String, String>> objects = mapOfObjects.get("data");
        return objects.stream().map(mapObject -> new CovidDataForDateAndCountryFromAPI(
                        mapObject.get("countrycode"),
                        LocalDate.parse(mapObject.get("date"), formatter),
                        //necessary because of some errors in data sets taken from used API
                        Long.parseLong(mapObject.get("cases").equals("") ? "0" : mapObject.get("cases")),
                        Long.parseLong(mapObject.get("deaths").equals("") ? "0" : mapObject.get("deaths")),
                        Long.parseLong(mapObject.get("recovered").equals("") ? "0" : mapObject.get("recovered"))
                )).collect(Collectors.toList());
    }

    public static List<CovidDataForDateAndCountryFromAPI> getListOfCovidCountryStatusFromJason() throws IOException {
//        InputStream in = new URL("https://thevirustracker.com/timeline/map-data.json").openStream();
//        Files.copy(in, Paths.get("src/main/resources/data.json"), StandardCopyOption.REPLACE_EXISTING);
        CloseableHttpClient aDefault = HttpClients.createDefault();
        CloseableHttpResponse execute = aDefault.execute(new HttpGet("https://thevirustracker.com/timeline/2.json"));
        System.out.println(execute.getStatusLine().getStatusCode());
        InputStream in = execute.getEntity().getContent();
        Files.copy(in, Paths.get("src/main/resources/data.json"), StandardCopyOption.REPLACE_EXISTING);
        //        InputStream in = new URL("https://thevirustracker.com/timeline/2.json").openStream();
        return getListOfCovidCountryStatusFromJason("src/main/resources/data.json");
    }


}
