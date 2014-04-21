package fr.jcgay.example.java.time;

import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.Locale;

public class TimeZone {

    public static void main(String[] args) {

        ZoneId.getAvailableZoneIds();
        // [Asia/Aden, America/Cuiaba, Etc/GMT+9, Etc/GMT+8, Africa/Nairobi, America/Marigot...

        ZoneId paris = ZoneId.of("Europe/Paris");
        paris.getDisplayName(TextStyle.FULL, Locale.FRENCH); // Heure d'Europe centrale
        paris.getDisplayName(TextStyle.SHORT, Locale.FRENCH); // CET
    }
}
