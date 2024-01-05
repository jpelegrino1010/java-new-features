package com.example.javanewfeatures.times;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.AbstractMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ZoneDemo {
    public static void main(String[] args) {
//        printAllZones();

        LocalDate date= LocalDate.of(2008,6,16);
        String baseISO= date.format(DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(baseISO);

        String localISO= date.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(localISO);


        LocalDate baseISODate = LocalDate.parse("19801125",DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(baseISODate);

        LocalDate localIsoDate = LocalDate.parse("1980-11-25",DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(localIsoDate);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy");
        LocalDate localDate = LocalDate.of(2008,6,18);
        String formattedDate = localDate.format(formatter);
        System.out.println(formattedDate);



    }

    private static void printAllZones() {
        LocalDateTime localDateTime = LocalDateTime.now();

        Map<String,String> result= ZoneId.getAvailableZoneIds().stream().map(ZoneId :: of)
                .map(zoneId -> new AbstractMap.SimpleEntry<>(zoneId.toString(),
                        localDateTime.atZone(zoneId).getOffset().getId().replaceAll("Z","+00:00")))
                .sorted(false ? Map.Entry.comparingByKey() : Map.Entry.<String,String>comparingByValue().reversed())
                .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue,(oldValue, newValue)-> oldValue,
                LinkedHashMap::new));

        result.forEach((k,v) -> System.out.printf(String.format("%s (%s) %n",k, v)));

        System.out.println("\nTotal Zone IDs supported "+ result.size());
    }
}
