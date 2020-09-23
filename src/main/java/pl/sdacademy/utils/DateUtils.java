package pl.sdacademy.utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;

public class DateUtils {

    //Zadanie D2
    public long daysBetween (LocalDate startDate, LocalDate endDate) {
        return startDate.until(endDate, ChronoUnit.DAYS);
    }
    //Zadanie D4
    public long daysBetweenFromList(List<LocalDate> dateList){
        LocalDate minDate = Collections.min(dateList);
        LocalDate maxDate = Collections.max(dateList);
        return minDate.until(maxDate,ChronoUnit.DAYS);
    }
}
