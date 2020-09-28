package pl.sdacademy.coronavirus;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static Long casesBefore = 0L;
    private static Long deathsBefore = 0L;
    private static Long recoveredBefore = 0L;
    private static String countryBefore = "xyzSomething";

    public static void main(String[] args) {
        try {
            List<CovidDataForDateAndCountryFromAPI> listDataSample = ApiDataProvider.getListOfCovidCountryStatusFromJason("src/main/resources/covidData_25Sep_2020_sample.json");
            // example of getting the data out of the list
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

            // since we don't have all numbers in our dataset, I am calculating them here
            // I am also adding the Country (as Country object rather than String)
            System.out.println("Here be dragons:" + System.lineSeparator());
            Set<Country> countries = new HashSet<>();
            listDataFromAPI.forEach(covidRow -> countries.add(new Country(covidRow.getCountryName())));
            List<DateCountryCovidStatus> covidUpdates = new ArrayList<>();
            listDataFromAPI.forEach(
                    covidRow -> {
                        if (!countryBefore.equals(covidRow.getCountryName())) {
                            deathsBefore = 0L;
                            casesBefore = 0L;
                            recoveredBefore = 0L;
                            countryBefore = covidRow.getCountryName();
                        }
                        covidUpdates.add(
                                new DateCountryCovidStatus(
                                        countries.stream().filter(country -> country.getTwoLetterCode().equals(covidRow.getCountryName()))
                                                .findAny().orElse(null),
                                        covidRow.getDate(),
                                        covidRow.getTotalCases(),
                                        covidRow.getTotalDeaths(),
                                        // because that data we get from API is clearly not correct with those,
                                        // the below is making sure that the TotalRecovered number decreasing
                                        Math.max(recoveredBefore, covidRow.getTotalRecovered()),
                                        covidRow.getTotalCases() - casesBefore,
                                        covidRow.getTotalDeaths() - deathsBefore,
                                        covidRow.getTotalRecovered() - recoveredBefore
                                ));
                        casesBefore = covidRow.getTotalCases();
                        deathsBefore = covidRow.getTotalDeaths();
                        recoveredBefore = Math.max(recoveredBefore, covidRow.getTotalRecovered());
                    });
            //just to view some of the interesting days in order from US for example
            List<DateCountryCovidStatus> covidUpdatesUS = covidUpdates.stream()
                    .filter(covidUpdate -> covidUpdate.getCountry().getTwoLetterCode().equals("US"))
                    .collect(Collectors.toList());
            for (int i = 40; i < 65; i++) {
                System.out.println(covidUpdatesUS.get(i));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
