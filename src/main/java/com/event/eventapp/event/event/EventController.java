package com.event.eventapp.event.event;

import com.event.eventapp.event.event.model.EventModel;
import com.event.eventapp.event.event.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventController {

    private EventService service;

    @GetMapping("/events")
    public ResponseEntity<List<EventModel>> getEvents() {
        return ResponseEntity.ok(this.service.getEvents());
    }
}
