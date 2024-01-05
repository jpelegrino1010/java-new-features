package com.example.javanewfeatures.times;

import java.time.*;

public class InstanceDemo {

    public static void main(String[] args) {

        Instant instant = Instant.ofEpochSecond(7);
        System.out.println(instant);

        Instant now= Instant.now();
        System.out.println(now);

//        DURATION
        Duration duration = Duration.between(instant,now);
        System.out.println(duration);

        LocalTime time = LocalTime.now();
        LocalTime later= time.plusHours(8);

        Duration testDuration= Duration.between(time,later);
        System.out.println(testDuration);

        LocalDate date= LocalDate.now();
        LocalDate dateLater= LocalDate.of(1980,11,25);

        Period period= Period.between(dateLater,date);
        System.out.println(period);
        System.out.println(period.getYears());
    }
}
