package de.WaDelch.RequestCatcher.Model;


import de.WaDelch.RequestCatcher.Service.HashMapConverter;
import de.WaDelch.RequestCatcher.Service.TimeService;
import jakarta.persistence.*;

import java.util.Map;

@Entity
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    private final String dateTime;

    @Column(length=0)
    @Convert(converter = HashMapConverter.class)
    private Map<String, Object> data;

    public Request(Map<String, Object> daten) {
        this.data = daten;
        this.dateTime = TimeService.setCurrentDateTime();
    }

    public Request() {
        this.dateTime = TimeService.setCurrentDateTime();
    }


    public String getDateTime() { return dateTime; }

    public Map<String, Object> getData() {
        return data;
    }
}
