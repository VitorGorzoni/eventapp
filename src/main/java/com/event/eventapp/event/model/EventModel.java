package com.event.eventapp.event.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class EventModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    public String name;

    @Column(name = "dateTime")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    public LocalDateTime dateTime;

    @Column(name = "price")
    public Double price;
}
