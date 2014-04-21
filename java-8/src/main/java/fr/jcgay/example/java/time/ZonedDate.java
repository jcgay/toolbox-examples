package fr.jcgay.example.java.time;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ZonedDate {

    public static void main(String[] args) {

        ZonedDateTime today = ZonedDateTime.now(ZoneId.of("Europe/Paris"));
        System.out.println(today.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));

        // 2014-04-21T20:26:53.275+02:00[Europe/Paris]

    }
}
