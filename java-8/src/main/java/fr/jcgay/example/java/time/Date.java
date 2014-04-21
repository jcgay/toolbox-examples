package fr.jcgay.example.java.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Date {

    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        LocalDate yesterday = today.minusDays(1);

        LocalDate birthday = LocalDate.of(2014, Month.DECEMBER, 18);
        assert birthday.getDayOfWeek() == DayOfWeek.THURSDAY;

        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)
                .withLocale(Locale.FRANCE);
        LocalDate date = LocalDate.parse("14 juillet 2014", formatter);

        assert date.getDayOfMonth() == 14;
        assert date.getMonth() == Month.JULY;
        assert date.getYear() == 2014;
    }
}
