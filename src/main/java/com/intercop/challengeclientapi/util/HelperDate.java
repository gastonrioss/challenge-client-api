package com.intercop.challengeclientapi.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HelperDate {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static LocalDate toDate(String timezone)  {
        return  LocalDate.parse(timezone,formatter);
    }

    public static String toString(LocalDate localDate) {
       return localDate.format(formatter);
    }
}
