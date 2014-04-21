package fr.jcgay.example.java.time;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class DurationAmount {

    public static void main(String[] args) {

        Duration twentySeconds = Duration.parse("PT20S");
        assert twentySeconds.getSeconds() == 20;

        Duration oneMinuteTwentySeconds = Duration.ofMinutes(1).plus(twentySeconds);
        assert oneMinuteTwentySeconds.getSeconds() == 80;

        LocalTime time1 = LocalTime.of(21, 30, 17);
        LocalTime time2 = LocalTime.of(22, 40, 37);
        Duration duration = Duration.between(time1, time2); // PT1H10M20S
        assert duration.get(ChronoUnit.SECONDS) == 3600 + 600 + 20;
    }
}
