package com.event.eventapp.event.event.service;

import com.event.eventapp.event.event.model.EventModel;
import com.event.eventapp.event.event.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository repository;

    public List<EventModel> getEvents() {
        return this.repository.findAll();
    }
}
