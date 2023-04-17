package com.event.eventapp.event.service;

import com.event.eventapp.event.model.EventMapper;
import com.event.eventapp.event.model.EventModel;
import com.event.eventapp.event.repository.EventRepository;
import com.event.eventapp.infrastructure.exceptions.NotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private EventRepository repository;

    public List<EventModel> getEvents() {
        LOGGER.info("Listando os eventos");

        return this.repository.findAll();
    }

    public EventModel createEvent(EventModel eventModel) {
        LOGGER.info("Salvando o evento " + eventModel);

        return this.repository.save(eventModel);
    }

    public EventModel updateEvent(Integer id, EventModel eventModel) {
        LOGGER.info("Alterando o evento " + eventModel);

        var event = this.repository.findById(id).orElseThrow(() -> new NotFoundException("Não foi encontrado um evento com o ID " + id));

        EventMapper mapper = Mappers.getMapper(EventMapper.class    );
        mapper.update(event, eventModel);

        return this.repository.save(event);
    }

    public void deleteEvent(Integer id) {
        var eventModel = this.repository.findById(id).orElseThrow(() -> new NotFoundException("Não foi encontrado um evento com o ID " + id));

        LOGGER.info("Deletando o evento " + eventModel);
        this.repository.delete(eventModel);
    }
}
