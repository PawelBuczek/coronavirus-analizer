package pl.sdacademy.coronavirus.exporting;

import pl.sdacademy.coronavirus.Country;

import java.util.List;

public interface EntityDataProvider {
    List<Country> load();
}
