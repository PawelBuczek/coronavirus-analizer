package pl.sdacademy.coronavirus;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static Long deathsBefore = 0L;
    private static String countryBefore = "xyzSomething";

    public static void main(String[] args) {
        try {
            List<CovidDataForDateAndCountryFromAPI> listDataSample = ApiDataProvider.getListOfCovidCountryStatusFromJason("src/main/resources/covidData_25Sep_2020_sample.json");
            // example of getting the data out of the list
            System.out.println(listDataSample.size());
            System.out.println(listDataSample.get(2));
            System.out.println(listDataSample.get(1567));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            List<CovidDataForDateAndCountryFromAPI> listDataFromAPI = ApiDataProvider.getListOfCovidCountryStatusFromJason();
            listDataFromAPI.sort(Comparator.comparing(CovidDataForDateAndCountryFromAPI::getDate));
            listDataFromAPI.sort(Comparator.comparing(CovidDataForDateAndCountryFromAPI::getCountryName));
            // example of getting the data out of the list
            System.out.println(listDataFromAPI.size());
            System.out.println(listDataFromAPI.get(3));
            //creating lists of countries and data rows
            System.out.println("Here be dragons:" + System.lineSeparator());
            Set<Country> countries = new HashSet<>();
            listDataFromAPI.forEach(covidRow -> countries.add(new Country(covidRow.getCountryName())));
            List<DateCountryCovidStatus> covidUpdates = new ArrayList<>();
            listDataFromAPI.forEach(
                    covidRow -> {
                        if (!countryBefore.equals(covidRow.getCountryName())) {
                            deathsBefore = 0L;
                            countryBefore = covidRow.getCountryName();
                        }
//                        if (covidRow.getTotalRecovered() != 0L) {
//                            System.out.println(covidRow.getTotalRecovered());
//                        }
                        covidUpdates.add(
                                new DateCountryCovidStatus(
                                        countries.stream().filter(country -> country.getTwoLetterCode().equals(covidRow.getCountryName()))
                                                .findAny().orElse(null),
                                        covidRow.getDate(),
                                        covidRow.getTotalCases(),
                                        covidRow.getTotalDeaths(),
                                        covidRow.getTotalRecovered(),
                                        covidRow.getTotalDeaths() - deathsBefore
                                ));
                        deathsBefore = covidRow.getTotalDeaths();
                    });
            List<DateCountryCovidStatus> covidUpdatesUS = covidUpdates.stream()
                    .filter(covidUpdate -> covidUpdate.getCountry().getTwoLetterCode().equals("US"))
                    .collect(Collectors.toList());
            System.out.println(covidUpdatesUS.get(0));
            System.out.println(covidUpdatesUS.get(1));
            System.out.println(System.lineSeparator());
            for (int i = 40; i < 55; i++) {
                System.out.println(covidUpdatesUS.get(i));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
