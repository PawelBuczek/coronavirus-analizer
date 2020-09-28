package pl.sdacademy.coronavirus;

import java.util.List;

public interface EntityDataProvider {
    public List<Country> load();
}
