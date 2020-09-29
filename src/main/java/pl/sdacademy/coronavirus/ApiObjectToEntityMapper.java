package pl.sdacademy.coronavirus;

import java.util.*;

public class ApiObjectToEntityMapper {
    private static Long casesBefore = 0L;
    private static Long deathsBefore = 0L;
    private static Long recoveredBefore = 0L;
    private static String countryBefore = "xyzSomething";

    public List<DateCountryCovidStatus> map(List<CovidDataForDateAndCountryFromAPI> listDataFromAPI) {
            listDataFromAPI.sort(Comparator.comparing(CovidDataForDateAndCountryFromAPI::getDate));
            listDataFromAPI.sort(Comparator.comparing(CovidDataForDateAndCountryFromAPI::getCountryName));

            // since we don't have all numbers in our dataset, calculating them here
            // also adding the Country (as Country object rather than String)
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
                                        Math.max(recoveredBefore, covidRow.getTotalRecovered()) - recoveredBefore
                                ));
                        casesBefore = covidRow.getTotalCases();
                        deathsBefore = covidRow.getTotalDeaths();
                        recoveredBefore = Math.max(recoveredBefore, covidRow.getTotalRecovered());
                    });

        return covidUpdates;
    }
}