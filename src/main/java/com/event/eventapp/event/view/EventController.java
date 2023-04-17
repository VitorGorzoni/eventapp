package com.event.eventapp.event.view;

import com.event.eventapp.event.model.EventModel;
import com.event.eventapp.event.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {

    @Autowired
    private EventService service;

    @GetMapping("/events")
    public ResponseEntity<List<EventModel>> getEvents() {
        return ResponseEntity.ok(this.service.getEvents());
    }

    @PostMapping("/events")
    public ResponseEntity<EventModel> createEvent(@RequestBody EventModel eventModel) {
        return new ResponseEntity<>(this.service.createEvent(eventModel), HttpStatus.CREATED);
    }

    @PatchMapping("/events/{id}")
    public ResponseEntity<EventModel> updateEvent(@PathVariable Integer id, @RequestBody EventModel eventModel) {
        return new ResponseEntity<>(this.service.updateEvent(id, eventModel), HttpStatus.OK);
    }

    @DeleteMapping("/events/{id}")
    public void deleteEvent(@PathVariable Integer id) {
        this.service.deleteEvent(id);
    }
}
