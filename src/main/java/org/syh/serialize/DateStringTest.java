package org.syh.serialize;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class DateStringTest {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

        String dateAlpha = "2023-01-02T15:00:10+08:00";
        OffsetDateTime offsetDateTimeAlpha = OffsetDateTime.parse(dateAlpha, formatter);
        System.out.println(offsetDateTimeAlpha);

        String dateBeta = "2023-01-02T15:00:10Z";
        OffsetDateTime offsetDateTimeBeta = OffsetDateTime.parse(dateBeta, formatter);
        System.out.println(offsetDateTimeBeta);

        String dateGamma = "2023-01-02T15:00:10.011Z";
        OffsetDateTime offsetDateTimeGamma = OffsetDateTime.parse(dateGamma, formatter);
        System.out.println(offsetDateTimeGamma);

        String dateDelta = "2023-01-02T15:00:10.011-08:00";
        OffsetDateTime offsetDateTimeDelta = OffsetDateTime.parse(dateDelta, formatter);
        System.out.println(offsetDateTimeDelta);
    }
}
