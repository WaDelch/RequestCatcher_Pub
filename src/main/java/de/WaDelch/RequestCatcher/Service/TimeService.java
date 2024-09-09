package de.WaDelch.RequestCatcher.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeService {

    public static String setCurrentDateTime() {
        String pattern = "yyyy.MM.dd, HH:mm:ss";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        return dtf.format((LocalDateTime.now()));
    }
}
