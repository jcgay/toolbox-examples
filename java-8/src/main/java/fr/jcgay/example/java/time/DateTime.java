package fr.jcgay.example.java.time;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

public class DateTime {

    public static void main(String[] args) {

        LocalDateTime time = LocalDateTime.of(2014, Month.DECEMBER, 25, 12, 10);
        assert time.get(ChronoField.YEAR) == 2014;

        time.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")); // 25/12/2014 12:10

        Instant now = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant();
        // 2014-04-21T19:27:26.759Z

        java.util.Date.from(now);
    }
}
