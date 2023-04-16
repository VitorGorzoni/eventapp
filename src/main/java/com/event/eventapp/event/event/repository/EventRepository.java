package com.event.eventapp.event.event.repository;

import com.event.eventapp.event.event.model.EventModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<EventModel, String> {
}
