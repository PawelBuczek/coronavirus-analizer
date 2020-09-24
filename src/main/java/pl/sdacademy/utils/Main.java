package pl.sdacademy.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DateUtils dateUtils = new DateUtils();
        List<LocalDate> listOfDates = new ArrayList<>();
        listOfDates.add(LocalDate.of(1993,11,16));
        listOfDates.add(LocalDate.of(1993,11,16));
        listOfDates.add(LocalDate.of(1993,11,15));
        System.out.println(dateUtils.datesMissing(listOfDates));


    }
}
