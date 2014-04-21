package fr.jcgay.example.java.time;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

public class Clok {

    public static void main(String[] args) {

        Instant now = Clock.system(ZoneId.of("Europe/Paris")).instant();
        // 2014-04-21T19:36:37.786Z

        long millis = Clock.systemDefaultZone().millis();
        // 1398109144935
    }
}
