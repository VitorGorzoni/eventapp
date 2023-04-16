package com.event.eventapp.event.event.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class EventModel {

    @Id
    private UUID uuid;
    public String name;
    public LocalDateTime dateTime;
    public Double price;
}
