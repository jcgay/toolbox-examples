package fr.jcgay.example.java.time;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Time {

    public static void main(String[] args) {

        LocalTime time1 = LocalTime.of(13, 37, 26);
        LocalTime time2 = LocalTime.of(15, 47, 54);

        assert time1.isBefore(time2) == true;

        LocalTime time3 = time1.plusMinutes(5);

        assert ChronoUnit.HOURS.between(time1, time2) == 2;
        assert ChronoUnit.MINUTES.between(time1, time3) == 5;

        time1.format(DateTimeFormatter.ISO_LOCAL_TIME); // 13:37:26
        time3.format(DateTimeFormatter.ofPattern("Ha")); // 13PM

        DateTimeFormatter formatter = DateTimeFormatter
                .ofLocalizedTime(FormatStyle.SHORT)
                .withLocale(Locale.FRANCE);
        LocalTime time4 = LocalTime.parse("17:17", formatter);

        assert time4.getHour() == 17;
        assert time4.getMinute() == 17;
    }

}
