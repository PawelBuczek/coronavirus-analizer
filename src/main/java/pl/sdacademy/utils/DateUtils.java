package pl.sdacademy.utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;

public class DateUtils {

    //Zadanie D2
    public long daysBetween(LocalDate startDate, LocalDate endDate) {
        return startDate.until(endDate, ChronoUnit.DAYS);
    }

    // Zadanie D3
    public boolean datesMissing(List<LocalDate> dateList) {
        System.out.println(daysBetween(LocalDate.of(1993, 11, 15), LocalDate.of(1993, 11, 15)));
        Collections.sort(dateList);
        boolean result = true;
        int count = 0;
        for (int i = 0; i < dateList.size() - 1; i++) {
            LocalDate date1 = dateList.get(i);
            LocalDate date2 = dateList.get(i + 1);
            if (date1.plusDays(1).equals(date2)) {
                count++;
            }
        }
        return count != dateList.size() - 1;
    }

    //Zadanie D4
    public long daysBetweenFromList(List<LocalDate> dateList) {
        LocalDate minDate = Collections.min(dateList);
        LocalDate maxDate = Collections.max(dateList);
        return minDate.until(maxDate, ChronoUnit.DAYS);
    }
}
