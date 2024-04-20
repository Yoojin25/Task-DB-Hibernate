package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatting {
    public static String authorBirthDate(int year, int month, int day) {
        LocalDate date = LocalDate.of(year, month, day);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return date.format(dateFormat);
    }
}
